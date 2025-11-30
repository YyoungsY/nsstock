package com.example.stocks.service;

import com.example.stocks.dto.ai.PredictionDetailDto;
import com.example.stocks.dto.ai.StockPredictionDto;
import com.example.stocks.entity.stock.PredictedStockPriceEn;
import com.example.stocks.entity.stock.enumeration.TargetDays;
import com.example.stocks.repository.stock.PredictedStockPriceRe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AiService {

    private final PredictedStockPriceRe predictedStockPriceRepository;

    @Transactional(readOnly = true)
    public List<StockPredictionDto> getAllLatestPredictions() {
        // DB에서 모든 최신 예측 데이터를 가져옴 (리스트 형태)
        List<PredictedStockPriceEn> allPredictions = predictedStockPriceRepository.findAllLatestPredictions();

        // 종목 코드(shortCode)를 키(Key)로 사용하여 데이터를 그룹화
        Map<String, StockPredictionDto> map = new HashMap<>();

        for (PredictedStockPriceEn p : allPredictions) {
            String code = p.getStockInfo().getShortCode();
            String name = p.getStockInfo().getKorStockName();

            // 맵에 해당 종목이 없으면 새로 생성해서 넣음
            map.putIfAbsent(code, new StockPredictionDto(code, name));

            // 맵에서 해당 종목 DTO를 꺼냄
            StockPredictionDto dto = map.get(code);

            // 5일, 20일, 60일 구분에 따라 데이터 채워 넣기
            PredictionDetailDto detail = new PredictionDetailDto(p.getPredictionDate(), p.getPredictedClosingPrice());

            if (p.getTargetDays() == TargetDays.FIVE) {
                dto.setPrediction5d(detail);
            } else if (p.getTargetDays() == TargetDays.TWENTY) {
                dto.setPrediction20d(detail);
            } else if (p.getTargetDays() == TargetDays.SIXTY) {
                dto.setPrediction60d(detail);
            }
        }

        // 맵의 값들만 반환
        return new ArrayList<>(map.values());
    }
}
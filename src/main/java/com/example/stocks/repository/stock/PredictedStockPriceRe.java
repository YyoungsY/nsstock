package com.example.stocks.repository.stock;

import com.example.stocks.entity.stock.PredictedStockPriceEn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PredictedStockPriceRe extends JpaRepository<PredictedStockPriceEn, Long> {

    // 모든 종목의 가장 최신(createdAt 기준) 예측 데이터 목록 조회
    // JOIN FETCH를 사용하여 주식 정보까지 한 번에 가져와 성능 최적화
    @Query("SELECT p FROM PredictedStockPriceEn p JOIN FETCH p.stockInfo " +
            "WHERE p.createdAt = (SELECT MAX(p2.createdAt) FROM PredictedStockPriceEn p2 WHERE p2.stockInfo.shortCode = p.stockInfo.shortCode)")
    List<PredictedStockPriceEn> findAllLatestPredictions();
}
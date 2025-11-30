package com.example.stocks.dto.ai;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PredictionDetailDto {
    private LocalDate predictionDate;    // 예측 대상 날짜
    private int predictedClosingPrice;   // 예측 종가
}
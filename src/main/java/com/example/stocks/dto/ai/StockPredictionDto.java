package com.example.stocks.dto.ai;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockPredictionDto {
    private String shortCode;
    private String korStockName;
    private PredictionDetailDto prediction5d;  // 5일 뒤 예측
    private PredictionDetailDto prediction20d; // 20일 뒤 예측
    private PredictionDetailDto prediction60d; // 60일 뒤 예측

    public StockPredictionDto(String shortCode, String korStockName) {
        this.shortCode = shortCode;
        this.korStockName = korStockName;
    }
}
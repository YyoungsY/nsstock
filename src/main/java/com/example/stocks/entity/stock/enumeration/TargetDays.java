package com.example.stocks.entity.stock.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 예측 날짜 타입
@Getter
@AllArgsConstructor
public enum TargetDays {
    FIVE("5"),
    TWENTY("20"),
    SIXTY("60");

    private final String value;
}
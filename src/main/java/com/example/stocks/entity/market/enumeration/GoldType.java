package com.example.stocks.entity.market.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 금 단위
@Getter
@AllArgsConstructor
public enum GoldType {
    GOLD_1KG("금 99.99_1Kg"),
    MINI_GOLD_100G("미니금 99.99_100g");

    private final String label;
}
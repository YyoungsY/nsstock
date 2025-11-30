package com.example.stocks.entity.stock.enumeration;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/* @Converter 어노테이션에 autoApply = true 를 설정하면,
 StockType 사용하는 모든 엔티티 필드에 이 컨버터가 자동으로 적용.
 StockType Enum을 데이터베이스에 저장될 String 값으로 변환. */

@Converter(autoApply = true)
public class StockTypeConverter implements AttributeConverter<StockType, String> {
    @Override
    public String convertToDatabaseColumn(StockType stockType) {
        if (stockType == null) {
            return null;
        }
        return stockType.getLabel();
    }

    @Override
    public StockType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        for (StockType type : StockType.values()) {
            if (type.getLabel().equals(dbData)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown label: " + dbData);
    }
}
package com.example.stocks.entity.stock.enumeration;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/* @Converter 어노테이션에 autoApply = true 를 설정하면,
 TargetDays 사용하는 모든 엔티티 필드에 이 컨버터가 자동으로 적용.
 TargetDays Enum을 데이터베이스에 저장될 String 값으로 변환. */

@Converter(autoApply = true)
public class TargetDaysConverter implements AttributeConverter<TargetDays, String> {

    @Override
    public String convertToDatabaseColumn(TargetDays attribute) {
        if (attribute == null) return null;
        return attribute.getValue();
    }

    @Override
    public TargetDays convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        for (TargetDays type : TargetDays.values()) {
            if (type.getValue().equals(dbData)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + dbData);
    }
}
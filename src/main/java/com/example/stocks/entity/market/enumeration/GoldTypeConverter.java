package com.example.stocks.entity.market.enumeration;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/* @Converter 어노테이션에 autoApply = true 를 설정하면,
 GoldType을 사용하는 모든 엔티티 필드에 이 컨버터가 자동으로 적용.
 GoldType Enum을 데이터베이스에 저장될 String 값으로 변환. */

@Converter(autoApply = true)
public class GoldTypeConverter implements AttributeConverter<GoldType, String> {

    @Override
    public String convertToDatabaseColumn(GoldType goldType) {
        if (goldType == null) {
            return null;
        }
        return goldType.getLabel(); // Enum의 label 값을 DB에 저장
    }

    @Override
    public GoldType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        // 모든 Enum 상수를 순회하며 label 값이 일치하는 것을 찾아 반환
        for (GoldType type : GoldType.values()) {
            if (type.getLabel().equals(dbData)) {
                return type;
            }
        }
        // 일치하는 Enum이 없으면 예외 발생
        throw new IllegalArgumentException("Unknown label: " + dbData);
    }
}
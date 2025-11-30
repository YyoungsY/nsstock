package com.example.stocks.entity.market.enumeration;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/* @Converter 어노테이션에 autoApply = true 를 설정하면,
 OilType 사용하는 모든 엔티티 필드에 이 컨버터가 자동으로 적용.
 OilType Enum을 데이터베이스에 저장될 String 값으로 변환. */

@Converter(autoApply = true)
public class OilTypeConverter implements AttributeConverter<OilType, String> {

    @Override
    public String convertToDatabaseColumn(OilType oilType) {
        if (oilType == null) {
            return null;
        }
        return oilType.getLabel();
    }

    @Override
    public OilType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        for (OilType type : OilType.values()) {
            if (type.getLabel().equals(dbData)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown label: " + dbData);
    }
}
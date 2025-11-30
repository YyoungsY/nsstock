package com.example.stocks.entity.stock.enumeration;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/* @Converter 어노테이션에 autoApply = true 를 설정하면,
 CertificateType 사용하는 모든 엔티티 필드에 이 컨버터가 자동으로 적용.
 CertificateType Enum을 데이터베이스에 저장될 String 값으로 변환. */

@Converter(autoApply = true)
public class CertificateTypeConverter implements AttributeConverter<CertificateType, String> {
    @Override
    public String convertToDatabaseColumn(CertificateType certificateType) {
        if (certificateType == null) {
            return null;
        }
        return certificateType.getLabel();
    }

    @Override
    public CertificateType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        for (CertificateType type : CertificateType.values()) {
            if (type.getLabel().equals(dbData)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown label: " + dbData);
    }
}
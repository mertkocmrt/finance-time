package com.finance.time.common;

import lombok.Data;

public enum ExceptionEnum {
    ERROR_ENTITY_NOT_FOUND(1,"Geri döndürülecek obje yok."), INTERNAL_SERVER_ERROR(2, "İşlem sırasında hata."), SERVICE_PROVIDER_ERROR(3, "Servis sağlayıcıda hata.");

    private int key;
    private String value;

    ExceptionEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

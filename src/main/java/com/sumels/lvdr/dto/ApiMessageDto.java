package com.sumels.lvdr.dto;

import lombok.Data;

@Data
public class ApiMessageDto<T> {
    private Boolean result = true;
    private String code = null;
    private T data = null;
    private String message = null;

    public ApiMessageDto(boolean result, String code, String message) {
        this.result=result;
        this.code=code;
        this.message=message;
        this.data=null;
    }
    public ApiMessageDto() {
    }

}

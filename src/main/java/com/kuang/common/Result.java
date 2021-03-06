package com.kuang.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Result {
    private String status;
    private Object data;
    private String message;

    public Result(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    public Result(String status, String message) {
        this.status = status;
        this.message = message;
    }



    public Result(String status, Object data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
}

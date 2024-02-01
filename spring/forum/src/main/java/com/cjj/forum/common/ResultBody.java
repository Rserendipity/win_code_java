package com.cjj.forum.common;

import lombok.Data;

@Data
public class ResultBody {
    private int code;
    private String message;
    private Object data;


    public ResultBody(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultBody success() {
        return success(null);
    }

    public static ResultBody success(Object object) {
        return new ResultBody(ReturnCode.SUCCESS.getCode(), ReturnCode.SUCCESS.getMessage(), object);
    }

    public static ResultBody fail(ReturnCode code) {
        return fail(code, null);
    }

    public static ResultBody fail(ReturnCode code, Object data) {
        return new ResultBody(code.getCode(), code.getMessage(), data);
    }

}

package com.adgile.util;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

    private T data;
    private String result;
    private String message;

    public static final ApiResponse<String> OK = new ApiResponse<>("", "200", "OK");

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, "200", "OK");
    }

    public static ApiResponse<Object> error(String result, String message) {
        return new ApiResponse<>("", result, message);
    }

}


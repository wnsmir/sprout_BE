package com.example.sprout_BE.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 404 NOT_FOUND: 리소스를 찾을 수 없음
    STOCK_NOT_FOUND(HttpStatus.NOT_FOUND, "해당하는 종목을 찾을 수 없습니다."),

    // 500 INTERNAL_SERVER_ERROR: 서버 내부 오류
    CLOVA_API_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "외부 API 호출 중 오류가 발생했습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버에 오류가 발생했습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
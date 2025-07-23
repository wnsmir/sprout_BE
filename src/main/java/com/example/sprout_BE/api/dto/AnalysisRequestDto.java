package com.example.sprout_BE.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AnalysisRequestDto {
    private String stockCode; // "005930"과 같은 종목 코드를 받기 위한 필드
}
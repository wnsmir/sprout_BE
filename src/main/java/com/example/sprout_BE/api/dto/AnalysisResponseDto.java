package com.example.sprout_BE.api.dto;

import com.example.sprout_BE.domain.analysis.InvestmentOpinion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class AnalysisResponseDto {
    private String stockName;
    private InvestmentOpinion opinion;
    private String reasoningText;
    private LocalDate reportDate;
}
package com.example.sprout_BE.api;

import com.example.sprout_BE.api.dto.AnalysisRequestDto;
import com.example.sprout_BE.api.dto.AnalysisResponseDto;
import com.example.sprout_BE.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/analysis")
public class AnalysisController {

    private final AnalysisService analysisService;

    @PostMapping
    public ResponseEntity<AnalysisResponseDto> getAnalysis(
            @RequestBody AnalysisRequestDto requestDto
    ) {
        AnalysisResponseDto response = analysisService.getAnalysis(requestDto.getStockCode());
        return ResponseEntity.ok(response);
    }
}
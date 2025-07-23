package com.example.sprout_BE.service;

import com.example.sprout_BE.api.dto.AnalysisResponseDto;
import com.example.sprout_BE.common.exception.BusinessException;
import com.example.sprout_BE.common.exception.ErrorCode;
import com.example.sprout_BE.domain.analysis.AnalysisReport;
import com.example.sprout_BE.domain.analysis.AnalysisReportRepository;
import com.example.sprout_BE.domain.analysis.InvestmentOpinion;
import com.example.sprout_BE.domain.stock.Stock;
import com.example.sprout_BE.domain.stock.StockRepository;
import com.example.sprout_BE.external.ClovaApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.sprout_BE.common.exception.ErrorCode;

@Service
@RequiredArgsConstructor
public class AnalysisService {

    private final StockRepository stockRepository;
    private final AnalysisReportRepository analysisReportRepository;
    private final ClovaApiClient clovaApiClient;

    @Transactional
    public AnalysisResponseDto getAnalysis(String stockCode) {
        // 1. DB에서 주식 정보 조회, 없으면 예외 발생
        Stock stock = stockRepository.findByStockCode(stockCode)
                .orElseThrow(() -> new BusinessException(ErrorCode.STOCK_NOT_FOUND));

        // 2. 외부 API로 데이터 수집 (뉴스, 시세 등) - 지금은 임시 데이터
        String collectedData = "최신 뉴스 데이터...";

        // 3. Clova API 호출
        String clovaResponse = clovaApiClient.getOpinionFromClova(stock.getStockName(), collectedData);

        // 4. Clova 응답 파싱 (실제로는 더 정교한 로직 필요)
        InvestmentOpinion opinion = InvestmentOpinion.BUY; // 예시
        String reasoning = clovaResponse;

        // 5. 분석 결과 DB에 저장
        AnalysisReport report = AnalysisReport.builder()
                .stock(stock)
                .opinion(opinion)
                .reasoningText(reasoning)
                .build();
        analysisReportRepository.save(report);

        // 6. DTO로 변환하여 Controller에 반환
        return new AnalysisResponseDto(
                stock.getStockName(),
                report.getOpinion(),
                report.getReasoningText(),
                report.getReportDate()
        );
    }
}
package com.example.sprout_BE.domain.analysis;

import com.example.sprout_BE.domain.stock.Stock;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AnalysisReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @Enumerated(EnumType.STRING) // Enum 이름을 DB에 문자열로 저장
    @Column(nullable = false)
    private InvestmentOpinion opinion;

    @Lob // 긴 텍스트 저장을 위한 어노테이션
    @Column(nullable = false)
    private String reasoningText;

    @Column(nullable = false)
    private LocalDate reportDate;

    @Builder
    public AnalysisReport(Stock stock, InvestmentOpinion opinion, String reasoningText) {
        this.stock = stock;
        this.opinion = opinion;
        this.reasoningText = reasoningText;
        this.reportDate = LocalDate.now();
    }
}
package com.example.sprout_BE.domain.analysis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalysisReportRepository extends JpaRepository<AnalysisReport, Long> {
    // 필요한 경우 여기에 커스텀 쿼리 메소드를 추가할 수 있습니다.
}
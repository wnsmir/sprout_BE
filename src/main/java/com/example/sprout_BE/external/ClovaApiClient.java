package com.example.sprout_BE.external;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class ClovaApiClient {

    // private final WebClient webClient; // WebClientConfig 설정 후 주석 해제

    public String getOpinionFromClova(String stockName, String data) {
        String prompt = String.format(
                "다음 데이터를 바탕으로 '%s' 종목에 대한 투자 의견을 '강력매수', '매수', '보유', '매도', '강력매도' 중 하나로 제시하고, 그 핵심적인 근거를 500자 내외로 설명해줘:\n\n%s",
                stockName, data
        );

        // TODO: WebClient를 사용하여 실제 HyperCLOVA X API 호출 로직 구현
        System.out.println("Clova API에 전송될 프롬프트: " + prompt);

        // 임시 응답
        return "최근 반도체 시장의 긍정적 전망과 실적 개선에 따라 '매수' 의견을 제시합니다...";
    }
}
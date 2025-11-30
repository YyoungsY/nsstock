package com.example.stocks.controller;

import com.example.stocks.dto.ai.StockPredictionDto;
import com.example.stocks.service.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AiController {

    private final AiService aiService;

    // 모든 종목의 최신 AI 주가 예측 정보를 조회.
    @GetMapping("/predictions")
    public List<StockPredictionDto> getAllPredictions() {
        return aiService.getAllLatestPredictions();
    }
}
package pl.backend.assesment.feature.analytics.controller;

import pl.backend.assesment.feature.analytics.dto.ProducerAnalyticsDto;
import pl.backend.assesment.feature.analytics.service.ProducerAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.path}/analytics/producers")
@RequiredArgsConstructor
public class ProducerAnalyticsController {

    private final ProducerAnalyticsService producerAnalyticsService;

    @GetMapping
    public ResponseEntity<ProducerAnalyticsDto> getProducerAnalytics() {
        return ResponseEntity.ok(producerAnalyticsService.generateProducerAnalytics());
    }
}

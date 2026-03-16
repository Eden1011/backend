package pl.backend.assesment.feature.analytics.dto;

import lombok.Data;
import java.util.List;

@Data
public class ProducerAnalyticsDto {
    private List<ProducerSummaryDto> highValueProducers;
    private List<ProducerSummaryDto> inactiveProducers;
    private List<ProducerSegmentDto> producerSegments;
}

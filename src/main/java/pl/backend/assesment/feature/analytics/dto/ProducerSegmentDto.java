package pl.backend.assesment.feature.analytics.dto;

import lombok.Data;
import java.util.List;

@Data
public class ProducerSegmentDto {
    private String segmentName;
    private List<ProducerSummaryDto> producers;
    private int producerCount;
}

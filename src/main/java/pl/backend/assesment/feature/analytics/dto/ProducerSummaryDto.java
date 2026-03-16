package pl.backend.assesment.feature.analytics.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProducerSummaryDto {
    private Long producerId;
    private String producerName;
    private BigDecimal totalRevenue;
    private int totalProducts;
    private Date lastProductDate;
    private Date producerSince;
}

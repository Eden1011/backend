package pl.backend.assesment.feature.analytics.service;

import java.util.List;

public interface LogService {
    void logMetrics(Long producerId, List<String> metrics);
}

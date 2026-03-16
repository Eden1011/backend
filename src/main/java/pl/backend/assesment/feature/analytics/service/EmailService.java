package pl.backend.assesment.feature.analytics.service;

public interface EmailService {
    void sendReactivationEmail(Long producerId, String producerName);
}

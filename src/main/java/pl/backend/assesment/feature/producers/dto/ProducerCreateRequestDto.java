package pl.backend.assesment.feature.producers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProducerCreateRequestDto(@NotBlank @Size(min = 1, max = 255) String name) {}

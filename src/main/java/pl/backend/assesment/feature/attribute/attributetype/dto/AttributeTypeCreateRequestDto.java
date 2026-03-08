package pl.backend.assesment.feature.attribute.attributetype.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AttributeTypeCreateRequestDto(@NotBlank @Size(min = 1, max = 255) String name) {}

package pl.backend.assesment.feature.attribute.productsattribute.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AttributeValueRequestDto(@NotNull Long attributeTypeId, @NotBlank String value) {}

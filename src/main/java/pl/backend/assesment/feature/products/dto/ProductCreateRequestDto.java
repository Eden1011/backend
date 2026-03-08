package pl.backend.assesment.feature.products.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import pl.backend.assesment.feature.attribute.productsattribute.dto.AttributeValueRequestDto;

public record ProductCreateRequestDto(
    @NotBlank @Size(min = 1, max = 255) String name,
    @NotNull Long producerId,
    @Valid List<AttributeValueRequestDto> attributes) {}

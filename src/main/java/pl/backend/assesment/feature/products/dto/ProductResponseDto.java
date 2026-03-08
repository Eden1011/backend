package pl.backend.assesment.feature.products.dto;

import java.util.List;
import pl.backend.assesment.feature.attribute.productsattribute.dto.ProductAttributeResponseDto;

public record ProductResponseDto(
    Long id,
    String name,
    Long producerId,
    String producerName,
    List<ProductAttributeResponseDto> attributes) {}

package pl.backend.assesment.feature.attribute.productsattribute.dto;

public record ProductAttributeResponseDto(
    Long id, Long attributeTypeId, String attributeTypeName, String value) {}

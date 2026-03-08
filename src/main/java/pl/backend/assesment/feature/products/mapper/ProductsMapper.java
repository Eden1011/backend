package pl.backend.assesment.feature.products.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import pl.backend.assesment.feature.attribute.productsattribute.dto.ProductAttributeResponseDto;
import pl.backend.assesment.feature.attribute.productsattribute.model.ProductsAttributeModel;
import pl.backend.assesment.feature.products.dto.ProductCreateRequestDto;
import pl.backend.assesment.feature.products.dto.ProductResponseDto;
import pl.backend.assesment.feature.products.model.ProductsModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductsMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "producer", ignore = true)
  @Mapping(target = "attributes", ignore = true)
  ProductsModel toEntity(ProductCreateRequestDto dto);

  @Mapping(target = "producerId", source = "producer.id")
  @Mapping(target = "producerName", source = "producer.name")
  ProductResponseDto toResponseDto(ProductsModel model);

  List<ProductResponseDto> toResponseDtoList(List<ProductsModel> models);

  @Mapping(target = "attributeTypeId", source = "attributeType.id")
  @Mapping(target = "attributeTypeName", source = "attributeType.name")
  ProductAttributeResponseDto toAttributeResponseDto(ProductsAttributeModel attribute);
}

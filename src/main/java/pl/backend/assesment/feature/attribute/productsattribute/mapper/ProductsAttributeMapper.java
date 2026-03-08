package pl.backend.assesment.feature.attribute.productsattribute.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import pl.backend.assesment.feature.attribute.productsattribute.dto.ProductAttributeResponseDto;
import pl.backend.assesment.feature.attribute.productsattribute.model.ProductsAttributeModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductsAttributeMapper {
  @Mapping(target = "attributeTypeId", source = "attributeType.id")
  @Mapping(target = "attributeTypeName", source = "attributeType.name")
  ProductAttributeResponseDto toResponseDto(ProductsAttributeModel model);

  List<ProductAttributeResponseDto> toResponseDtoList(List<ProductsAttributeModel> models);
}

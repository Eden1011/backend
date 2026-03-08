package pl.backend.assesment.feature.attribute.attributetype.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import pl.backend.assesment.feature.attribute.attributetype.dto.AttributeTypeCreateRequestDto;
import pl.backend.assesment.feature.attribute.attributetype.dto.AttributeTypeResponseDto;
import pl.backend.assesment.feature.attribute.attributetype.model.AttributeTypeModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AttributeTypeMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "productAttributes", ignore = true)
  AttributeTypeModel toEntity(AttributeTypeCreateRequestDto dto);

  AttributeTypeResponseDto toResponseDto(AttributeTypeModel model);

  List<AttributeTypeResponseDto> toResponseDtoList(List<AttributeTypeModel> models);
}

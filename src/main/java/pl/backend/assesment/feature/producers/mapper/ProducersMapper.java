package pl.backend.assesment.feature.producers.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import pl.backend.assesment.feature.producers.dto.ProducerCreateRequestDto;
import pl.backend.assesment.feature.producers.dto.ProducerResponseDto;
import pl.backend.assesment.feature.producers.model.ProducersModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProducersMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "products", ignore = true)
  ProducersModel toEntity(ProducerCreateRequestDto dto);

  ProducerResponseDto toResponseDto(ProducersModel model);

  List<ProducerResponseDto> toResponseDtoList(List<ProducersModel> models);
}

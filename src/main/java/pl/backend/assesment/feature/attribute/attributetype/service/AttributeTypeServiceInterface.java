package pl.backend.assesment.feature.attribute.attributetype.service;

import java.util.List;
import pl.backend.assesment.feature.attribute.attributetype.dto.AttributeTypeCreateRequestDto;
import pl.backend.assesment.feature.attribute.attributetype.model.AttributeTypeModel;

public interface AttributeTypeServiceInterface {
  List<AttributeTypeModel> getAllAttributeTypes();

  AttributeTypeModel getAttributeType(Long id);

  AttributeTypeModel createAttributeType(AttributeTypeCreateRequestDto dto);
}

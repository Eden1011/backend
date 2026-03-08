package pl.backend.assesment.feature.attribute.attributetype.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.backend.assesment.core.exception.BusinessException;
import pl.backend.assesment.core.exception.BusinessExceptionReasonEnum;
import pl.backend.assesment.feature.attribute.attributetype.dto.AttributeTypeCreateRequestDto;
import pl.backend.assesment.feature.attribute.attributetype.mapper.AttributeTypeMapper;
import pl.backend.assesment.feature.attribute.attributetype.model.AttributeTypeModel;
import pl.backend.assesment.feature.attribute.attributetype.repository.AttributeTypeRepository;

@Service
@RequiredArgsConstructor
public class AttributeTypeService implements AttributeTypeServiceInterface {
  private final AttributeTypeRepository attributeTypeRepository;
  private final AttributeTypeMapper attributeTypeMapper;

  @Override
  @Transactional(readOnly = true)
  public List<AttributeTypeModel> getAllAttributeTypes() {
    return attributeTypeRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public AttributeTypeModel getAttributeType(Long id) {
    return getOrThrow(id);
  }

  @Override
  @Transactional
  public AttributeTypeModel createAttributeType(AttributeTypeCreateRequestDto dto) {
    if (attributeTypeRepository.existsByName(dto.name())) {
      throw new BusinessException(BusinessExceptionReasonEnum.ATTRIBUTE_TYPE_NAME_ALREADY_EXISTS);
    }
    return attributeTypeRepository.save(attributeTypeMapper.toEntity(dto));
  }

  private AttributeTypeModel getOrThrow(Long id) {
    return attributeTypeRepository
        .findById(id)
        .orElseThrow(
            () -> new BusinessException(BusinessExceptionReasonEnum.ATTRIBUTE_TYPE_NOT_FOUND));
  }
}

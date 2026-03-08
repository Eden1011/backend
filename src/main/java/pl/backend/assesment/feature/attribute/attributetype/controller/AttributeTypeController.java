package pl.backend.assesment.feature.attribute.attributetype.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.backend.assesment.feature.attribute.attributetype.dto.AttributeTypeCreateRequestDto;
import pl.backend.assesment.feature.attribute.attributetype.dto.AttributeTypeResponseDto;
import pl.backend.assesment.feature.attribute.attributetype.mapper.AttributeTypeMapper;
import pl.backend.assesment.feature.attribute.attributetype.service.AttributeTypeServiceInterface;

@RestController
@RequestMapping("${api.path}/attribute-types")
@RequiredArgsConstructor
public class AttributeTypeController {
  private final AttributeTypeServiceInterface attributeTypeService;
  private final AttributeTypeMapper attributeTypeMapper;

  @GetMapping
  public ResponseEntity<List<AttributeTypeResponseDto>> getAttributeTypes() {
    return ResponseEntity.ok(
        attributeTypeMapper.toResponseDtoList(attributeTypeService.getAllAttributeTypes()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<AttributeTypeResponseDto> getAttributeType(@PathVariable Long id) {
    return ResponseEntity.ok(
        attributeTypeMapper.toResponseDto(attributeTypeService.getAttributeType(id)));
  }

  @PostMapping
  public ResponseEntity<AttributeTypeResponseDto> createAttributeType(
      @RequestBody @Valid AttributeTypeCreateRequestDto dto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(attributeTypeMapper.toResponseDto(attributeTypeService.createAttributeType(dto)));
  }
}

package pl.backend.assesment.feature.attribute.productsattribute.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.backend.assesment.feature.attribute.productsattribute.dto.ProductAttributeResponseDto;
import pl.backend.assesment.feature.attribute.productsattribute.mapper.ProductsAttributeMapper;
import pl.backend.assesment.feature.attribute.productsattribute.service.ProductsAttributeServiceInterface;

@RestController
@RequestMapping("${api.path}/products/{productId}/attributes")
@RequiredArgsConstructor
public class ProductsAttributeController {
  private final ProductsAttributeServiceInterface productsAttributeService;
  private final ProductsAttributeMapper productsAttributeMapper;

  @GetMapping
  public ResponseEntity<List<ProductAttributeResponseDto>> getProductAttributes(
      @PathVariable Long productId) {
    return ResponseEntity.ok(
        productsAttributeMapper.toResponseDtoList(
            productsAttributeService.getProductAttributes(productId)));
  }
}

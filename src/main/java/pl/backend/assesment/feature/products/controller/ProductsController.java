package pl.backend.assesment.feature.products.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.backend.assesment.feature.products.dto.ProductCreateRequestDto;
import pl.backend.assesment.feature.products.dto.ProductResponseDto;
import pl.backend.assesment.feature.products.dto.ProductUpdateRequestDto;
import pl.backend.assesment.feature.products.mapper.ProductsMapper;
import pl.backend.assesment.feature.products.service.ProductsServiceInterface;

@RestController
@RequestMapping("${api.path}/products")
@RequiredArgsConstructor
public class ProductsController {
  private final ProductsServiceInterface productsService;
  private final ProductsMapper productsMapper;

  @GetMapping
  public ResponseEntity<List<ProductResponseDto>> getProducts(
      @RequestParam(required = false) String name) {
    List<ProductResponseDto> products =
        name != null
            ? productsMapper.toResponseDtoList(productsService.searchByName(name))
            : productsMapper.toResponseDtoList(productsService.getAllProducts());
    return ResponseEntity.ok(products);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long id) {
    return ResponseEntity.ok(productsMapper.toResponseDto(productsService.getProduct(id)));
  }

  @PostMapping
  public ResponseEntity<ProductResponseDto> createProduct(
      @RequestBody @Valid ProductCreateRequestDto dto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(productsMapper.toResponseDto(productsService.createProduct(dto)));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductResponseDto> updateProduct(
      @PathVariable Long id, @RequestBody @Valid ProductUpdateRequestDto dto) {
    return ResponseEntity.ok(productsMapper.toResponseDto(productsService.updateProduct(id, dto)));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    productsService.deleteProduct(id);
    return ResponseEntity.noContent().build();
  }
}

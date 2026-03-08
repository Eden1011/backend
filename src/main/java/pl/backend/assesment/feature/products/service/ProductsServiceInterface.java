package pl.backend.assesment.feature.products.service;

import java.util.List;
import pl.backend.assesment.feature.products.dto.ProductCreateRequestDto;
import pl.backend.assesment.feature.products.dto.ProductUpdateRequestDto;
import pl.backend.assesment.feature.products.model.ProductsModel;

public interface ProductsServiceInterface {
  List<ProductsModel> getAllProducts();

  ProductsModel getProduct(Long id);

  ProductsModel createProduct(ProductCreateRequestDto dto);

  ProductsModel updateProduct(Long id, ProductUpdateRequestDto dto);

  void deleteProduct(Long id);
}

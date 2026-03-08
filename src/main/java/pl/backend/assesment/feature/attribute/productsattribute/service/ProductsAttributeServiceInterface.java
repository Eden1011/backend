package pl.backend.assesment.feature.attribute.productsattribute.service;

import java.util.List;
import pl.backend.assesment.feature.attribute.productsattribute.model.ProductsAttributeModel;

public interface ProductsAttributeServiceInterface {
  List<ProductsAttributeModel> getProductAttributes(Long productId);
}

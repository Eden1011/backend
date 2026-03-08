package pl.backend.assesment.feature.attribute.productsattribute.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.backend.assesment.core.exception.BusinessException;
import pl.backend.assesment.core.exception.BusinessExceptionReasonEnum;
import pl.backend.assesment.feature.attribute.productsattribute.model.ProductsAttributeModel;
import pl.backend.assesment.feature.attribute.productsattribute.repository.ProductsAttributeRepository;
import pl.backend.assesment.feature.products.repository.ProductsRepository;

@Service
@RequiredArgsConstructor
public class ProductsAttributeService implements ProductsAttributeServiceInterface {
  private final ProductsAttributeRepository productsAttributeRepository;
  private final ProductsRepository productsRepository;

  @Override
  @Transactional(readOnly = true)
  public List<ProductsAttributeModel> getProductAttributes(Long productId) {
    if (!productsRepository.existsById(productId)) {
      throw new BusinessException(BusinessExceptionReasonEnum.PRODUCT_NOT_FOUND);
    }
    return productsAttributeRepository.findByProduct_Id(productId);
  }
}

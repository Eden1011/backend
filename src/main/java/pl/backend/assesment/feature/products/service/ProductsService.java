package pl.backend.assesment.feature.products.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.backend.assesment.core.exception.BusinessException;
import pl.backend.assesment.core.exception.BusinessExceptionReasonEnum;
import pl.backend.assesment.feature.attribute.attributetype.model.AttributeTypeModel;
import pl.backend.assesment.feature.attribute.attributetype.repository.AttributeTypeRepository;
import pl.backend.assesment.feature.attribute.productsattribute.dto.AttributeValueRequestDto;
import pl.backend.assesment.feature.attribute.productsattribute.model.ProductsAttributeModel;
import pl.backend.assesment.feature.producers.model.ProducersModel;
import pl.backend.assesment.feature.producers.repository.ProducersRepository;
import pl.backend.assesment.feature.products.dto.ProductCreateRequestDto;
import pl.backend.assesment.feature.products.dto.ProductUpdateRequestDto;
import pl.backend.assesment.feature.products.mapper.ProductsMapper;
import pl.backend.assesment.feature.products.model.ProductsModel;
import pl.backend.assesment.feature.products.repository.ProductsRepository;

@Service
@RequiredArgsConstructor
public class ProductsService implements ProductsServiceInterface {
  private final ProductsRepository productsRepository;
  private final ProducersRepository producersRepository;
  private final AttributeTypeRepository attributeTypeRepository;
  private final ProductsMapper productsMapper;

  @Override
  @Transactional(readOnly = true)
  public List<ProductsModel> getAllProducts() {
    return productsRepository.findAllWithDetails();
  }

  @Override
  @Transactional(readOnly = true)
  public List<ProductsModel> searchByName(String name) {
    return productsRepository.searchByNameWithDetails(name);
  }

  @Override
  @Transactional(readOnly = true)
  public ProductsModel getProduct(Long id) {
    return getOrThrow(id);
  }

  @Override
  @Transactional
  public ProductsModel createProduct(ProductCreateRequestDto dto) {
    ProducersModel producer = getProducerOrThrow(dto.producerId());
    ProductsModel product = productsMapper.toEntity(dto);
    product.setProducer(producer);
    if (dto.attributes() != null) {
      product.setAttributes(buildAttributes(dto.attributes(), product));
    }
    return productsRepository.save(product);
  }

  @Override
  @Transactional
  public ProductsModel updateProduct(Long id, ProductUpdateRequestDto dto) {
    ProductsModel product = getOrThrow(id);
    product.setName(dto.name());
    product.setProducer(getProducerOrThrow(dto.producerId()));
    product.getAttributes().clear();
    product.getAttributes().addAll(buildAttributes(dto.attributes(), product));
    return productsRepository.save(product);
  }

  @Override
  @Transactional
  public void deleteProduct(Long id) {
    productsRepository.delete(getOrThrow(id));
  }

  private ProductsModel getOrThrow(Long id) {
    return productsRepository
        .findById(id)
        .orElseThrow(() -> new BusinessException(BusinessExceptionReasonEnum.PRODUCT_NOT_FOUND));
  }

  private ProducersModel getProducerOrThrow(Long id) {
    return producersRepository
        .findById(id)
        .orElseThrow(() -> new BusinessException(BusinessExceptionReasonEnum.PRODUCER_NOT_FOUND));
  }

  private AttributeTypeModel getAttributeTypeOrThrow(Long id) {
    return attributeTypeRepository
        .findById(id)
        .orElseThrow(
            () -> new BusinessException(BusinessExceptionReasonEnum.ATTRIBUTE_TYPE_NOT_FOUND));
  }

  private Set<ProductsAttributeModel> buildAttributes(
      List<AttributeValueRequestDto> dtos, ProductsModel product) {
    Set<ProductsAttributeModel> attributes = new HashSet<>();
    for (AttributeValueRequestDto dto : dtos) {
      ProductsAttributeModel attr = new ProductsAttributeModel();
      attr.setProduct(product);
      attr.setAttributeType(getAttributeTypeOrThrow(dto.attributeTypeId()));
      attr.setValue(dto.value());
      attributes.add(attr);
    }
    return attributes;
  }
}

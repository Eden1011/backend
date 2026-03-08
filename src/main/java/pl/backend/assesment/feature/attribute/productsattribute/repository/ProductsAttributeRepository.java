package pl.backend.assesment.feature.attribute.productsattribute.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.backend.assesment.feature.attribute.productsattribute.model.ProductsAttributeModel;

@Repository
public interface ProductsAttributeRepository extends JpaRepository<ProductsAttributeModel, Long> {
  List<ProductsAttributeModel> findByProduct_Id(Long productId);
}

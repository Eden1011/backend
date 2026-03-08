package pl.backend.assesment.feature.products.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.backend.assesment.feature.products.model.ProductsModel;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsModel, Long> {
  List<ProductsModel> findByProducer_Id(Long producerId);

  @Query(
      "SELECT p FROM ProductsModel p"
          + " JOIN FETCH p.producer"
          + " LEFT JOIN FETCH p.attributes a"
          + " LEFT JOIN FETCH a.attributeType")
  List<ProductsModel> findAllWithDetails();
}

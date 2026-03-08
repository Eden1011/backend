package pl.backend.assesment.feature.attribute.attributetype.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.backend.assesment.feature.attribute.attributetype.model.AttributeTypeModel;

@Repository
public interface AttributeTypeRepository extends JpaRepository<AttributeTypeModel, Long> {
  Optional<AttributeTypeModel> findByName(String name);

  boolean existsByName(String name);
}

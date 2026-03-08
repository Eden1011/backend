package pl.backend.assesment.feature.attribute.attributetype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.backend.assesment.feature.attribute.attributetype.model.AttributeTypeModel;

@Repository
public interface AttributeTypeRepository extends JpaRepository<AttributeTypeModel, Long> {
  boolean existsByName(String name);
}

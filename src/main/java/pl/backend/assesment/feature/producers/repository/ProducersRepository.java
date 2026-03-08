package pl.backend.assesment.feature.producers.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.backend.assesment.feature.producers.model.ProducersModel;

@Repository
public interface ProducersRepository extends JpaRepository<ProducersModel, Long> {
  boolean existsByName(String name);

  List<ProducersModel> findByNameContainingIgnoreCase(String name);
}

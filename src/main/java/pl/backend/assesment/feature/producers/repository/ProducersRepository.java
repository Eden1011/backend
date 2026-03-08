package pl.backend.assesment.feature.producers.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.backend.assesment.feature.producers.model.ProducersModel;

@Repository
public interface ProducersRepository extends JpaRepository<ProducersModel, Long> {
  Optional<ProducersModel> findByName(String name);

  boolean existsByName(String name);
}

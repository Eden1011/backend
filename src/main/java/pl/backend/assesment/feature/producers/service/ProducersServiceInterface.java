package pl.backend.assesment.feature.producers.service;

import java.util.List;
import pl.backend.assesment.feature.producers.dto.ProducerCreateRequestDto;
import pl.backend.assesment.feature.producers.model.ProducersModel;

public interface ProducersServiceInterface {
  List<ProducersModel> getAllProducers();

  List<ProducersModel> searchByName(String name);

  ProducersModel getProducer(Long id);

  ProducersModel createProducer(ProducerCreateRequestDto dto);

  void deleteProducer(Long id);
}

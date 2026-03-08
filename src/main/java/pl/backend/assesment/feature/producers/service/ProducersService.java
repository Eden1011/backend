package pl.backend.assesment.feature.producers.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.backend.assesment.core.exception.BusinessException;
import pl.backend.assesment.core.exception.BusinessExceptionReasonEnum;
import pl.backend.assesment.feature.producers.dto.ProducerCreateRequestDto;
import pl.backend.assesment.feature.producers.mapper.ProducersMapper;
import pl.backend.assesment.feature.producers.model.ProducersModel;
import pl.backend.assesment.feature.producers.repository.ProducersRepository;

@Service
@RequiredArgsConstructor
public class ProducersService implements ProducersServiceInterface {
  private final ProducersRepository producersRepository;
  private final ProducersMapper producersMapper;

  @Override
  @Transactional(readOnly = true)
  public List<ProducersModel> getAllProducers() {
    return producersRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public ProducersModel getProducer(Long id) {
    return getOrThrow(id);
  }

  @Override
  @Transactional
  public ProducersModel createProducer(ProducerCreateRequestDto dto) {
    if (producersRepository.existsByName(dto.name())) {
      throw new BusinessException(BusinessExceptionReasonEnum.PRODUCER_NAME_ALREADY_EXISTS);
    }
    return producersRepository.save(producersMapper.toEntity(dto));
  }

  @Override
  @Transactional
  public void deleteProducer(Long id) {
    producersRepository.delete(getOrThrow(id));
  }

  private ProducersModel getOrThrow(Long id) {
    return producersRepository
        .findById(id)
        .orElseThrow(() -> new BusinessException(BusinessExceptionReasonEnum.PRODUCER_NOT_FOUND));
  }
}

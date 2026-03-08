package pl.backend.assesment.feature.producers.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.backend.assesment.feature.producers.dto.ProducerCreateRequestDto;
import pl.backend.assesment.feature.producers.dto.ProducerResponseDto;
import pl.backend.assesment.feature.producers.mapper.ProducersMapper;
import pl.backend.assesment.feature.producers.service.ProducersServiceInterface;

@RestController
@RequestMapping("${api.path}/producers")
@RequiredArgsConstructor
public class ProducersController {
  private final ProducersServiceInterface producersService;
  private final ProducersMapper producersMapper;

  @GetMapping
  public ResponseEntity<List<ProducerResponseDto>> getProducers(
      @RequestParam(required = false) String name) {
    List<ProducerResponseDto> producers =
        name != null
            ? producersMapper.toResponseDtoList(producersService.searchByName(name))
            : producersMapper.toResponseDtoList(producersService.getAllProducers());
    return ResponseEntity.ok(producers);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProducerResponseDto> getProducer(@PathVariable Long id) {
    return ResponseEntity.ok(producersMapper.toResponseDto(producersService.getProducer(id)));
  }

  @PostMapping
  public ResponseEntity<ProducerResponseDto> createProducer(
      @RequestBody @Valid ProducerCreateRequestDto dto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(producersMapper.toResponseDto(producersService.createProducer(dto)));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProducer(@PathVariable Long id) {
    producersService.deleteProducer(id);
    return ResponseEntity.noContent().build();
  }
}

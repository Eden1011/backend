package pl.backend.assesment.feature.producers.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import pl.backend.assesment.feature.products.model.ProductsModel;

@Getter
@Setter
@Entity
@Table(name = "producers")
public class ProducersModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(name = "registered_at")
  private Date registeredAt;

  @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<ProductsModel> products = new HashSet<>();
}

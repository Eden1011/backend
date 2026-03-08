package pl.backend.assesment.feature.products.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import pl.backend.assesment.feature.attribute.productsattribute.model.ProductsAttributeModel;
import pl.backend.assesment.feature.producers.model.ProducersModel;

@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductsModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "producer_id", nullable = false)
  private ProducersModel producer;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
  private Set<ProductsAttributeModel> attributes = new HashSet<>();
}

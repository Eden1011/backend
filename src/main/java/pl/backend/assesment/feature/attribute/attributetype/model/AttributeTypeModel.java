package pl.backend.assesment.feature.attribute.attributetype.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import pl.backend.assesment.feature.attribute.productsattribute.model.ProductsAttributeModel;

@Getter
@Setter
@Entity
@Table(name = "attribute_types")
public class AttributeTypeModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @OneToMany(mappedBy = "attributeType", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<ProductsAttributeModel> productAttributes = new HashSet<>();
}

package pl.backend.assesment.feature.attribute.attributetype.model;

import jakarta.persistence.*;
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

  @OneToMany(mappedBy = "attributeType", cascade = CascadeType.ALL)
  private Set<ProductsAttributeModel> productAttributes = new HashSet<>();
}

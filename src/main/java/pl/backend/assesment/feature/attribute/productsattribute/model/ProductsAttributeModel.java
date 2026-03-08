package pl.backend.assesment.feature.attribute.productsattribute.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import pl.backend.assesment.feature.attribute.attributetype.model.AttributeTypeModel;
import pl.backend.assesment.feature.products.model.ProductsModel;

@Getter
@Setter
@Entity
@Table(name = "product_attribute_values")
public class ProductsAttributeModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private ProductsModel product;

  @ManyToOne
  @JoinColumn(name = "attribute_type_id", nullable = false)
  private AttributeTypeModel attributeType;

  @Column(nullable = false)
  private String value;
}

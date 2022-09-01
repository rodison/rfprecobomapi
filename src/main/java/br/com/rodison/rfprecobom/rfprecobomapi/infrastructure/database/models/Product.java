package br.com.rodison.rfprecobom.rfprecobomapi.infrastructure.database.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Product", indexes = {
		@Index(name = "idx_product_name", columnList = "name"),
		@Index(name = "idx_product_active", columnList = "active")
})
public class Product implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID productId;

	@OneToMany(mappedBy = "product", orphanRemoval = false, fetch = FetchType.LAZY)
	@ToString.Exclude
	private List<ProductPrice> productPrices = new ArrayList<>();

	@Column(nullable = false, unique = true, length = 255)
	private String name;

	@Column(nullable = false)
	private Boolean active = true;

	@Column(nullable = true, unique = false, length = 4000)
	private String description;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Product product = (Product) o;
		return productId != null && Objects.equals(productId, product.productId);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}

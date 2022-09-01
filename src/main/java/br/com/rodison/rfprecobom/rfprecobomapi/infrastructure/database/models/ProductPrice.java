package br.com.rodison.rfprecobom.rfprecobomapi.infrastructure.database.models;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "ProductPrice", indexes = {
		@Index(name = "idx_productprice_pricedate", columnList = "priceDate"),
		@Index(name = "idx_productprice_price", columnList = "price"),
		@Index(name = "idx_productprice_active", columnList = "active")
})
public class ProductPrice implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID productPriceId;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "productId")
	@ToString.Exclude
	private Product product;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "marketId")
	@ToString.Exclude
	private Market market;

	@Column(nullable = false, unique = false, precision = 8, scale = 2)
	private BigDecimal price;

	@Column(nullable = false)
	private Boolean active = true;

	@Column(nullable = true, unique = false, length = 4000)
	private String description;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDateTime priceDate;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		ProductPrice that = (ProductPrice) o;
		return productPriceId != null && Objects.equals(productPriceId, that.productPriceId);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}

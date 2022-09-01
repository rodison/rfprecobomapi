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
@Table(name = "Market", indexes = {
		@Index(name = "idx_market_name", columnList = "name"),
		@Index(name = "idx_market_active", columnList = "active")
})
public class Market implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID marketId;

	@OneToMany(mappedBy = "market", orphanRemoval = false, fetch = FetchType.LAZY)
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
		Market market = (Market) o;
		return marketId != null && Objects.equals(marketId, market.marketId);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}

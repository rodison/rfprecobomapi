package br.com.rodison.rfprecobom.rfprecobomapi.core.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ProductPriceDTO {

	private UUID productPriceId;

	private UUID productId;
	private String productName;

	private UUID marketId;
	private String marketName;

	private BigDecimal price;

	private Boolean active = true;

	private String description;

	private LocalDateTime priceDate;

}

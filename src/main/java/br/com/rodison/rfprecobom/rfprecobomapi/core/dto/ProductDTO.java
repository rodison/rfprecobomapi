package br.com.rodison.rfprecobom.rfprecobomapi.core.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductDTO {
	private UUID productId;
	private String name;
	private Boolean active = true;
	private String description;
}

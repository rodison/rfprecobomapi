package br.com.rodison.rfprecobom.rfprecobomapi.core.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class MarketDTO {
	private UUID marketId;
	private String name;
	private String description;
	private Boolean active = true;
}

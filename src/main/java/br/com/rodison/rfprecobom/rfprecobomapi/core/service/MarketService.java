package br.com.rodison.rfprecobom.rfprecobomapi.core.service;

import br.com.rodison.rfprecobom.rfprecobomapi.core.dto.MarketDTO;

import java.util.List;
import java.util.UUID;

public interface MarketService {

	List<MarketDTO> listMarkets();

	MarketDTO addMarket(MarketDTO marketDTO);

	MarketDTO updateMarket(UUID marketId, MarketDTO marketDTO);

	void disableMarket(UUID marketId);

}

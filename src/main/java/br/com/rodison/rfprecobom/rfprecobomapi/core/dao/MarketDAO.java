package br.com.rodison.rfprecobom.rfprecobomapi.core.dao;

import br.com.rodison.rfprecobom.rfprecobomapi.core.dto.MarketDTO;

import java.util.List;
import java.util.UUID;

public interface MarketDAO {

	List<MarketDTO> listMarkets();

	MarketDTO addMarket(MarketDTO marketDTO);

	MarketDTO updateMarket(MarketDTO marketDTO);

	void disableMarket(UUID marketId);

	boolean marketExists(UUID marketId);
}

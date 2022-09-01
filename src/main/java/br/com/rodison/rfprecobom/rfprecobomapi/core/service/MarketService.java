package br.com.rodison.rfprecobom.rfprecobomapi.core.service;

import br.com.rodison.rfprecobom.rfprecobomapi.core.dto.MarketDTO;
import br.com.rodison.rfprecobom.rfprecobomapi.infrastructure.database.models.Market;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MarketService {

	List<MarketDTO> listMarkets();

	Market addMarket(MarketDTO market);

	Market updateMarket(MarketDTO market);

	void disableMarket(MarketDTO market);

}

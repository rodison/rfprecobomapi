package br.com.rodison.rfprecobom.rfprecobomapi.core.service;

import br.com.rodison.rfprecobom.rfprecobomapi.core.dao.MarketDAO;
import br.com.rodison.rfprecobom.rfprecobomapi.core.dto.MarketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static br.com.rodison.rfprecobom.rfprecobomapi.exceptions.RfPrecoBomException.createObjectDoesNotExistsException;
import static br.com.rodison.rfprecobom.rfprecobomapi.utils.Validator.requireIdEqualsInObject;
import static br.com.rodison.rfprecobom.rfprecobomapi.utils.Validator.requireNonNull;
import static br.com.rodison.rfprecobom.rfprecobomapi.utils.Validator.requireNull;

@Service
public class MarketServiceImpl implements MarketService {

	@Autowired
	private MarketDAO dao;

	@Override
	public List<MarketDTO> listMarkets() {
		return dao.listMarkets();
	}

	@Override
	public MarketDTO addMarket(final MarketDTO marketDTO) {
		String methodName = "addMarket";
		requireNonNull(this.getClass(), methodName, marketDTO, "marketDTO");
		requireNull(this.getClass(), methodName, marketDTO.getMarketId(), "marketDTO.marketId");

		return dao.addMarket(marketDTO);
	}

	@Override
	public MarketDTO updateMarket(UUID marketId, final MarketDTO marketDTO) {
		final String methodName = "updateMarket";
		requireNonNull(this.getClass(), methodName, marketId, "marketId");
		requireNonNull(this.getClass(), methodName, marketDTO, "marketDTO");
		requireNonNull(this.getClass(), methodName, marketDTO.getMarketId(), "marketDTO.marketId");
		requireNull(this.getClass(), methodName, marketDTO.getMarketId(), "marketDTO.marketId");
		requireIdEqualsInObject(this.getClass(), methodName, marketId, marketDTO.getMarketId(), "marketId", "marketDTO.marketId");

		if (!dao.marketExists(marketDTO.getMarketId())) {
			throw createObjectDoesNotExistsException(this.getClass(), methodName, marketDTO.getMarketId(), "marketDTO.marketId");
		}
		return dao.updateMarket(marketDTO);
	}

	@Override
	public void disableMarket(final UUID marketId) {
		final String methodName = "disableMarket";
		requireNonNull(this.getClass(), methodName, marketId, "marketId");

		if (!dao.marketExists(marketId)) {
			throw createObjectDoesNotExistsException(this.getClass(), methodName, marketId, "marketId");
		}
		dao.disableMarket(marketId);
	}
}

package br.com.rodison.rfprecobom.rfprecobomapi.infrastructure;

import br.com.rodison.rfprecobom.rfprecobomapi.core.dao.MarketDAO;
import br.com.rodison.rfprecobom.rfprecobomapi.core.dto.MarketDTO;
import br.com.rodison.rfprecobom.rfprecobomapi.infrastructure.database.models.Market;
import br.com.rodison.rfprecobom.rfprecobomapi.infrastructure.database.repository.MarketRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static br.com.rodison.rfprecobom.rfprecobomapi.exceptions.RfPrecoBomException.createObjectDoesNotExistsException;
import static br.com.rodison.rfprecobom.rfprecobomapi.utils.Validator.requireNonNull;
import static br.com.rodison.rfprecobom.rfprecobomapi.utils.Validator.requireNull;

@Component
public class MarketDAOImpl implements MarketDAO {
	@Autowired
	private MarketRepository repository;

	@Override
	public List<MarketDTO> listMarkets() {
		final List<Market> marketModels = repository.findByActive(true);
		final List<MarketDTO> dtos = new ArrayList<>();
		marketModels.forEach(marketModel -> {
			MarketDTO dto = new MarketDTO();
			BeanUtils.copyProperties(marketModel, dto);
			dtos.add(dto);
		});
		return dtos;
	}

	@Override
	public MarketDTO addMarket(final MarketDTO marketDTO) {
		final Market marketModel = new Market();
		BeanUtils.copyProperties(marketDTO, marketModel);
		marketModel.setMarketId(UUID.randomUUID());
		Market newMarketModel = repository.save(marketModel);
		MarketDTO newMarketDto = new MarketDTO();
		BeanUtils.copyProperties(newMarketModel, newMarketDto);
		return newMarketDto;
	}

	@Override
	public MarketDTO updateMarket(final MarketDTO marketDTO) {
		final String methodName = "updateMarket";
		final Market marketModel = repository.findById(marketDTO.getMarketId())
				.orElseThrow(() -> createObjectDoesNotExistsException(this.getClass(), methodName, marketDTO.getMarketId(), "marketDTO.marketId"));

		BeanUtils.copyProperties(marketDTO, marketModel);
		Market newMarketModel = repository.save(marketModel);
		MarketDTO newMarketDto = new MarketDTO();
		BeanUtils.copyProperties(newMarketModel, newMarketDto);
		return newMarketDto;
	}

	@Override
	public void disableMarket(final UUID marketId) {
		final String methodName = "disableMarket";
		final Market marketModel = repository.findById(marketId)
				.orElseThrow(() -> createObjectDoesNotExistsException(this.getClass(), methodName, marketId, "marketId"));
		marketModel.setActive(false);
		repository.save(marketModel);
	}

	@Override
	public boolean marketExists(UUID marketId) {
		return repository.existsById(marketId);
	}
}

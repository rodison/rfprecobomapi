package br.com.rodison.rfprecobom.rfprecobomapi.input.restapicontrollers;

import br.com.rodison.rfprecobom.rfprecobomapi.core.dto.MarketDTO;
import br.com.rodison.rfprecobom.rfprecobomapi.core.service.MarketService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static br.com.rodison.rfprecobom.rfprecobomapi.input.restapicontrollers.util.ControllerUtils.handleControllerExceptions;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/market")
public class MarketController {

	private static final Logger logger = LogManager.getLogger(MarketController.class);

	@Autowired
	private MarketService service;

	@GetMapping()
	public ResponseEntity<Object> listMarkets() {
		final String methodName = "listMarkets";
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.listMarkets());
		} catch (Exception e) {
			return handleControllerExceptions(logger, this.getClass(), methodName, e);
		}
	}

	@PostMapping()
	public ResponseEntity<Object> addMarket(@RequestBody final MarketDTO marketDTO) {
		final String methodName = "addMarket";
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.addMarket(marketDTO));
		} catch (Exception e) {
			return handleControllerExceptions(logger, this.getClass(), methodName, e);
		}
	}

	@PutMapping("/{marketId}")
	public ResponseEntity<Object> updateMarket(@PathVariable(value = "marketId") UUID marketId, @RequestBody final MarketDTO marketDTO) {
		final String methodName = "updateMarket";
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.updateMarket(marketId, marketDTO));
		} catch (Exception e) {
			return handleControllerExceptions(logger, this.getClass(), methodName, e);
		}
	}

	@DeleteMapping("/{marketId}")
	public ResponseEntity<Object> disableMarket(@PathVariable(value = "marketId") UUID marketId) {
		final String methodName = "updateMarket";
		try {
			service.disableMarket(marketId);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return handleControllerExceptions(logger, this.getClass(), methodName, e);
		}
	}
}

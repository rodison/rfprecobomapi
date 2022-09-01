package br.com.rodison.rfprecobom.rfprecobomapi.core.service;

import br.com.rodison.rfprecobom.rfprecobomapi.core.dto.ProductPriceDTO;
import br.com.rodison.rfprecobom.rfprecobomapi.core.dto.ProductPriceFilterDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductPriceService {

	List<ProductPriceDTO> listProductsPrices(ProductPriceFilterDTO filter);

	ProductPriceDTO addProductPrice(ProductPriceDTO market);

	ProductPriceDTO updateProductPrice(ProductPriceDTO market);

	void disableProductPrice(ProductPriceDTO market);

}

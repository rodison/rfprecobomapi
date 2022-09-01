package br.com.rodison.rfprecobom.rfprecobomapi.core.service;

import br.com.rodison.rfprecobom.rfprecobomapi.core.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ProductService {

	List<ProductDTO> listProducts = new ArrayList<>();

	ProductDTO addProduct(ProductDTO market);

	ProductDTO updateProduct(ProductDTO market);

	void disableProduct(ProductDTO market);

}

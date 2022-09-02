package br.com.rodison.rfprecobom.rfprecobomapi.infrastructure.database.repository;

import br.com.rodison.rfprecobom.rfprecobomapi.infrastructure.database.models.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, UUID> {
}

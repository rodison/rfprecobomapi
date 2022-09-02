package br.com.rodison.rfprecobom.rfprecobomapi.infrastructure.database.repository;

import br.com.rodison.rfprecobom.rfprecobomapi.infrastructure.database.models.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MarketRepository extends JpaRepository<Market, UUID> {

	List<Market> findByActive(boolean active);

}

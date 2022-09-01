package br.com.rodison.rfprecobom.rfprecobomapi.infrastructure.database.repository;

import br.com.rodison.rfprecobom.rfprecobomapi.infrastructure.database.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}

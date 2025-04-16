package br.futurodev.joiville.m1s09.repositories;

import br.futurodev.joiville.m1s09.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

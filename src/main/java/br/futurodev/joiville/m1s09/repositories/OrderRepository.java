package br.futurodev.joiville.m1s09.repositories;

import br.futurodev.joiville.m1s09.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

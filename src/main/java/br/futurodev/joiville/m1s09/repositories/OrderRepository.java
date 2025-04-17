package br.futurodev.joiville.m1s09.repositories;

import br.futurodev.joiville.m1s09.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT DISTINCT oi.order FROM OrderItem oi WHERE UPPER(oi.product.name) LIKE '%' || UPPER(:name) || '%'")
    List<Order> findAllByProductName(String name);

}

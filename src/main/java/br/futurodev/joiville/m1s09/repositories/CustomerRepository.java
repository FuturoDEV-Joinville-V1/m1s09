package br.futurodev.joiville.m1s09.repositories;

import br.futurodev.joiville.m1s09.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

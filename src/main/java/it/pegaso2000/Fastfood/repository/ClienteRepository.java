package it.pegaso2000.Fastfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pegaso2000.Fastfood.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}

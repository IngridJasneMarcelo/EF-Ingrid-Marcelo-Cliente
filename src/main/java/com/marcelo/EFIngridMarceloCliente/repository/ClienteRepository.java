package com.marcelo.EFIngridMarceloCliente.repository;

import com.marcelo.EFIngridMarceloCliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}

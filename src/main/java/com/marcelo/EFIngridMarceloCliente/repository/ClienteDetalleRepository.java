package com.marcelo.EFIngridMarceloCliente.repository;

import com.marcelo.EFIngridMarceloCliente.model.ClienteDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDetalleRepository extends JpaRepository<ClienteDetalle, Integer> {
}

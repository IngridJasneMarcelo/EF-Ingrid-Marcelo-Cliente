package com.marcelo.EFIngridMarceloCliente.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "cliente_pizza")
public class ClienteDetalle {

    @EmbeddedId
    private ClientePizzaFK fk = new ClientePizzaFK();

}

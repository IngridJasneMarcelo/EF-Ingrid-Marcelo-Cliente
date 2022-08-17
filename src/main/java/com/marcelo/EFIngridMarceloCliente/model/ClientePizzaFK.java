package com.marcelo.EFIngridMarceloCliente.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@Embeddable
public class ClientePizzaFK implements Serializable {

    @Column(name = "idCliente", nullable = false, unique = false)
    private Integer idCliente;

    @Column(name = "idPizza", nullable = false, unique = false)
    private Integer idPizza;
}


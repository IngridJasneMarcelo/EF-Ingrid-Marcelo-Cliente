package com.marcelo.EFIngridMarceloCliente.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteDto {
    private Integer idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String nroCelular;
    private String direccion;
}

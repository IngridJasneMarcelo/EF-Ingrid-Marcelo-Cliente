package com.marcelo.EFIngridMarceloCliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EfIngridMarceloClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EfIngridMarceloClienteApplication.class, args);
	}

}

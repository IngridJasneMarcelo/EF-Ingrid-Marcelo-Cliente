package com.marcelo.EFIngridMarceloCliente.service;

import com.marcelo.EFIngridMarceloCliente.client.OpenFeingClient;
import com.marcelo.EFIngridMarceloCliente.dto.Pizza;
import com.marcelo.EFIngridMarceloCliente.model.Cliente;
import com.marcelo.EFIngridMarceloCliente.model.ClienteDetalle;
import com.marcelo.EFIngridMarceloCliente.model.ClientePizzaFK;
import com.marcelo.EFIngridMarceloCliente.repository.ClienteDetalleRepository;
import com.marcelo.EFIngridMarceloCliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteDetalleRepository detalleRepository;

    @Autowired
    private OpenFeingClient feingClient;

    @Override
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @Override
    public Cliente porId(Integer idCliente) {
        return repository.findById(idCliente).orElse(null);
    }

    @Override
    public void guardar(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void eliminar(Integer idCliente) {
        repository.deleteById(idCliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        repository.saveAndFlush(cliente);
    }

    @Override
    public void asignarPizzaCliente() {
        List<Pizza> listado = feingClient.listarPizzaSeleccionados();
        ClientePizzaFK fk = null;
        ClienteDetalle detalle = null;

        for (Pizza pizza: listado) {
            fk = new ClientePizzaFK();
            fk.setIdPizza(pizza.getIdPizza());
            fk.setIdCliente(1);

            detalle = new ClienteDetalle();
            detalle.setFk(fk);
            detalleRepository.save(detalle);
        }
    }
}

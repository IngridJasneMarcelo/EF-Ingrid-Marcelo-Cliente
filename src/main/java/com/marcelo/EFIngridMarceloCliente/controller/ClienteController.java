package com.marcelo.EFIngridMarceloCliente.controller;

import com.marcelo.EFIngridMarceloCliente.model.Cliente;
import com.marcelo.EFIngridMarceloCliente.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteImpl;

    @GetMapping("/listar")
    public @ResponseBody ResponseEntity<List<Cliente>>listarP(){
        return new ResponseEntity<List<Cliente>>(clienteImpl.listar(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{idCliente}")
    public ResponseEntity<Cliente> buscarP(@PathVariable Integer idCliente){
        Cliente cli = clienteImpl.porId(idCliente);
        if(cli!=null) {
            return new ResponseEntity<Cliente>(cli,HttpStatus.OK);
        }
        return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> guardarP(@RequestBody Cliente pizza){
        clienteImpl.guardar(pizza);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping("actualizar")
    public ResponseEntity<Void> actualizarP(@RequestBody Cliente pizza){

        Cliente  cli = clienteImpl.porId(pizza.getIdCliente());

        if(cli!=null) {
            clienteImpl.actualizar(pizza);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{idCliente}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer idCliente){
        Cliente cli = clienteImpl.porId(idCliente);
        if(cli!=null) {
            clienteImpl.eliminar(idCliente);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/asignar")
    public @ResponseBody void asignarPizzeria(){
        clienteImpl.asignarPizzaCliente();
    }

}

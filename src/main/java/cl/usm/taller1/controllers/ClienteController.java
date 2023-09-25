package cl.usm.taller1.controllers;


import cl.usm.taller1.entities.Cliente;
import cl.usm.taller1.services.ClienteService;
import cl.usm.taller1.utils.ClienteValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/mostrarClientes")
    ResponseEntity<List<Cliente>> getAllClientes(){
        try {
            return ResponseEntity.ok(clienteService.getAllClientes());
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/ingresarCliente")
    ResponseEntity<Cliente> createNewCliente(@RequestBody Cliente cliente){
        if(!ClienteValidations.checkIfFieldsAreNulls(cliente)){
            return  ResponseEntity.badRequest().build();
        }
        if(!ClienteValidations.verifyRutValid(cliente)){
            return  ResponseEntity.badRequest().build();
        }

        try {
            return ResponseEntity.ok(clienteService.createCliente(cliente));
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/mostrarClientes/{estado}")
    ResponseEntity<List<Cliente>> filterClientesByEstado(@PathVariable Cliente.EstadoCliente estado){
        try {
            return ResponseEntity.ok(clienteService.filterByEstado(estado));
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

}

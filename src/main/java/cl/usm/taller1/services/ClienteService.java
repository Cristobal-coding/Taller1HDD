package cl.usm.taller1.services;

import cl.usm.taller1.entities.Cliente;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ClienteService {

    List<Cliente> filterByEstado(Cliente.EstadoCliente estadoCliente);
    Cliente createCliente(Cliente cliente);
    List<Cliente> getAllClientes();

}

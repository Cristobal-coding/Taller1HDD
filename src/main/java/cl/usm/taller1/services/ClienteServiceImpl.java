package cl.usm.taller1.services;

import cl.usm.taller1.entities.Cliente;
import cl.usm.taller1.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements  ClienteService{

    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }


    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> filterByEstado(Cliente.EstadoCliente estadoCliente) {
        return clienteRepository.findByEstadoCliente(estadoCliente);
    }


}

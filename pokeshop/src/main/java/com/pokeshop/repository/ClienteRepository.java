package com.pokeshop.service;

import com.pokeshop.model.Cliente;
import com.pokeshop.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> buscarPorNombre(String nombre) {
        return clienteRepository.findByNombreContaining(nombre);
    }

    public Cliente buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    public Cliente buscarPorTelefono(String telefono) {
        return clienteRepository.findByTelefono(telefono);
    }

    // Otros métodos de servicio...
}

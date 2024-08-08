package com.pokeshop.controller;

import com.pokeshop.model.Cliente;
import com.pokeshop.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Obtener todos los clientes
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAllClientes();
    }

    // Obtener cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.findClienteById(id);
        return cliente.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Buscar clientes por nombre
    @GetMapping("/buscarPorNombre")
    public List<Cliente> getClientesByNombre(@RequestParam String nombre) {
        return clienteService.findClientesByNombre(nombre);
    }

    // Buscar cliente por email
    @GetMapping("/buscarPorEmail")
    public ResponseEntity<Cliente> getClienteByEmail(@RequestParam String email) {
        Cliente cliente = clienteService.findClienteByEmail(email);
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    // Buscar cliente por teléfono
    @GetMapping("/buscarPorTelefono")
    public ResponseEntity<Cliente> getClienteByTelefono(@RequestParam String telefono) {
        Cliente cliente = clienteService.findClienteByTelefono(telefono);
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    // Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.saveCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    // Actualizar un cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        if (!clienteService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setClienteId(id);
        Cliente clienteActualizado = clienteService.saveCliente(cliente);
        return ResponseEntity.ok(clienteActualizado);
    }

    // Eliminar un cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        if (!clienteService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clienteService.deleteClienteById(id);
        return ResponseEntity.noContent().build();
    }
}

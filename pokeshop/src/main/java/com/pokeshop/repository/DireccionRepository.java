package com.pokeshop.service;

import com.pokeshop.model.Direccion;
import com.pokeshop.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    public List<Direccion> buscarPorCiudad(String ciudad) {
        return direccionRepository.findByCiudad(ciudad);
    }

    public List<Direccion> buscarPorEstado(String estado) {
        return direccionRepository.findByEstado(estado);
    }

    public List<Direccion> buscarPorCodigoPostal(String codigoPostal) {
        return direccionRepository.findByCodigoPostal(codigoPostal);
    }

    public List<Direccion> buscarPorPais(String pais) {
        return direccionRepository.findByPais(pais);
    }

    // Otros métodos de servicio...
}

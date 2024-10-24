package com.examenFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenFinal.entidades.Atencion;
import com.examenFinal.repositories.AtencionRepository;

@Service
public class AtencionService {

    @Autowired
    private AtencionRepository atencionRepository;

    public Atencion registrarAtencion(Atencion atencion) {
        return atencionRepository.save(atencion);
    }

    public List<Atencion> listarAtenciones() {
        return atencionRepository.findAll();
    }
}

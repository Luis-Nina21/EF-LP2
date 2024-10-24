package com.examenFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenFinal.entidades.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {}


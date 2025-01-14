package com.examenFinal.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.examenFinal.entidades.Paciente;
import com.examenFinal.services.AtencionService;
import com.examenFinal.services.PacienteService;

import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;  // Corregido el nombre

    @Autowired
    private AtencionService atencionService;  // Corregido el nombre

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "registrar-paciente";
    }

    @PostMapping("/registrar")
    public String registrarPaciente(@ModelAttribute Paciente paciente) {
        pacienteService.registrarPaciente(paciente);  // Cambiado a minúsculas
        return "redirect:/pacientes/listar";
    }

    @GetMapping("/listar")
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.listarPacientes();  // Cambiado a minúsculas
        model.addAttribute("pacientes", pacientes);
        return "listar-pacientes";
    }
}
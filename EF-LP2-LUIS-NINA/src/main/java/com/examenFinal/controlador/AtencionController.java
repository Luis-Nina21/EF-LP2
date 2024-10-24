package com.examenFinal.controlador;

import com.examenFinal.entidades.Atencion;
import com.examenFinal.services.AtencionService;
import com.examenFinal.services.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/atenciones")
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("atencion", new Atencion());
        model.addAttribute("pacientes", pacienteService.listarPacientes()); // Para seleccionar paciente
        return "registrar-atencion"; // Nombre de la vista
    }

    @PostMapping("/registrar")
    public String registrarAtencion(@ModelAttribute Atencion atencion, Model model) {
        try {
            atencionService.registrarAtencion(atencion);
        } catch (Exception e) {
            e.printStackTrace(); // Esto te ayudará a ver el error en la consola
            model.addAttribute("errorMessage", "Error al registrar la atención: " + e.getMessage());
            return "registrar-atencion"; // Regresa al formulario en caso de error
        }
        return "redirect:/atenciones/listar"; // Redirigir a la lista después de registrar
    }

    @GetMapping("/listar")
    public String listarAtenciones(Model model) {
        List<Atencion> atenciones = atencionService.listarAtenciones();
        model.addAttribute("atenciones", atenciones);
        return "listar-atenciones"; // Nombre de la vista
    }
}

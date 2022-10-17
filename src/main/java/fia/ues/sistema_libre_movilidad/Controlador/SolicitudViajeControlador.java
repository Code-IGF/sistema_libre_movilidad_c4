package fia.ues.sistema_libre_movilidad.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fia.ues.sistema_libre_movilidad.Servicio.SolicitudViajeServicio;

@Controller
public class SolicitudViajeControlador {
    
    @Autowired
    private SolicitudViajeServicio servicio;

    @GetMapping({"/solicitudes_viaje"})
    public String listarEstudiantes(Model modelo){
        modelo.addAttribute("solicitudes", servicio.listarSolicitudes());
        return "solicitud_viaje/index";
    }
}

package fia.ues.sistema_libre_movilidad.Controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fia.ues.sistema_libre_movilidad.Servicio.MedioTransporteServicio;

@Controller

public class MedioTransporteControlador {

    @Autowired
    private MedioTransporteServicio servicio;

    @GetMapping({"/Medio-Transporte"})
    public String ListarMediosTransporte(Model modelo){
        modelo.addAttribute("Medio-Transporte",servicio.ListarMedioTransporte());
        return "Medio-Transporte";
    }
    
}

package fia.ues.sistema_libre_movilidad.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fia.ues.sistema_libre_movilidad.Servicio.OficialAduaneroServicio;

@Controller
public class OficialAduaneroControlador {
    @Autowired
    private OficialAduaneroServicio servicio;

    @GetMapping({"/index"})
    public String listarOficialAduanero(Model modelo){
        modelo.addAttribute("index", servicio.listarOficialAduanero());
        return "index";
    }

    
}

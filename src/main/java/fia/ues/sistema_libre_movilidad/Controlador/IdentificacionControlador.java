package fia.ues.sistema_libre_movilidad.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/*import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Identificacion;*/
import fia.ues.sistema_libre_movilidad.Servicio.IdentificacionServicio;

@Controller
public class IdentificacionControlador {
    
    @Autowired
    private IdentificacionServicio servicio;

    @GetMapping({"identificacion"})
    public String listarIdentificacion(Model modelo){
        modelo.addAttribute("identificacion", servicio.listarIdentificacion());
        return "identificacion/index";
    } 
}

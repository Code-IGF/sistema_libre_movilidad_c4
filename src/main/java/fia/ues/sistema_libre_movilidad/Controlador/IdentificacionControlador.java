package fia.ues.sistema_libre_movilidad.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Identificacion;
import fia.ues.sistema_libre_movilidad.Servicio.IdentificacionServicio;

@Controller
public class IdentificacionControlador {
    
    @Autowired
    private IdentificacionServicio servicio;


    @GetMapping({"/identificacion"})
    public String index(Model modelo){
        modelo.addAttribute("identificacion", servicio.listarIdentificacion());
        return "identificacion/index";
    } 

    @GetMapping("/identificacion/nuevo")
    public String create(Model modelo){
        Identificacion identificacion = new Identificacion();
        modelo.addAttribute("identificacion", identificacion);
        return "identificacion/create";
    }

    @PostMapping("/identificacion")
    public String store(@ModelAttribute("identificacion") Identificacion identificacion){
        servicio.guardarIdentificacion(identificacion);
        return "redirect:/identificacion";
    }

    @GetMapping("/identificacion/editar/{id}")
    public String edit(@PathVariable Long id, Model modelo){
        modelo.addAttribute("identificacion", servicio.obtenerIdentificacionporId(id));
        return "identificacion/edit";
    }

    @PostMapping("/identificacion/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("identificacion") Identificacion identificacion,
    Model modelo){
        Identificacion identificacionExistente = servicio.obtenerIdentificacionporId(id);
        identificacionExistente.setId_identificacion(id);
        identificacionExistente.setTipo(identificacion.getTipo());
        identificacionExistente.setNumeroUnico(identificacion.getNumeroUnico());
        identificacionExistente.setPaisNacimiento(identificacion.getPaisNacimiento());
        identificacionExistente.setPaisResidencia(identificacion.getPaisResidencia());
        identificacionExistente.setOcupacion(identificacion.getOcupacion());

        servicio.actualizarIdentificacion(identificacionExistente);
        return "redirect:/identificacion";
    }

    @GetMapping("/identificacion/{id}")
    public String destroy(@PathVariable Long id){
        servicio.eliminarIdentificacion(id);
        return "redirect:/identificacion";
    }

}

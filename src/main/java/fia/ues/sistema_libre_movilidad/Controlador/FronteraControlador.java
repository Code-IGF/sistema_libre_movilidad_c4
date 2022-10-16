package fia.ues.sistema_libre_movilidad.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Frontera;
import fia.ues.sistema_libre_movilidad.Servicio.FronteraServicio;

@Controller
public class FronteraControlador {
    
    @Autowired
    private FronteraServicio servicio;

    @GetMapping({"/fronteras"})
    public String index(Model modelo){
        modelo.addAttribute("fronteras", servicio.listarFronteras());
        return "frontera/index";
    }

    @GetMapping("/fronteras/nuevo")
    public String create(Model modelo){
        Frontera frontera = new Frontera();
        modelo.addAttribute("frontera", frontera);
        return "frontera/crear_frontera";
    }

    @PostMapping("/fronteras")
    public String store(@ModelAttribute("frontera") Frontera frontera){
        servicio.guardarFrontera(frontera);
        return "redirect:/frontera/index";
    }

    @GetMapping("/fronteras/editar/{id}")
    public String edit(@PathVariable Long id, Model modelo){
        modelo.addAttribute("frontera", servicio.obtenerFronteraPorId(id));
        return "editar_frontera";
    }

    @PostMapping("/fronteras/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("frontera") Frontera frontera,
    Model modelo){
        Frontera fronteraExistente = servicio.obtenerFronteraPorId(id);
        fronteraExistente.setId(id);
        fronteraExistente.setNombre(frontera.getNombreFrontera());

        servicio.actualizarFrontera(fronteraExistente);
        return "redirect:/fronteras";        
    }
    
    @GetMapping("/fronteras/{id}")
    public String destroy(@PathVariable Long id){
        servicio.eliminarFrontera(id);
        return "redirect:/fronteras";
    }
}

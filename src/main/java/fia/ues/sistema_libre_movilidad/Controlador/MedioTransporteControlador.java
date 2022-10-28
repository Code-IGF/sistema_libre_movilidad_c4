package fia.ues.sistema_libre_movilidad.Controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.MedioTransporte;
import fia.ues.sistema_libre_movilidad.Servicio.MedioTransporteServicio;

@Controller

public class MedioTransporteControlador {

    @Autowired
    private MedioTransporteServicio servicio;

    @GetMapping({"/medios_transporte"})
    public String index(Model modelo){
        modelo.addAttribute("medios_transporte",servicio.ListarMedioTransporte());
        return "medio_transporte/index";
    }

    @GetMapping("/Medio-Transporte/nueva")
    public String create(Model modelo){
        MedioTransporte medioTransporte = new MedioTransporte();
        modelo.addAttribute("Medio.Transporte", medioTransporte);
        return "Medio-Transporte/create";
    }

        @PostMapping("/Medio-Transporte")
    public String store(@ModelAttribute("Medio-Transporte") MedioTransporte medioTransporte){
        servicio.guardarMedioTransporte(medioTransporte);
        return "redirect:/Medio-Transporte/index";
    }

    @GetMapping("/Medio-Transporte/editar/{id}")
    public String edit(@PathVariable Long id, Model modelo){
        modelo.addAttribute("Medio-Transporte", servicio.obtenerMedioTransporteporId(id));
        return "MedioTransporte/edit";
    }

    @PostMapping("/MedioTransporte/{id}")
    

    @GetMapping("/Medio-Transporte/{id}")
    public String destroy(@PathVariable Long id){
        servicio.eliminarMedioTransporte(id);
        return "redirect:/Medio-Transporte/index";
    }


    
}

package fia.ues.sistema_libre_movilidad.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.OficialAduanero;
import fia.ues.sistema_libre_movilidad.Servicio.OficialAduaneroServicio;

@Controller
public class OficialAduaneroControlador {
    @Autowired
    private OficialAduaneroServicio servicio;

    @GetMapping({"/oficial-aduanero"})
    public String listarOficialAduanero(Model modelo){
        modelo.addAttribute("oficial-aduanero", servicio.listarOficialAduanero());
        return "oficial_aduanero/index";
    }

    @GetMapping("/oficial-aduanero/nueva")
    public String crearOficialAduaneroFormulario(Model modelo){
        OficialAduanero oficialAduanero = new OficialAduanero();
        modelo.addAttribute("oficial-aduanero", oficialAduanero);
        return "oficial_aduanero/create";
    }

    @PostMapping("/oficial-aduanero")
    public String guardarOficialAduanero(@ModelAttribute("oficial-aduanero") OficialAduanero oficialAduanero){
        servicio.guardarOficialAduanero(oficialAduanero);
        return "redirect:/oficial_aduanero/index";
    }

    @GetMapping("/oficial-aduanero/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("oficial-aduanero", servicio.obtenerOficialAduaneroporId(id));
        return "oficial_aduanero/edit";
    }

    @PostMapping("/oficial-aduanero/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("oficial-aduanero") OficialAduanero oficialAduanero,
    Model modelo){
        OficialAduanero empresaTransporteExistente = servicio.obtenerOficialAduaneroporId(id);
        empresaTransporteExistente.setId(id);
        empresaTransporteExistente.setNombreOficialAduanero(oficialAduanero.getNombreOficialAduanero());
     
        servicio.actualizarOficialAduanero(empresaTransporteExistente);
        return "redirect:/oficial-aduanero/index";
    }

    @GetMapping("/oficial-aduanero/{id}")
    public String eliminarOficialAduanero(@PathVariable Long id){
        servicio.eliminarOficialAduanero(id);
        return "redirect:/oficial-aduanero/index";
    }
}

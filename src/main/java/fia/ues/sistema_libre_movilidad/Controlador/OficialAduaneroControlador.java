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

    @GetMapping({"/OficialAduanero"})
    public String listarOficialAduanero(Model modelo){
        modelo.addAttribute("", servicio.listarOficialAduanero());
        return "";
    }

    @GetMapping("/empresa_transporte/nueva")
    public String crearOficialAduaneroFormulario(Model modelo){
        OficialAduanero oficialAduanero = new OficialAduanero();
        modelo.addAttribute("empresa_transporte", oficialAduanero);
        return "crear_empresa_transporte";
    }

    @PostMapping("/empresas_transporte")
    public String guardarOficialAduanero(@ModelAttribute("empresa_transporte") OficialAduanero oficialAduanero){
        servicio.guardarOficialAduanero(oficialAduanero);
        return "redirect:/empresas_transporte";
    }

    @GetMapping("/empresas_transporte/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("empresa_transporte", servicio.obtenerOficialAduaneroporId(id));
        return "editar_empresa_transporte";
    }

    @PostMapping("/empresas_transporte/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("empresa_transporte") OficialAduanero oficialAduanero,
    Model modelo){
        OficialAduanero empresaTransporteExistente = servicio.obtenerOficialAduaneroporId(id);
        empresaTransporteExistente.setId(id);
        empresaTransporteExistente.setNombreOficialAduanero(oficialAduanero.getNombreOficialAduanero());
     
        servicio.actualizarOficialAduanero(empresaTransporteExistente);
        return "redirect:/empresas_transporte";
    }

    @GetMapping("/empresas_transporte/{id}")
    public String eliminarOficialAduanero(@PathVariable Long id){
        servicio.eliminarOficialAduanero(id);
        return "redirect:/empresas_transporte";
    }
}

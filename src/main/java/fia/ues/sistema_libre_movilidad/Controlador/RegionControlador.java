package fia.ues.sistema_libre_movilidad.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Region;
import fia.ues.sistema_libre_movilidad.Servicio.RegionServicio;

@Controller
public class RegionControlador {
    
@Autowired
private RegionServicio servicio;

@GetMapping("/regiones")
public String listarRegiones(Model modelo){
    modelo.addAttribute("regiones", servicio.listarRegiones());
    return "regiones";
}

@GetMapping("/regiones/nuevo")
public String crearRegionFormulario (Model modelo){
    Region region = new Region();
    modelo.addAttribute("region",region);
    return "crear_region";
}
@PostMapping("/region")
public String guardarRegion(@ModelAttribute("region") Region region){
    servicio.guardarRegion(region);
    return "redirect:/regiones";

}
@GetMapping("/regiones/editar/{id}")
public String mostrarFormularioEditar(@PathVariable Long id, Model modelo){
    modelo.addAttribute("region", servicio.obtenerRegionPorId(id));
    return "editar_region";
}

@PostMapping("/regiones/{id}")
public String actualizarRegion(@PathVariable Long id, @ModelAttribute("region") Region region,
Model modelo){
    Region regionExistente = servicio.obtenerRegionPorId(id);
    regionExistente.setId(id);
    regionExistente.setRegion(region.getRegion());
    
    servicio.actualizarRegion(regionExistente);
    return "redirect:/regiones";
}

@GetMapping("/regiones/{id}")
public String eliminarRegion(@PathVariable Long id){
    servicio.eliminarRegion(id);
    return "redirect:/regiones";
}
}

package fia.ues.sistema_libre_movilidad.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Pais;
import fia.ues.sistema_libre_movilidad.Entidad.Region;
import fia.ues.sistema_libre_movilidad.Servicio.PaisServicio;
import fia.ues.sistema_libre_movilidad.Servicio.RegionServicio;

@Controller
public class RegionControlador {
    
@Autowired
private RegionServicio servicio;

@Autowired
    private PaisServicio paisServicio;

@GetMapping("/regiones")
public String index(Model modelo){
    modelo.addAttribute("regiones", servicio.listarRegiones());
    return "region/index";
}

@GetMapping("/regiones/nuevo")
public String create(Model modelo){
    Region region = new Region();
    List<Pais> listaPaises=paisServicio.listarPaises();
    modelo.addAttribute("region",region);
    modelo.addAttribute("paises", listaPaises);
    return "crear_region";
}
@PostMapping("/region")
public String store(@ModelAttribute("region") Region region){
    servicio.guardarRegion(region);
    return "redirect:/regiones";

}
@GetMapping("/regiones/editar/{id}")
public String edit(@PathVariable Long id, Model modelo){
    modelo.addAttribute("region", servicio.obtenerRegionPorId(id));
    return "editar_region";
}

@PostMapping("/regiones/{id}")
public String update(@PathVariable Long id, @ModelAttribute("region") Region region,
Model modelo){
    Region regionExistente = servicio.obtenerRegionPorId(id);
    regionExistente.setId(id);
    regionExistente.setRegion(region.getRegion());
    
    servicio.actualizarRegion(regionExistente);
    return "redirect:/regiones";
}

@GetMapping("/regiones/{id}")
public String destroy(@PathVariable Long id){
    servicio.eliminarRegion(id);
    return "redirect:/regiones";
}
}

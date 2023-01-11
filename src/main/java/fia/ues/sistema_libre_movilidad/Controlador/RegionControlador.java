package fia.ues.sistema_libre_movilidad.Controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Pais;
import fia.ues.sistema_libre_movilidad.Entidad.Region;
import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
import fia.ues.sistema_libre_movilidad.Servicio.PaisServicio;
import fia.ues.sistema_libre_movilidad.Servicio.RegionServicio;
import fia.ues.sistema_libre_movilidad.Servicio.UsuarioServicio;

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
    List<Pais> paises=paisServicio.listarPaises();
    modelo.addAttribute("region",region);
    modelo.addAttribute("paises", paises);
    return "region/crear_region";
}
@PostMapping("/regiones")
public String store(@Valid @ModelAttribute("region") Region region, BindingResult result, Model model){
     List<Region> regionesLista = servicio.listarRegiones();
    // List<Usuario> listaUsuarios=usuarioServicio.listarUsuarios();
     String error="";
     String errorNombre="";

    if (result.hasErrors()){
            model.addAttribute("region", region);
            servicio.guardarRegion(region);
            return "redirect:/regiones";
    }

    for (Region r: regionesLista){
        if(r.getNombre()==region.getNombre()){
            model.addAttribute("region", region);
            error="Nombre ya asignado";
            model.addAttribute("error",error);
            return "redirect:/regiones";
        }
        if(r.getNombre().equals(region.getNombre())){
            model.addAttribute("region", region);
            errorNombre="Nombre ocupado";
            model.addAttribute("errorNombre", errorNombre);
            return "redirect:/regiones";
        }
    }
        servicio.guardarRegion(region);
        return "redirect:/regiones";
    }

    @GetMapping("/regiones/editar/{id}")
    public String edit(@PathVariable Long id, Model modelo){
        List<Pais> paises=paisServicio.listarPaises();
        modelo.addAttribute("paises", paises);
        modelo.addAttribute("region", servicio.obtenerRegionPorId(id));
        return "region/editar_region";
    }

    @PostMapping("/regiones/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("region") Region region,
    Model modelo){
        Region regionExistente = servicio.obtenerRegionPorId(id);
        regionExistente.setId(id);
        regionExistente.setNombre(region.getNombre());
        regionExistente.setPais(region.getPais());
        servicio.actualizarRegion(regionExistente);
        return "redirect:/regiones";
    }

    @GetMapping("/regiones/{id}")
    public String destroy(@PathVariable Long id){
        servicio.eliminarRegion(id);
        return "redirect:/regiones";
    }
}


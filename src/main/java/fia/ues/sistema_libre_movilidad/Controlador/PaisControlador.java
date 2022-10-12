package fia.ues.sistema_libre_movilidad.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Pais;
import fia.ues.sistema_libre_movilidad.Servicio.PaisServicio;

@Controller
public class PaisControlador {
    
@Autowired
private PaisServicio servicio;

@GetMapping("/paises")
public String listarPaises(Model modelo){
    modelo.addAttribute("paises", servicio.listarPaises());
    return "paises";
}

@GetMapping("/paises/nuevo")
public String crearPaisFormulario (Model modelo){
    Pais pais = new Pais();
    modelo.addAttribute("paises",pais);
    return "crear_pais";
}
@GetMapping("/paises")
public String guardarPais(@ModelAttribute("pais") Pais pais){
    servicio.guardarPais(pais);
    return "redirect:/paises";

}
@GetMapping("/paises/editar/{id}")
public String mostrarFormularioEditar(@PathVariable Long id, Model modelo){
    modelo.addAttribute("pais", servicio.obtenerPaisPorId(id));
    return "editar_pais";
}

@PostMapping("/paises/{id}")
public String actualizarPaiS(@PathVariable Long id, @ModelAttribute("pais") Pais pais,
Model modelo){
    Pais paisExistente = servicio.obtenerPaisPorId(id);
    paisExistente.setId(id);
    paisExistente.setPais(pais.getPais());
    
    servicio.actualizarPais(paisExistente);
    return "redirect:/paises";
}

@GetMapping("/paises/{id}")
public String eliminarPais(@PathVariable Long id){
    servicio.eliminarPais(id);
    return "redirect:/paises";
}
}

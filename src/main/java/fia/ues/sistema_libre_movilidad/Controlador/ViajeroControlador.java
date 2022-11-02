package fia.ues.sistema_libre_movilidad.Controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
import fia.ues.sistema_libre_movilidad.Entidad.Viajero;
import fia.ues.sistema_libre_movilidad.Servicio.UsuarioServicio;
import fia.ues.sistema_libre_movilidad.Servicio.ViajeroServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViajeroControlador {

    @Autowired
    private ViajeroServicio viajeroServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping({"/viajeros"})
    public String index(Model model) {
        model.addAttribute("viajeros", viajeroServicio.listarViajeros());
        return "viajero/index"; 
    }

    @GetMapping("/viajeros/nuevo")
    public String create(Model modelo){
        Viajero viajero = new Viajero();
        List<Usuario> listaUsuarios = usuarioServicio.listarUsuarios();
        modelo.addAttribute("viajero", viajero);
        modelo.addAttribute("usuarios", listaUsuarios);
        return "viajero/create";
    }

    @PostMapping("/viajeros")
    public String store(@Valid @ModelAttribute("viajero") Viajero viajero, BindingResult result, Model model){
        
        if(result.hasErrors()) {
            List<Usuario> listaUsuarios = usuarioServicio.listarUsuarios();
            model.addAttribute("viajero", viajero);
            model.addAttribute("usuarios", listaUsuarios);
            return "viajero/create";
        }
        
        viajeroServicio.guardarViajero(viajero);
        return "redirect:/viajeros";
    }

    @GetMapping("/viajeros/editar/{id}")
    public String edit(@PathVariable Long id, Model modelo){
        modelo.addAttribute("viajero", viajeroServicio.obtenerViajeroPorId(id));
        return "viajero/edit";
    }

    @PostMapping("/viajeros/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("viajero") Viajero viajero,
    Model modelo){
        Viajero viajeroExistente = viajeroServicio.obtenerViajeroPorId(id);
        viajeroExistente.setId(id);
        viajeroExistente.setNombre(viajero.getNombre());
        viajeroExistente.setApellido(viajero.getApellido());
        viajeroExistente.setFechaNacimiento(viajero.getFechaNacimiento());
        viajeroExistente.setSexo(viajero.getSexo());
        viajeroExistente.setTelefono(viajero.getTelefono());

        viajeroServicio.actualizarViajero(viajeroExistente);
        return "redirect:/viajeros";
    }

    @GetMapping("/viajeros/{id}")
    public String destroy(@PathVariable Long id){
        viajeroServicio.elminarViajero(id);
        return "redirect:/viajeros";
    }
}

package fia.ues.sistema_libre_movilidad.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import fia.ues.sistema_libre_movilidad.Entidad.Viajero;
import fia.ues.sistema_libre_movilidad.Servicio.ViajeroServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViajeroControlador {

    @Autowired
    private ViajeroServicio servicio;

    @GetMapping({"/viajeros"})
    public String listarViajeros(Model model) {
        model.addAttribute("viajeros", servicio.listarViajeros());
        return "viajeros"; 
    }

    @GetMapping("/viajeros/nuevo")
    public String crearViajeroFormulario(Model modelo){
        Viajero viajero = new Viajero();
        modelo.addAttribute("viajero", viajero);
        return "crear_viajero";
    }

    @PostMapping("/viajeros")
    public String guardarViajero(@ModelAttribute("viajero") Viajero viajero){
        servicio.guardarViajero(viajero);
        return "redirect:/viajeros";
    }

    @GetMapping("/viajeros/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("viajero", servicio.obtenerViajeroPorId(id));
        return "editar_viajero";
    }

    @PostMapping("/viajeros/{id}")
    public String actualizarViajero(@PathVariable Long id, @ModelAttribute("viajero") Viajero viajero,
    Model modelo){
        Viajero viajeroExistente = servicio.obtenerViajeroPorId(id);
        viajeroExistente.setId(id);
        viajeroExistente.setNombre(viajero.getNombre());
        viajeroExistente.setApellido(viajero.getApellido());
        viajeroExistente.setFechaNacimiento(viajero.getFechaNacimiento());
        viajeroExistente.setSexo(viajero.getSexo());
        viajeroExistente.setTelefono(viajero.getTelefono());

        servicio.actualizarViajero(viajeroExistente);
        return "redirect:/viajeros";
    }

    @GetMapping("/viajeros/{id}")
    public String eliminarViajero(@PathVariable Long id){
        servicio.elminarViajero(id);
        return "redirect:/viajeros";
    }
}


package fia.ues.sistema_libre_movilidad.Controlador;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Frontera;
import fia.ues.sistema_libre_movilidad.Entidad.SolicitudViaje;
import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
import fia.ues.sistema_libre_movilidad.Servicio.FronteraServicio;
import fia.ues.sistema_libre_movilidad.Servicio.SolicitudViajeServicio;
import fia.ues.sistema_libre_movilidad.Servicio.UsuarioServicio;

@Controller
public class SolicitudViajeControlador {
    
    @Autowired
    private SolicitudViajeServicio servicio;

    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @Autowired
    private FronteraServicio fronteraServicio;

    @GetMapping({"/solicitudes_viaje"})
    public String listarEstudiantes(Model modelo){
        modelo.addAttribute("solicitudes", servicio.listarSolicitudes());
        return "solicitud_viaje/index";
    }

    @GetMapping("/solicitudes_viaje/nuevo")
    public String create(Model modelo){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario=usuarioServicio.obtenerUsuarioPorEmail(auth.getName());
        modelo.addAttribute("usuario", usuario);
        List<Frontera> fronteras = fronteraServicio.listarFronteras();
        modelo.addAttribute("fronteras", fronteras);
        SolicitudViaje solicitudViaje = new SolicitudViaje();
        modelo.addAttribute("solicitud",solicitudViaje);
        return "solicitud_viaje/create";
    }

    @PostMapping("/solicitudes_viaje")
    public String store(@Valid @ModelAttribute("solicitud") SolicitudViaje solicitudViaje, BindingResult result, Model model){

        if (result.hasErrors()){
            model.addAttribute("solicitud", solicitudViaje);
            return "solicitud_viaje/create";
    }

        servicio.guardarSolicitudViaje(solicitudViaje);
        return "redirect:/solicitudes_viaje";
    }
    
    

    @GetMapping("/solicitudes_viaje/editar/{id}")
    public String edit(@PathVariable Long id, Model modelo){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario=usuarioServicio.obtenerUsuarioPorEmail(auth.getName());
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("solicitud", servicio.obtenerSolicitudPorId(id));
        return "solicitud_viaje/edit";
    }

    @PostMapping("/solicitudes/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("solicitud") SolicitudViaje solicitudViaje,
    Model modelo){

        SolicitudViaje solicitudExistente = servicio.obtenerSolicitudPorId(id);
        solicitudExistente.setIdSolicitudViaje(id);
        solicitudExistente.setEstado(solicitudViaje.getEstado());
        solicitudExistente.setFechaSolicitud(solicitudViaje.getFechaSolicitud());
        solicitudExistente.setMotivo(solicitudViaje.getMotivo());
        solicitudExistente.setPaisDestino(solicitudViaje.getPaisDestino());
        solicitudExistente.setPaisOrigen(solicitudViaje.getPaisOrigen());
        solicitudExistente.setUsuario(solicitudViaje.getUsuario());
        servicio.actualizarSolicitudViaje(solicitudExistente);
        return "redirect:/solicitudes_viaje";
    }

    @GetMapping("/solicitudes/{id}")
    public String destroy(@PathVariable Long id){
        servicio.eliminarSolicitudViaje(id);;
        return "redirect:/solicitudes_viaje";
    }
}

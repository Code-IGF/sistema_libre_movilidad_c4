package fia.ues.sistema_libre_movilidad.Controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fia.ues.sistema_libre_movilidad.Entidad.SolicitudViaje;
import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
import fia.ues.sistema_libre_movilidad.Servicio.SolicitudViajeServicio;
import fia.ues.sistema_libre_movilidad.Servicio.UsuarioServicio;



@Controller
public class Acceso {
    
    @Autowired
    UsuarioServicio usuarioServicio;

    @Autowired
    SolicitudViajeServicio solicitudViajeServicio;

    @GetMapping({"home"})
    public String start(Model modelo){
        //Para obtener el current user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        modelo.addAttribute("usuario", auth);
        Usuario usuarioLogueado=usuarioServicio.buscarPorEmail(auth.getName());
        int contador=0;
        int contadorRevisado=0;
        List<SolicitudViaje> solicitudes = solicitudViajeServicio.listarSolicitudes();
        List<SolicitudViaje> solicitudesUsuario = new ArrayList<>();
        for (SolicitudViaje solicitud : solicitudes) {
            if(solicitud.getUsuario().equals(usuarioLogueado)){
                solicitudesUsuario.add(solicitud);
                if(solicitud.getEstado().equals("En espera")){
                    contador++;
                }else{
                    contadorRevisado++;
                }
            }
        }
        modelo.addAttribute("contador", contador);
        modelo.addAttribute("contadorRevisado", contadorRevisado);
        modelo.addAttribute("solicitudes", solicitudesUsuario);

        if(usuarioLogueado.getRol().equals("Administrador")){
            return "home";
        }else{
            return "homeUsuario";
        }
        
    }

    @GetMapping("")
    public String login()
    {
        return "login";
    }
}

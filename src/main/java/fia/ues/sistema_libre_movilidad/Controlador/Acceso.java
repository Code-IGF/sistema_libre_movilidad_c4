package fia.ues.sistema_libre_movilidad.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
import fia.ues.sistema_libre_movilidad.Servicio.UsuarioServicio;



@Controller
public class Acceso {
    
    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping({"home"})
    public String start(Model modelo){
        //Para obtener el current user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        modelo.addAttribute("usuario", auth);
        Usuario usuarioLogueado=usuarioServicio.buscarPorEmail(auth.getName());
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

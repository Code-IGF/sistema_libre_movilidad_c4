package fia.ues.sistema_libre_movilidad.Controlador;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class Acceso {
    
    @GetMapping({"home"})
    public String start(Model modelo){
        //Para obtener el current user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        modelo.addAttribute("usuario", auth);
        return "home";
    }

    @GetMapping("")
    public String login()
    {
        return "login";
    }
}

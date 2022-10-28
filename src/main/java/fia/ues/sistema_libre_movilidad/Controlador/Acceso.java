package fia.ues.sistema_libre_movilidad.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Acceso {
    
    @GetMapping({"home"})
    public String start(){
        return "home";
    }

    @GetMapping("")
    public String login()
    {
        return "login";
    }
}

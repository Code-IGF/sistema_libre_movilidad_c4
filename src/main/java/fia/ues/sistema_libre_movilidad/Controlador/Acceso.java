package fia.ues.sistema_libre_movilidad.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Acceso {
    @GetMapping({""})
    public String start(){
        return "vista_inicial";
    }

    @GetMapping("login")
    public String login()
    {
        return "login";
    }
}

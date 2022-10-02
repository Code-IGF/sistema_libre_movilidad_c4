package fia.ues.sistema_libre_movilidad.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ejemplo {
    @GetMapping("/prueba")
    public String listar(Model modelo){
        return "prueba";
    }
}

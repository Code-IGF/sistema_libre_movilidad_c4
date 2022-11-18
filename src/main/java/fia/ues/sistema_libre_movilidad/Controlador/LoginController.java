package fia.ues.sistema_libre_movilidad.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @GetMapping("/iniciarSesion")
    public String loginPage(){
        return "login";
    }

    // Login form with error
    @RequestMapping("/login-failed")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
    // Logout
    @RequestMapping("/finalizarSesion")
    public String logout(Model model) {
        model.addAttribute("logout", true);
        return "login";
    }
}

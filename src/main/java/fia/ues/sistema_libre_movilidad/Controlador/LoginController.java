package fia.ues.sistema_libre_movilidad.Controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
import fia.ues.sistema_libre_movilidad.Entidad.Viajero;
import fia.ues.sistema_libre_movilidad.Servicio.UsuarioServicio;

@Controller
public class LoginController {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/iniciarSesion")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/registro")
    public String registroPage(Model modelo){
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "register";
    }
    @PostMapping("/registro")
    public String store(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model){
        if(result.hasErrors()) {
            model.addAttribute("usuario", usuario);
            return "register";
        }
        try{
            Viajero viajero = new Viajero();
            model.addAttribute("viajero", viajero);
            Usuario user=usuarioServicio.guardarUsuario(usuario);
            model.addAttribute("usuario", user);
            return "viajero/create";
        }
        catch(Exception ex){
            model.addAttribute("registroError", true);
            return "register";
        }
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

package fia.ues.sistema_libre_movilidad.Controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
import fia.ues.sistema_libre_movilidad.Servicio.UsuarioServicio;

@Controller
public class LoginController {
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
	public BCryptPasswordEncoder encoder;

    @GetMapping("/")
    public String loginPage(){
        return "Auth/login";
    }

    @GetMapping("/registro")
    public String registroPage(Model modelo){
        Usuario usuario = new Usuario();
        System.out.println(usuario);
        modelo.addAttribute("usuario", usuario);
        return "Auth/register";
    }
    //Función de registro
    @PostMapping("/registro")
    public String store(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model){
        if(result.hasErrors()) {
            model.addAttribute("usuario", usuario);
            return "Auth/register";
        }
        try{
            //Encriptando contraseña
            usuario.setContrasenia(encoder.encode(usuario.getContrasenia()));
            usuario.setRol("Viajero");
            usuarioServicio.guardarUsuario(usuario);
            //Ver ViajeroControlador para ver como continúa este proceso
            return "redirect:/";
        }
        catch(Exception ex){
            model.addAttribute("registroError", true);
            return "Auth/register";
        }
    }

    // Login form with error
    @RequestMapping("/login-failed")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "Auth/login";
    }
    // Logout
    @RequestMapping("/finalizarSesion")
    public String logout(Model model) {
        model.addAttribute("logout", true);
        return "Auth/login";
    }
}

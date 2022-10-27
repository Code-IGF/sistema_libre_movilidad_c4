package fia.ues.sistema_libre_movilidad.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
import fia.ues.sistema_libre_movilidad.Servicio.UsuarioServicio;

@Controller
public class UsuarioControlador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping({"/usuarios"})
    public String index(Model modelo){
        modelo.addAttribute("usuarios", usuarioServicio.listarUsuarios());
        return "usuario/index";
    }


    @GetMapping("/usuarios/nuevo")
    public String create(Model modelo){
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "usuario/crear_usuario";
    }


    @PostMapping("/usuarios")
    public String store( @ModelAttribute("Usuario") Usuario usuario, BindingResult result, Model model){
        if(result.hasErrors()) {
            model.addAttribute("usuario", usuario);
            return "usuario/crear_usuario";
        }
        usuarioServicio.guardarUsuario(usuario);
        return "redirect:/usuarios";
    }


    @GetMapping("/usuarios/editar/{id}")
    public String edit(@PathVariable Long id, Model modelo){
        modelo.addAttribute("usuario", usuarioServicio.obtenerUsuarioPorId(id));
        return "usuario/editar_usuario";
    }


    @PostMapping("/usuarios/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario,
    Model modelo){
        Usuario usuarioExistente = usuarioServicio.obtenerUsuarioPorId(id);
        usuarioExistente.setId(id);
        usuarioExistente.setCorreo(usuario.getCorreo());
        usuarioExistente.setContrasenia(usuario.getContrasenia());

        usuarioServicio.actualizarUsuario(usuarioExistente);
        return "redirect:/usuarios";        
    }

    
    @GetMapping("/usuarios/{id}")
    public String destroy(@PathVariable Long id){
        usuarioServicio.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
}

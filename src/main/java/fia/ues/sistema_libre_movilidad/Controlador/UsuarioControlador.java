package fia.ues.sistema_libre_movilidad.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
import fia.ues.sistema_libre_movilidad.Servicio.UsuarioServicio;

@Controller
public class UsuarioControlador {
    
    @Autowired
    private UsuarioServicio servicio;

    @GetMapping({"/usuarios"})
    public String index(Model modelo){
        modelo.addAttribute("usuarios", servicio.listarUsuarios());
        return "usuario/index";
    }

    @GetMapping("/usuarios/nuevo")
    public String create(Model modelo){
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "crear_usuario";
    }

    @PostMapping("/usuarios")
    public String store(@ModelAttribute("usuario") Usuario usuario){
        servicio.guardarUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String edit(@PathVariable Long id, Model modelo){
        modelo.addAttribute("usuario", servicio.obtenerUsuarioPorId(id));
        return "editar_usuario";
    }

    @PostMapping("/usuarios/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario,
    Model modelo){
        Usuario usuarioExistente = servicio.obtenerUsuarioPorId(id);
        usuarioExistente.setId(id);
        usuarioExistente.setCorreo(usuario.getCorreo());
        usuarioExistente.setContrasenia(usuario.getContrasenia());

        servicio.actualizarUsuario(usuarioExistente);
        return "redirect:/usuarios";        
    }
    
    @GetMapping("/usuarios/{id}")
    public String destroy(@PathVariable Long id){
        servicio.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
}

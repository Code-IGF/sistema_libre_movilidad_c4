package fia.ues.sistema_libre_movilidad.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Identificacion;
import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
/*import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Identificacion;*/
import fia.ues.sistema_libre_movilidad.Servicio.IdentificacionServicio;
import fia.ues.sistema_libre_movilidad.Servicio.UsuarioServicio;

@Controller
public class IdentificacionControlador {
    
    @Autowired
    private IdentificacionServicio servicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping({"identificaciones"})
    public String index(Model modelo){
        modelo.addAttribute("identificaciones", servicio.listarIdentificacion());
        return "identificacion/index";
    }
    
    @GetMapping("identificaciones/nuevo")
    public String crearIdentificacionFormulario(Model modelo){
        Identificacion identificacion = new Identificacion();
        List<Usuario> listaUsuarios=usuarioServicio.listarUsuarios();
        modelo.addAttribute("estudiante", identificacion);
        modelo.addAttribute("usuarios", listaUsuarios);
        return "estudiante/crear_estudiante";
    }

}

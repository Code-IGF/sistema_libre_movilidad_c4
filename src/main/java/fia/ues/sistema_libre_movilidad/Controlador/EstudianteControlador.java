package fia.ues.sistema_libre_movilidad.Controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Estudiante;
import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
import fia.ues.sistema_libre_movilidad.Servicio.EstudianteServicio;
import fia.ues.sistema_libre_movilidad.Servicio.UsuarioServicio;

@Controller
public class EstudianteControlador {
    
    @Autowired
    private EstudianteServicio servicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping({"/estudiantes"})
    public String listarEstudiantes(Model modelo){
        modelo.addAttribute("estudiantes", servicio.listarEstudiantes());
        return "estudiante/estudiantes";
    }

    @GetMapping("/estudiantes/nuevo")
    public String crearEstudianteFormulario(Model modelo){
        Estudiante estudiante = new Estudiante();
        List<Usuario> listaUsuarios=usuarioServicio.listarUsuarios();
        modelo.addAttribute("estudiante", estudiante);
        modelo.addAttribute("usuarios", listaUsuarios);
        return "estudiante/crear_estudiante";
    }

    @PostMapping("/estudiantes")
    public String guardarEstudiante(@Valid @ModelAttribute("estudiante") Estudiante estudiante, BindingResult result, Model model){
        
        if (result.hasErrors()){
                model.addAttribute("estudiante", estudiante);
                return "estudiante/crear_estudiante";
        }
        servicio.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("estudiante", servicio.obtenerEstudianteporId(id));
        return "estudiante/editar_estudiante";
    }

    @PostMapping("/estudiantes/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante,
    Model modelo){
        Estudiante estudianteExistente = servicio.obtenerEstudianteporId(id);
        estudianteExistente.setId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());

        servicio.actualizarEstudiante(estudianteExistente);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/{id}")
    public String eliminarEstudiante(@PathVariable Long id){
        servicio.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}

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
    public String index(Model modelo){
        modelo.addAttribute("estudiantes", servicio.listarEstudiantes());
        return "estudiante/estudiantes";
    }

    @GetMapping("/estudiantes/nuevo")
    public String create(Model modelo){
        Estudiante estudiante = new Estudiante();
        List<Usuario> listaUsuarios=usuarioServicio.listarUsuarios();
        modelo.addAttribute("estudiante", estudiante);
        modelo.addAttribute("usuarios", listaUsuarios);
        return "estudiante/crear_estudiante";
    }

    @PostMapping("/estudiantes")
    public String store(@Valid @ModelAttribute("estudiante") Estudiante estudiante, BindingResult result, Model model){
        List<Estudiante> estudiantesLista = servicio.listarEstudiantes();
        List<Usuario> listaUsuarios=usuarioServicio.listarUsuarios();
        //String error="";*/
        String error="";
        String errorEmail="";
        if (result.hasErrors()){
                model.addAttribute("estudiante", estudiante);
                model.addAttribute("usuarios", listaUsuarios);
                return "estudiante/crear_estudiante";
        }
        /*for (Estudiante e : estudiante1) {
            if(e.getUsuario().getId()==estudiante.getUsuario().getId() || e.getEmail()==estudiante.getEmail()){
                error="Usuario ya usado";
                model.addAttribute("estudiante", estudiante);
                model.addAttribute("error", error);
                model.addAttribute("usuarios", listaUsuarios);
                return "estudiante/crear_estudiante";
            }
        }*/
        
        for (Estudiante e : estudiantesLista) {
            if(e.getUsuario().getCorreo()==estudiante.getUsuario().getCorreo()){
                model.addAttribute("estudiante", estudiante);
                model.addAttribute("usuarios", listaUsuarios);
                error="Usuario ya asignado";
                model.addAttribute("error", error);
                return "estudiante/crear_estudiante";
            }
            if(e.getEmail().equals(estudiante.getEmail())){
                model.addAttribute("estudiante", estudiante);
                model.addAttribute("usuarios", listaUsuarios);
                errorEmail="Email ocupado";
                model.addAttribute("errorEmail", errorEmail);
                return "estudiante/crear_estudiante";
            }
        }
        servicio.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/editar/{id}")
    public String edit(@PathVariable Long id, Model modelo){
        modelo.addAttribute("estudiante", servicio.obtenerEstudianteporId(id));
        return "estudiante/editar_estudiante";
    }

    @PostMapping("/estudiantes/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante,
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
    public String destroy(@PathVariable Long id){
        servicio.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}

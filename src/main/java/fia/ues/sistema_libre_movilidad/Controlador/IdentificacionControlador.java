package fia.ues.sistema_libre_movilidad.Controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Identificacion;
import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
import fia.ues.sistema_libre_movilidad.Servicio.IdentificacionServicio;
import fia.ues.sistema_libre_movilidad.Servicio.PaisServicio;
import fia.ues.sistema_libre_movilidad.Servicio.UsuarioServicio;

@Controller
public class IdentificacionControlador {
    
    @Autowired
    private IdentificacionServicio servicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private PaisServicio paisServicio;



    @GetMapping({"/identificacion"})
    public String index(Model modelo){
        modelo.addAttribute("identificacion", servicio.listarIdentificacion());
        return "identificacion/index";
    }
    //Views para el perfil de usuario 
    @GetMapping({"/perfil/identificaciones"})
    public String userIdentifications(Model modelo){
        String userEmail =SecurityContextHolder.getContext().getAuthentication().getName();
        Long id_usuario = usuarioServicio.buscarPorEmail(userEmail).getId();
        modelo.addAttribute("identificaciones", servicio.listarIdentificacionByUsuarioId(id_usuario));
        return "usuario/identificaciones";
        //System.out.println(id_usuario);
    }
    @GetMapping("/perfil/identificaciones/nueva")
    public String createUserIdentification(Model modelo){
        Identificacion identificacion = new Identificacion();
        modelo.addAttribute("identificacion", identificacion);
        modelo.addAttribute("paises", paisServicio.listarPaises());
        return "usuario/nuevaIdentificacion";
    }
    @PostMapping("/perfil/identificaciones/nueva")
    public String storeUserIdentificacion(@Valid @ModelAttribute("identificacion") Identificacion identificacion, BindingResult result, Model model){
        if (result.hasErrors()){
                model.addAttribute("identificacion", identificacion);
                return "usuario/nuevaIdentificacion";
        }
        String userEmail =SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario = usuarioServicio.buscarPorEmail(userEmail);
        identificacion.setUsuario(usuario);
        servicio.guardarIdentificacion(identificacion);
        return "redirect:/perfil/identificaciones";
    } 

    @GetMapping("/identificacion/nuevo")
    public String create(Model modelo){
        Identificacion identificacion = new Identificacion();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario=usuarioServicio.obtenerUsuarioPorEmail(auth.getName());

        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("identificacion", identificacion);
        return "identificacion/create";
    }

    @PostMapping("/identificacion")
    public String store(@Valid @ModelAttribute("identificacion") Identificacion identificacion, 
    BindingResult result, Model model){
        String error="";
        String errorEmail="";
        if (result.hasErrors()){
                model.addAttribute("identificacion", identificacion);
                return "identificacion/create";
        }
        servicio.guardarIdentificacion(identificacion);
        return "redirect:/identificacion";
    }

    @GetMapping("/identificacion/editar/{id}")
    public String edit(@PathVariable Long id, Model modelo){
        modelo.addAttribute("identificacion", servicio.obtenerIdentificacionporId(id));
        return "identificacion/edit";
    }

    @PostMapping("/identificacion/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("identificacion") Identificacion identificacion,
    Model modelo){
        Identificacion identificacionExistente = servicio.obtenerIdentificacionporId(id);
        identificacionExistente.setId_identificacion(id);
        identificacionExistente.setTipo(identificacion.getTipo());
        identificacionExistente.setNumeroUnico(identificacion.getNumeroUnico());
        identificacionExistente.setPaisNacimiento(identificacion.getPaisNacimiento());
        identificacionExistente.setPaisResidencia(identificacion.getPaisResidencia());
        identificacionExistente.setOcupacion(identificacion.getOcupacion());

        servicio.actualizarIdentificacion(identificacionExistente);
        return "redirect:/identificacion";
    }

    @GetMapping("/identificacion/{id}")
    public String destroy(@PathVariable Long id){
        servicio.eliminarIdentificacion(id);
        return "redirect:/identificacion";
    }

}

package fia.ues.sistema_libre_movilidad.Controlador;
import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.Pais;
import fia.ues.sistema_libre_movilidad.Servicio.PaisServicio;
import fia.ues.sistema_libre_movilidad.Servicio.UsuarioServicio;
import fia.ues.sistema_libre_movilidad.Entidad.Usuario;

@Controller
public class PaisControlador {
        
    @Autowired
    private PaisServicio servicio;
    
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping({"/paises"})
    public String index(Model modelo){
        modelo.addAttribute("paises", servicio.listarPaises());
        return "pais/index";
    }

    @GetMapping("/paises/nuevo")
    public String create(Model modelo){
        Pais pais = new Pais();
        List<Usuario> listaUsuarios= usuarioServicio.listarUsuarios();
        modelo.addAttribute("pais",pais);
        modelo.addAttribute("usuarios", listaUsuarios);
        return "pais/crear_pais";
    }
    @PostMapping("/paises")
    public String store(@Valid@ModelAttribute("pais") Pais pais, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("pais", pais);
        return "pais/crear_pais";
    }
    servicio.guardarPais(pais);
        return "redirect:/paises";
    }

    @GetMapping("/paises/editar/{id}")
    public String edit(@PathVariable Long id, Model modelo){
        modelo.addAttribute("pais", servicio.obtenerPaisPorId(id));
        return "pais/editar_pais";
    }

    @PostMapping("/paises/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("pais") Pais pais,
    Model modelo){
        Pais paisExistente = servicio.obtenerPaisPorId(id);
        paisExistente.setId(id);
        paisExistente.setNombre(pais.getNombre());
        
        servicio.actualizarPais(paisExistente);
        return "redirect:/paises";
    }

    @GetMapping("/paises/{id}")
    public String destroy(@PathVariable Long id){
        servicio.eliminarPais(id);
        return "redirect:/paises";
    }
}

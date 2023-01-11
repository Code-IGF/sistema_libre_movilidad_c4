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

@Controller
public class PaisControlador {
        
    @Autowired
    private PaisServicio servicio;

    @GetMapping({"/paises"})
    public String index(Model modelo){
        modelo.addAttribute("paises", servicio.listarPaises());
        return "pais/index";
    }

    @GetMapping("/paises/nuevo")
    public String create(Model modelo){
        Pais pais = new Pais();
        modelo.addAttribute("pais",pais);
        return "pais/crear_pais";
    }
    @PostMapping("/paises")
    public String store(@Valid @ModelAttribute("pais") Pais pais, BindingResult result, Model model){
      
        List<Pais> paisLista= servicio.listarPaises();
        String error="";
        String errorNombre="";

       //List<Usuario> listaUsuario=usuarioServicio.listarUsuarios();
        
        if (result.hasErrors()){
            model.addAttribute("pais", pais);
            return "pais/crear_pais";
    }
        for(Pais p: paisLista){
            if(p.getNombre()==pais.getNombre()){
                model.addAttribute("pais", pais);
                error="Nombre ya asignado";
                model.addAttribute("error",error);
                return "redirect:/paises";
            }
            if(p.getNombre().equals(pais.getNombre())){
                model.addAttribute("pais", pais);
                errorNombre="Nombre ocupado";
                model.addAttribute("errorNombre", errorNombre);
                return "redirect:/paises";
            }
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

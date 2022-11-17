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

import fia.ues.sistema_libre_movilidad.Entidad.OficialAduanero;
import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
import fia.ues.sistema_libre_movilidad.Servicio.OficialAduaneroServicio;
import fia.ues.sistema_libre_movilidad.Servicio.UsuarioServicio;

@Controller
public class OficialAduaneroControlador {

    @Autowired
    private OficialAduaneroServicio servicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping({"/oficial_aduanero"})
    public String index(Model modelo){
        modelo.addAttribute("oficiales_aduaneros", servicio.listarOficialAduanero());
        return "oficial_aduanero/index";
    }

    @GetMapping("/oficial_aduanero/nuevo")
    public String create(Model modelo){
        OficialAduanero oficialAduanero = new OficialAduanero();
        List<Usuario> listaUsuarios = usuarioServicio.listarUsuarios();
        modelo.addAttribute("oficial_aduanero", oficialAduanero);
        modelo.addAttribute("usuarios", listaUsuarios);
        return "oficial_aduanero/create";
    }


    @PostMapping("/oficial_aduanero")
    public String store(@Valid @ModelAttribute("oficial_aduanero") OficialAduanero oficialAduanero, BindingResult result, Model model){
        //List<OficialAduanero> oficialAduanerosLista = servicio.listarOficialAduanero();
        //List<Usuario> listaUsuarios=usuarioServicio.listarUsuarios();
        //String error="";

        if(result.hasErrors()){
            model.addAttribute("oficial_aduanero", oficialAduanero);
            return "oficial_aduanero/create";
        }

        if(oficialAduanero.getNombreOficialAduanero().equals(" ")){
            model.addAttribute("oficial_aduanero", oficialAduanero);
            return "oficial_aduanero/create";
        }
        /*for (OficialAduanero e : oficialAduanerosLista) {
            if(e.getNombreOficialAduanero()==""||e.getNombreOficialAduanero()==" "){
                model.addAttribute("oficial_aduanero", oficialAduanero);
                error="El campo del nombre esta siendo enviado vacio";
                model.addAttribute("error", error);
                return "redirect:/oficial_aduanero";
            }
        }*/

        servicio.guardarOficialAduanero(oficialAduanero);
        return "redirect:/oficial_aduanero";
    }

    @GetMapping("/oficial_aduanero/editar/{id}")
    public String edit(@PathVariable Long id, Model modelo){
        modelo.addAttribute("oficial_aduanero", servicio.obtenerOficialAduaneroporId(id));
        return "oficial_aduanero/edit";
    }

    @PostMapping("/oficial_aduanero/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("oficial_aduanero") OficialAduanero oficialAduanero,
    BindingResult result, Model model){
        OficialAduanero empresaTransporteExistente = servicio.obtenerOficialAduaneroporId(id);
        empresaTransporteExistente.setId(id);
        empresaTransporteExistente.setNombreOficialAduanero(oficialAduanero.getNombreOficialAduanero());
     
        if(result.hasErrors()){
            model.addAttribute("oficial_aduanero", oficialAduanero);
            return "oficial_aduanero/create";
        }

        if(oficialAduanero.getNombreOficialAduanero().equals(" ")){
            model.addAttribute("oficial_aduanero", oficialAduanero);
            return "oficial_aduanero/create";
        }

        servicio.actualizarOficialAduanero(empresaTransporteExistente);
        return "redirect:/oficial_aduanero";
    }

    @GetMapping("/oficial_aduanero/{id}")
    public String destroy(@PathVariable Long id){
        servicio.eliminarOficialAduanero(id);
        return "redirect:/oficial_aduanero";
    }
}

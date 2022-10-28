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

import fia.ues.sistema_libre_movilidad.Entidad.EmpresaTransporte;
import fia.ues.sistema_libre_movilidad.Servicio.EmpresaTransporteServicio;
import fia.ues.sistema_libre_movilidad.Servicio.UsuarioServicio;
import fia.ues.sistema_libre_movilidad.Entidad.Usuario;


@Controller
public class EmpresaTransporteControlador {
    @Autowired
    private EmpresaTransporteServicio servicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping({"/empresas_transporte"})
    public String index(Model modelo){
        modelo.addAttribute("empresas_transporte", servicio.listarEmpresasTransporte());
        return "empresa_transporte/index";
    }

    @GetMapping("/empresas_transporte/nuevo")
    public String create(Model modelo){
        EmpresaTransporte empresasTransporte = new EmpresaTransporte();
        List<Usuario> listaUsuarios= usuarioServicio.listarUsuarios();
        modelo.addAttribute("empresa_transporte", empresasTransporte);
        modelo.addAttribute("usuarios", listaUsuarios);
        return "empresa_transporte/crear_empresa_transporte";
    }

    @PostMapping("/empresas_transporte")
    public String store(@Valid @ModelAttribute("empresa_transporte") EmpresaTransporte empresaTransporte, BindingResult result, Model model){
        if (result.hasErrors()){
            servicio.guardarEmpresaTransporte(empresaTransporte);
            return "redirect:/empresas_transporte";
        }
        servicio.guardarEmpresaTransporte(empresaTransporte);
        return "redirect:/empresas_transporte";
    }

    @GetMapping("/empresas_transporte/editar/{id}")
    public String edit(@PathVariable Long id, Model modelo){
        modelo.addAttribute("empresa_transporte", servicio.obtenerEmpresaTransporteporId(id));
        return "editar_empresa_transporte";
    }

    @PostMapping("/empresas_transporte/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("empresa_transporte") EmpresaTransporte empresaTransporte,
    Model modelo){
        EmpresaTransporte empresaTransporteExistente = servicio.obtenerEmpresaTransporteporId(id);
        empresaTransporteExistente.setId(id);
        empresaTransporteExistente.setNombre(empresaTransporte.getNombre());
     
        servicio.actualizarEmpresaTransporte(empresaTransporteExistente);
        return "redirect:/empresas_transporte";
    }

    @GetMapping("/empresas_transporte/{id}")
    public String destroy(@PathVariable Long id){
        servicio.eliminarEmpresaTransporte(id);
        return "redirect:/empresas_transporte";
    }
}

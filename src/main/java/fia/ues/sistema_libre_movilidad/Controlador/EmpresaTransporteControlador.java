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
import fia.ues.sistema_libre_movilidad.Servicio.EmpresaTransporteImpl;
import fia.ues.sistema_libre_movilidad.Servicio.EmpresaTransporteServicio;


@Controller
public class EmpresaTransporteControlador {
    @Autowired
    private EmpresaTransporteImpl servicio;

    @GetMapping({"/empresas_transporte"})
    public String index(Model modelo){
        modelo.addAttribute("empresas_transporte", servicio.listarEmpresasTransporte());
        return "empresa_transporte/index";
    }

    @GetMapping("/empresas_transporte/nuevo")
    public String create(Model modelo){
        EmpresaTransporte empresasTransporte = new EmpresaTransporte();
        modelo.addAttribute("empresa_transporte", empresasTransporte);
        return "empresa_transporte/crear_empresa_transporte";
    }

    @PostMapping("/empresas_transporte")
    public String store(@Valid @ModelAttribute("empresa_transporte") EmpresaTransporte empresaTransporte, BindingResult result, Model model){
        List<EmpresaTransporte> empresaTransporteLista = servicio.listarEmpresasTransporte();
        String error="";
        String errorNombre="";

        if (result.hasErrors()){
            model.addAttribute("empresa_transporte",empresaTransporte);
            servicio.guardarEmpresaTransporte(empresaTransporte);
            return "redirect:/empresas_transporte";
        }
        for (EmpresaTransporte em: empresaTransporteLista) {
            if(em.getNombre()==empresaTransporte.getNombre()){
                model.addAttribute("empresa_transporte",empresaTransporte);
                error="Nombre ya asignado";
                model.addAttribute("error", error);
                return "redirect:/empresas_transporte";
            }
            if(em.getNombre().equals(empresaTransporte.getNombre())){
                model.addAttribute("empresa_transporte",empresaTransporte);
                errorNombre="Nombre ocupado";
                model.addAttribute("errorNombre", errorNombre);
                return "redirect:/empresas_transporte"; 
            }
        }
        servicio.guardarEmpresaTransporte(empresaTransporte);
        return "redirect:/empresas_transporte";
    }

    @GetMapping("/empresas_transporte/editar/{id}")
    public String edit(@PathVariable Long id, Model modelo){
        modelo.addAttribute("empresa_transporte", servicio.obtenerEmpresaTransporteporId(id));
        return "/empresa_transporte/editar_empresa_transporte";
    }

    @PostMapping("/empresas_transporte/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("empresa_transporte") EmpresaTransporte empresaTransporte,
    Model modelo){
        EmpresaTransporte empresaTransporteExistente = servicio.obtenerEmpresaTransporteporId(id);
        empresaTransporteExistente.setId(id);
        empresaTransporteExistente.setNombre(empresaTransporte.getNombre());
        List<EmpresaTransporte> empresaTransporteLista = servicio.listarEmpresasTransporte();
        servicio.actualizarEmpresaTransporte(empresaTransporteExistente);
        return "redirect:/empresas_transporte";
    }

    @GetMapping("/empresas_transporte/{id}")
    public String destroy(@PathVariable Long id){
        servicio.eliminarEmpresaTransporte(id);
        return "redirect:/empresas_transporte";
    }
}

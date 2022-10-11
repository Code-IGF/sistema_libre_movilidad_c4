package fia.ues.sistema_libre_movilidad.Controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import fia.ues.sistema_libre_movilidad.Entidad.EmpresaTransporte;
import fia.ues.sistema_libre_movilidad.Servicio.EmpresaTransporteServicio;

@Controller
public class EmpresaTransporteControlador {
    @Autowired
    private EmpresaTransporteServicio servicio;

    @GetMapping({"/empresas_transporte"})
    public String listarEmpresasTransporte(Model modelo){
        modelo.addAttribute("empresas_transporte", servicio.listarEmpresasTransporte());
        return "empresas_transporte";
    }

    @GetMapping("/empresa_transporte/nueva")
    public String crearEmpresaTransporteFormulario(Model modelo){
        EmpresaTransporte empresasTransporte = new EmpresaTransporte();
        modelo.addAttribute("empresa_transporte", empresasTransporte);
        return "crear_empresa_transporte";
    }

    @PostMapping("/empresas_transporte")
    public String guardarEmpresaTransporte(@ModelAttribute("empresa_transporte") EmpresaTransporte empresaTransporte){
        servicio.guardarEmpresaTransporte(empresaTransporte);
        return "redirect:/empresas_transporte";
    }

    @GetMapping("/empresas_transporte/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("empresa_transporte", servicio.obtenerEmpresaTransporteporId(id));
        return "editar_empresa_transporte";
    }

    @PostMapping("/empresas_transporte/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("empresa_transporte") EmpresaTransporte empresaTransporte,
    Model modelo){
        EmpresaTransporte empresaTransporteExistente = servicio.obtenerEmpresaTransporteporId(id);
        empresaTransporteExistente.setId(id);
        empresaTransporteExistente.setNombre(empresaTransporte.getNombre());
     
        servicio.actualizarEmpresaTransporte(empresaTransporteExistente);
        return "redirect:/empresas_transporte";
    }

    @GetMapping("/empresas_transporte/{id}")
    public String eliminarEmpresaTransporte(@PathVariable Long id){
        servicio.eliminarEmpresaTransporte(id);
        return "redirect:/empresas_transporte";
    }
}

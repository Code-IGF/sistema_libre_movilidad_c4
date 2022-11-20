package fia.ues.sistema_libre_movilidad.Controlador;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fia.ues.sistema_libre_movilidad.Entidad.EmpresaTransporte;
import fia.ues.sistema_libre_movilidad.Entidad.MedioTransporte;
import fia.ues.sistema_libre_movilidad.Servicio.EmpresaTransporteServicio;
import fia.ues.sistema_libre_movilidad.Servicio.MedioTransporteServicio;

@Controller

public class MedioTransporteControlador {

    @Autowired
    private MedioTransporteServicio servicio;
    @Autowired
    private EmpresaTransporteServicio empresaServicio;


    @GetMapping({"/medios_transporte"})
    public String index(Model modelo){
        modelo.addAttribute("medios_transporte",servicio.ListarMedioTransporte());
        return "medio_transporte/index";
    }

    @GetMapping("/Medio-Transporte/nueva")
    public String create(Model modelo){
        List<EmpresaTransporte> empresas=empresaServicio.listarEmpresasTransporte();
        MedioTransporte medioTransporte = new MedioTransporte();
        modelo.addAttribute("empresas", empresas);
        modelo.addAttribute("medios_transporte", medioTransporte);
        return "medio_transporte/create";
    }

    @PostMapping("/medios_transporte")
    public String store(@ModelAttribute("medios_transporte") MedioTransporte medioTransporte){
        servicio.guardarMedioTransporte(medioTransporte);
        return "redirect:/medios_transporte";
    }

    @GetMapping("/medios_transporte/editar/{id}")
    public String edit(@PathVariable Long id, Model modelo){
        List<EmpresaTransporte> empresas=empresaServicio.listarEmpresasTransporte();
        modelo.addAttribute("empresas", empresas);
        modelo.addAttribute("medio_transporte", servicio.obtenerMedioTransporteporId(id));
        return "medio_transporte/edit";
    }

    @PostMapping("/medios_transporte/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("medio_transporte") MedioTransporte medioTransporte,
    Model modelo){
        MedioTransporte medioExistente = servicio.obtenerMedioTransporteporId(id);
        medioExistente.setIdMedio(id);
        medioExistente.setMedio(medioTransporte.getMedio());
        medioExistente.setEmpresa_transporte(medioTransporte.getEmpresa_transporte());
        servicio.actualizarMedioTransporte(medioTransporte);
        return "redirect:/medios_transporte";
    }

    @GetMapping("/Medio-Transporte/{id}")
    public String destroy(@PathVariable Long id){
        servicio.eliminarMedioTransporte(id);
        return "redirect:/medios_transporte";
    }


    
}

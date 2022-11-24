package fia.ues.sistema_libre_movilidad.Controlador;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ActionMap;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fia.ues.sistema_libre_movilidad.SistemaLibreMovilidadApplication;
import fia.ues.sistema_libre_movilidad.Entidad.Frontera;
import fia.ues.sistema_libre_movilidad.Entidad.Identificacion;
import fia.ues.sistema_libre_movilidad.Entidad.Pais;
import fia.ues.sistema_libre_movilidad.Entidad.SolicitudViaje;
import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
import fia.ues.sistema_libre_movilidad.Servicio.FronteraServicio;
import fia.ues.sistema_libre_movilidad.Servicio.IdentificacionServicio;
import fia.ues.sistema_libre_movilidad.Servicio.SolicitudViajeServicio;
import fia.ues.sistema_libre_movilidad.Servicio.UsuarioServicio;
import fia.ues.sistema_libre_movilidad.commands.SolicitudForm;
import fia.ues.sistema_libre_movilidad.converters.SolicitudToSolicitudForm;

@Controller
public class SolicitudViajeControlador {
    
    @Autowired
    private SolicitudViajeServicio servicio;

    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @Autowired
    private FronteraServicio fronteraServicio;

    @Autowired
    private IdentificacionServicio identificacionServicio;

    private SolicitudToSolicitudForm solicitudToSolicitudForm;

    @Autowired
    public void setProductToProductForm(SolicitudToSolicitudForm solicitudToSolicitudForm) {
        this.solicitudToSolicitudForm = solicitudToSolicitudForm;
    }

    @Autowired
    public void setSolicitudService(SolicitudViajeServicio solicitudViajeServicio) {
        this.servicio = solicitudViajeServicio;
    }

    @GetMapping({"/solicitudes_viaje"})
    public String listarSolicitudes(Model modelo){
        List<SolicitudViaje> solicitudes=servicio.listarSolicitudes();
        List<SolicitudViaje> soliTemp=new ArrayList<>();
        for (SolicitudViaje sol : solicitudes) {
            if(sol.isMessageReceived()==true){
                soliTemp.add(sol);
            }
        }
        modelo.addAttribute("solicitudes", soliTemp);
        return "solicitud_viaje/index";
    }

    @GetMapping({"/solicitudesUsuario"})
    public String listarSolicitudesUsuario(Model modelo){
        modelo.addAttribute("solicitudes", servicio.listarSolicitudes());
        return "solicitud_viaje/indexUsuario";
    }

    @GetMapping("/solicitudes_viaje/nuevo")
    public String create(Model modelo){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario=usuarioServicio.obtenerUsuarioPorEmail(auth.getName());
        modelo.addAttribute("usuario", usuario);
        List<Frontera> fronteras = fronteraServicio.listarFronteras();
        modelo.addAttribute("fronteras", fronteras);
        SolicitudViaje solicitudViaje = new SolicitudViaje();
        modelo.addAttribute("solicitud",solicitudViaje);
        return "solicitud_viaje/create";
        
    }

    @PostMapping("/solicitudes_viaje")
    public String store(@Valid @ModelAttribute("solicitud") SolicitudViaje solicitudViaje, BindingResult result, Model model){

        if (result.hasErrors()){
            model.addAttribute("solicitud", solicitudViaje);
            return "solicitud_viaje/create";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario=usuarioServicio.obtenerUsuarioPorEmail(auth.getName());
        servicio.guardarSolicitudViaje(solicitudViaje);
        if(usuario.getRol()=="Administrador"){
            return "redirect:/solicitudes_viaje";
        }else{
            return "redirect:/solicitudesUsuario";
        }
    }
    
    

    @GetMapping("/solicitudes_viaje/editar/{id}")
    public String edit(@PathVariable Long id, Model modelo){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario=usuarioServicio.obtenerUsuarioPorEmail(auth.getName());
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("solicitud", servicio.obtenerSolicitudPorId(id));
        List<Frontera> fronteras = fronteraServicio.listarFronteras();
        modelo.addAttribute("fronteras", fronteras);
        return "solicitud_viaje/edit";
    }

    @PostMapping("/solicitudesUpdate/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("solicitud") SolicitudViaje solicitudViaje,
    Model modelo){

        SolicitudViaje solicitudExistente = servicio.obtenerSolicitudPorId(id);
        solicitudExistente.setIdSolicitudViaje(id);
        solicitudExistente.setEstado(solicitudViaje.getEstado());
        solicitudExistente.setFechaSolicitud(solicitudViaje.getFechaSolicitud());
        solicitudExistente.setMotivo(solicitudViaje.getMotivo());
        solicitudExistente.setPaisDestino(solicitudViaje.getPaisDestino());
        solicitudExistente.setPaisOrigen(solicitudViaje.getPaisOrigen());
        solicitudExistente.setUsuario(solicitudViaje.getUsuario());
        solicitudExistente.setFrontera(solicitudViaje.getFrontera());
        servicio.actualizarSolicitudViaje(solicitudExistente);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario=usuarioServicio.obtenerUsuarioPorEmail(auth.getName());
        if(usuario.getRol()=="Administrador"){
            return "redirect:/solicitudes_viaje";
        }else{
            return "redirect:/solicitudesUsuario";
        }
    }

    @GetMapping("/solicitudes/{id}")
    public String destroy(@PathVariable Long id){
        servicio.eliminarSolicitudViaje(id);;
        return "redirect:/solicitudes_viaje";
    }

    //metodos para rabbitMQ
    @RequestMapping("/solicitud/indexSolicitud/{id}")
    public String indexProduct(@PathVariable String id){
        servicio.sendSolicitudMessage(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario=usuarioServicio.obtenerUsuarioPorEmail(auth.getName());
        if(usuario.getRol()=="Administrador"){
            return "redirect:/solicitudes_viaje";
        }else{
            return "redirect:/home";
        }
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/solicitud/list";
    }

    @RequestMapping("solicitud/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        
        SolicitudViaje solicitudViaje= servicio.obtenerSolicitudPorId(Long.valueOf(id));
        SolicitudForm solicitudForm = solicitudToSolicitudForm.convert(solicitudViaje);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario=usuarioServicio.obtenerUsuarioPorEmail(auth.getName());
        model.addAttribute("usuario", usuario);
        List<Frontera> fronteras = fronteraServicio.listarFronteras();
        model.addAttribute("fronteras", fronteras);
        model.addAttribute("solicitudForm", solicitudForm);
        return "solicitud_viaje/edit";
    }

    @RequestMapping("/solicitud/new")
    public String newSolicitud(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario=usuarioServicio.obtenerUsuarioPorEmail(auth.getName());
        model.addAttribute("usuario", usuario);
        List<Frontera> fronteras = fronteraServicio.listarFronteras();
        model.addAttribute("fronteras", fronteras);
        model.addAttribute("solicitudForm", new SolicitudForm());
        return "solicitud/solicitudform";
    }

    @RequestMapping(value = "/solicitudSave", method = RequestMethod.POST)
    public String saveOrUpdateSolicitud(@Valid SolicitudForm solicitudForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "solicitud/solicitudform";
        }

        SolicitudViaje savedSolicitud = servicio.saveOrUpdateSolicitudForm(solicitudForm);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario=usuarioServicio.obtenerUsuarioPorEmail(auth.getName());
        if(usuario.getRol()=="Administrador"){
            return "redirect:/solicitudes_viaje";
        }else{
            return "redirect:/solicitudesUsuario";
        }
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id){
        servicio.eliminarSolicitudViaje(Long.valueOf(id));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario=usuarioServicio.obtenerUsuarioPorEmail(auth.getName());
        if(usuario.getRol()=="Administrador"){
            return "redirect:/solicitudes_viaje";
        }else{
            return "redirect:/solicitudesUsuario";
        }
    }

    @RequestMapping("/solicitud/show/{id}")
    public String getSolicitud(@PathVariable String id, Model model){
        model.addAttribute("solicitud", servicio.obtenerSolicitudPorId(Long.valueOf(id)));
        Usuario usuario= usuarioServicio.obtenerUsuarioPorId(Long.parseLong(id));
        List<Identificacion> identificaciones= identificacionServicio.listarIdentificacion();
        List<Identificacion> ideUsuario=new ArrayList<>();
        for (Identificacion identificacion : identificaciones) {
            if(usuario.getId()==Long.parseLong(id)){
                ideUsuario.add(identificacion);
            }
        }
        model.addAttribute("identificaciones", ideUsuario);
        return "solicitud_viaje/show";
    }

    @PostMapping("/solicitud/aprobar/{id}")
    public String aprobar(@PathVariable Long id, @ModelAttribute("solicitud") SolicitudViaje solicitudViaje,
    Model modelo){

        SolicitudViaje solicitudExistente = servicio.obtenerSolicitudPorId(id);
        solicitudExistente.setEstado("Aprobado");
        servicio.actualizarSolicitudViaje(solicitudExistente);
        return "redirect:/solicitudes_viaje";

    }
    @PostMapping("/solicitud/rechazar/{id}")
    public String rechazar(@PathVariable Long id, @ModelAttribute("solicitud") SolicitudViaje solicitudViaje,
    Model modelo){

        SolicitudViaje solicitudExistente = servicio.obtenerSolicitudPorId(id);
        solicitudExistente.setEstado("Rechazado");
        servicio.actualizarSolicitudViaje(solicitudExistente);
        return "redirect:/solicitudes_viaje";

    }
}

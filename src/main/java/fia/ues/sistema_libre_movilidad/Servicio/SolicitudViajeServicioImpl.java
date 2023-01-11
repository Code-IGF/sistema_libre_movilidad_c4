package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fia.ues.sistema_libre_movilidad.SistemaLibreMovilidadApplication;
import fia.ues.sistema_libre_movilidad.Entidad.SolicitudViaje;
import fia.ues.sistema_libre_movilidad.Repositorio.SolicitudViajeRepositorio;
import fia.ues.sistema_libre_movilidad.commands.SolicitudForm;
import fia.ues.sistema_libre_movilidad.converters.SolicitudFormToSolicitud;

@Service
public class SolicitudViajeServicioImpl implements SolicitudViajeServicio{
    @Autowired
    private SolicitudViajeRepositorio repositorio;
    
    private static final Logger log = LoggerFactory.getLogger(SolicitudViajeServicioImpl.class);

    private SolicitudFormToSolicitud solicitudFormToSolicitud;
    private RabbitTemplate rabbitTemplate;
    
    @Autowired
    public SolicitudViajeServicioImpl(SolicitudViajeRepositorio solicitudViajeRepositorio, SolicitudFormToSolicitud solicitudFormToSolicitud,
                              RabbitTemplate rabbitTemplate) {
        this.repositorio = solicitudViajeRepositorio;
        this.solicitudFormToSolicitud = solicitudFormToSolicitud;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public List<SolicitudViaje> listarSolicitudes() {
        return repositorio.findAll();
    }

    @Override
    public SolicitudViaje guardarSolicitudViaje(SolicitudViaje solicitudViaje) {
        return repositorio.save(solicitudViaje);
    }

    @Override
    public SolicitudViaje obtenerSolicitudPorId(Long Id) {
        return repositorio.findById(Id).get();
    }

    @Override
    public SolicitudViaje actualizarSolicitudViaje(SolicitudViaje solicitudViaje) {
        
        return repositorio.save(solicitudViaje);
    }

    @Override
    public void eliminarSolicitudViaje(Long id) {
        repositorio.deleteById(id);
    }
//Metodos del Rabbit MQ
    @Override
    public SolicitudViaje saveOrUpdate(SolicitudViaje solicitudViaje) {
        repositorio.save(solicitudViaje);
        return solicitudViaje;
    }
    @Override
    public SolicitudViaje saveOrUpdateSolicitudForm(SolicitudForm solicitudForm) {
        SolicitudViaje solicitudViaje2= saveOrUpdate(solicitudFormToSolicitud.convert(solicitudForm));

        System.out.println("Saved Solicitud Id: " + solicitudViaje2.getIdSolicitudViaje());
        return solicitudViaje2;
    }

    @Override
    public void sendSolicitudMessage(String id) {
        Map<String, String> actionMap = new HashMap<>();
        actionMap.put("id", id);
        log.info("Sending");
        rabbitTemplate.convertAndSend(SistemaLibreMovilidadApplication.SFG_MESSAGE_QUEUE, actionMap);
    }
    
}

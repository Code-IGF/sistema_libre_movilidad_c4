package fia.ues.sistema_libre_movilidad.listener;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import fia.ues.sistema_libre_movilidad.Entidad.SolicitudViaje;
import fia.ues.sistema_libre_movilidad.Repositorio.SolicitudViajeRepositorio;
import fia.ues.sistema_libre_movilidad.Servicio.SolicitudViajeServicio;

@Component
public class SolicitudMessageListener {
    
    private SolicitudViajeServicio solicitudViajeServicio;
    private SolicitudViajeRepositorio solicitudViajeRepositorio;

    private static final Logger log = LogManager.getLogger(SolicitudMessageListener.class);

    public SolicitudMessageListener(SolicitudViajeRepositorio solicitudViajeRepositorio)
    {
        this.solicitudViajeRepositorio=solicitudViajeRepositorio;
    }

    /**
     * This method is invoked whenever any new message is put in the queue.
     * See {@link org.springframework.SpringBootRabbitMQApplication} for more details
     * @param message
     */
    public void receiveMessage(Map<String,String> message){
        log.info("Received <"+message+">");
        Long id = Long.valueOf(message.get("id"));
        SolicitudViaje solicitudViaje = solicitudViajeRepositorio.findById(id).orElse(null);
        solicitudViaje.setMessageReceived(true);
        solicitudViaje.setMessageCount(solicitudViaje.getMessageCount()+1);

        solicitudViajeRepositorio.save(solicitudViaje);
        log.info("Message processed...");
    }

}

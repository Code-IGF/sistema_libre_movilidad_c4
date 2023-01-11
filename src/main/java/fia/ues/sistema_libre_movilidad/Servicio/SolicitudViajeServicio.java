package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import fia.ues.sistema_libre_movilidad.Entidad.SolicitudViaje;
import fia.ues.sistema_libre_movilidad.commands.SolicitudForm;

public interface SolicitudViajeServicio {
    public List<SolicitudViaje> listarSolicitudes();

    public SolicitudViaje guardarSolicitudViaje(SolicitudViaje solicitudViaje);

    public SolicitudViaje obtenerSolicitudPorId(Long Id);

    public SolicitudViaje actualizarSolicitudViaje(SolicitudViaje solicitudViaje);

    public void eliminarSolicitudViaje(Long id);

    SolicitudViaje saveOrUpdateSolicitudForm(SolicitudForm solicitudForm);

    void sendSolicitudMessage(String id);

    public SolicitudViaje saveOrUpdate(SolicitudViaje solicitudViaje);
}

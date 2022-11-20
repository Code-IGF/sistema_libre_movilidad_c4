package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import fia.ues.sistema_libre_movilidad.Entidad.SolicitudViaje;

public interface SolicitudViajeServicio {
    public List<SolicitudViaje> listarSolicitudes();

    public SolicitudViaje guardarSolicitudViaje(SolicitudViaje solicitudViaje);

    public SolicitudViaje obtenerSolicitudPorId(Long Id);

    public SolicitudViaje actualizarSolicitudViaje(SolicitudViaje solicitudViaje);

    public void eliminarSolicitudViaje(Long id);
}

package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import fia.ues.sistema_libre_movilidad.Entidad.Identificacion;

public interface IdentificacionServicio {
    public List<Identificacion> listarIdentificacion();

    public List<Identificacion> listarIdentificacionByUsuarioId(Long usuarioId);

    public Identificacion guardarIdentificacion(Identificacion identificacion);

    public Identificacion obtenerIdentificacionporId(Long id_identificacion);

    public Identificacion actualizarIdentificacion(Identificacion identificacion);

    public void eliminarIdentificacion(Long id_identificacion);
}

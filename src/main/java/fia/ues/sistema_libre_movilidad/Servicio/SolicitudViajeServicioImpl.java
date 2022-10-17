package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fia.ues.sistema_libre_movilidad.Entidad.SolicitudViaje;
import fia.ues.sistema_libre_movilidad.Repositorio.SolicitudViajeRepositorio;

@Service
public class SolicitudViajeServicioImpl implements SolicitudViajeServicio{
    @Autowired
    private SolicitudViajeRepositorio repositorio;

    @Override
    public List<SolicitudViaje> listarSolicitudes() {
        return repositorio.findAll();
    }
    
}

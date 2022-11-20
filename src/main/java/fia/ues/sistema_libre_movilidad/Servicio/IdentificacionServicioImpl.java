package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fia.ues.sistema_libre_movilidad.Entidad.Identificacion;
import fia.ues.sistema_libre_movilidad.Repositorio.IdentificacionRepositorio;

@Service
public class IdentificacionServicioImpl implements IdentificacionServicio{

    @Autowired
    private IdentificacionRepositorio repositorio;

    

    @Override
    public Identificacion actualizarIdentificacion(Identificacion identificacion) {
        return repositorio.save(identificacion);
    }

    @Override
    public void eliminarIdentificacion(Long id_identificacion) {
        repositorio.deleteById(id_identificacion);
        
    }

    @Override
    public Identificacion guardarIdentificacion(Identificacion identificacion) {
        return repositorio.save(identificacion);
    }

    @Override
    public List<Identificacion> listarIdentificacion() {
        return repositorio.findAll();
    }

    @Override
    public Identificacion obtenerIdentificacionporId(Long id_identificacion) {
        return repositorio.findById(id_identificacion).get();
    }

    @Override
    public List<Identificacion> listarIdentificacionByUsuarioId(Long usuarioId) {
        return repositorio.findAllByUsuarioId_Id(usuarioId);
    }

   

    

    
}

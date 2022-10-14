package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fia.ues.sistema_libre_movilidad.Entidad.Viajero;
import fia.ues.sistema_libre_movilidad.Repositorio.ViajeroRepositorio;

@Service
public class ViajeroServicioImpl implements ViajeroServicio{

    @Autowired
    private ViajeroRepositorio repositorio;

    @Override
    public List<Viajero> listarViajeros() {
        return repositorio.findAll();
    }

    @Override
    public Viajero guardarViajero(Viajero viajero) {
        return repositorio.save(viajero);
    }

    @Override
    public Viajero obtenerViajeroPorId(Long Id) {
        return repositorio.findById(Id).get();
    }

    @Override
    public Viajero actualizarViajero(Viajero viajero) {
        return repositorio.save(viajero);
    }

    @Override
    public void elminarViajero(Long id) {
        repositorio.deleteById(id);
    }
    
}
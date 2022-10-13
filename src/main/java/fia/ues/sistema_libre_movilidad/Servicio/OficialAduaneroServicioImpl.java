package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fia.ues.sistema_libre_movilidad.Entidad.OficialAduanero;
import fia.ues.sistema_libre_movilidad.Repositorio.OficialAduaneroRepositorio;

@Service
public class OficialAduaneroServicioImpl implements OficialAduaneroServicio{

    @Autowired
    private OficialAduaneroRepositorio repositorio;


    @Override
    public List<OficialAduanero> listarOficialAduanero() {
        
        return repositorio.findAll();
    }

    @Override
    public OficialAduanero actualizarOficialAduanero(OficialAduanero oficialAduanero) {
        return repositorio.save(oficialAduanero);
    }

    @Override
    public void eliminarOficialAduanero(Long id) {
        repositorio.deleteById(id);
        
    }

    @Override
    public OficialAduanero guardarOficialAduanero(OficialAduanero oficialAduanero) {
        return repositorio.save(oficialAduanero);
    }

    @Override
    public OficialAduanero obtenerOficialAduaneroporId(Long Id) {
        
        return repositorio.findById(Id).get();
    }
}

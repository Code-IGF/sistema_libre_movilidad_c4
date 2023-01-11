package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fia.ues.sistema_libre_movilidad.Entidad.Region;
import fia.ues.sistema_libre_movilidad.Repositorio.RegionRepositorio;

@Service
public class RegionServicioImpl  implements RegionServicio{

    @Autowired
    private RegionRepositorio repositorio;

    @Override
    public List<Region> listarRegiones() {
        return repositorio.findAll();
    }

    @Override
    public Region guardarRegion(Region region) {
        return repositorio.save(region);
    }

    @Override
    public Region obtenerRegionPorId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Region actualizarRegion(Region region) {
        return repositorio.save(region);
    }

    @Override
    public void eliminarRegion(Long id){
        repositorio.deleteById(id);
    }
    
    
}


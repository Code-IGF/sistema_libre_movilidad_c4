package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fia.ues.sistema_libre_movilidad.Entidad.Frontera;
import fia.ues.sistema_libre_movilidad.Repositorio.FronteraRepositorio;

@Service
public class FronteraServicioImpl implements FronteraServicio{
    
    @Autowired
    private FronteraRepositorio repositorio;

    @Override
    public List<Frontera> listarFronteras() {
        return repositorio.findAll();
    }

    @Override
    public Frontera guardarFrontera(Frontera frontera){
        return repositorio.save(frontera);    
    }
         
    @Override
    public Frontera obtenerFronteraPorId(Long Id) {
        return repositorio.findById(Id).get();
    }

    @Override
    public Frontera actualizarFrontera(Frontera frontera) {
        return repositorio.save(frontera);
    }

    @Override
    public void eliminarFrontera(Long id) {
        repositorio.deleteById(id);
    }
}

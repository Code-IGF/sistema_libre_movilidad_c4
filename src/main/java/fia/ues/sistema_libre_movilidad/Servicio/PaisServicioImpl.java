package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fia.ues.sistema_libre_movilidad.Entidad.Pais;
import fia.ues.sistema_libre_movilidad.Repositorio.PaisRepositorio;

@Service
public class PaisServicioImpl  implements PaisServicio{

    @Autowired
    private PaisRepositorio repositorio;

    @Override
    public List<Pais> listarPaises() {
        return repositorio.findAll();
    }

    @Override
    public Pais guardarPais(Pais pais) {
        return repositorio.save(pais);
    }

    @Override
    public Pais obtenerPaisPorId(Long Id) {
        return repositorio.findById(Id).get();
    }

    @Override
    public Pais actualizarPais(Pais pais) {
        return repositorio.save(pais);
    }

    @Override
    public void eliminarPais(Long id){
        repositorio.deleteById(id);
    }
    
    
}

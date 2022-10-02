package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fia.ues.sistema_libre_movilidad.Entidad.Estudiante;
import fia.ues.sistema_libre_movilidad.Repositorio.EstudianteRepositorio;

@Service
public class EstudianteServicioImpl implements EstudianteServicio{

    @Autowired
    private EstudianteRepositorio repositorio;

    @Override
    public List<Estudiante> listarEstudiantes() {
        return repositorio.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return repositorio.save(estudiante);
    }

    
    @Override
    public Estudiante obtenerEstudianteporId(Long id) {
        
        return repositorio.findById(id).get();
    }

    @Override
    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        
        return repositorio.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        repositorio.deleteById(id);
        
    }

    
}

package fia.ues.sistema_libre_movilidad.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import fia.ues.sistema_libre_movilidad.Entidad.Estudiante;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long>{
    
}

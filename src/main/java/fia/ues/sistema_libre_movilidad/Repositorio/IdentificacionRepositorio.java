package fia.ues.sistema_libre_movilidad.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fia.ues.sistema_libre_movilidad.Entidad.Identificacion;

public interface IdentificacionRepositorio extends JpaRepository<Identificacion, Long>{
    List<Identificacion> findAllByUsuarioId_Id(Long usuarioId);
}

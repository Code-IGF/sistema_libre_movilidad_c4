package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import fia.ues.sistema_libre_movilidad.Entidad.Pais;

public interface PaisServicio {
    
    public List<Pais> listarPaises();
    
    public Pais guardarPais(Pais pais);

    public Pais obtenerPaisPorId(Long Id);

    public Pais actualizarPais(Pais pais);

    public void eliminarPais(Long id);
}

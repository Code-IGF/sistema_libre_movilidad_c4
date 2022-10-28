package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import fia.ues.sistema_libre_movilidad.Entidad.Viajero;

public interface ViajeroServicio {
    
    public List<Viajero> listarViajeros();
    
    public Viajero guardarViajero(Viajero viajero);

    public Viajero obtenerViajeroPorId(Long Id);

    public Viajero actualizarViajero(Viajero viajero);

    public void elminarViajero(Long id);
}


package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import fia.ues.sistema_libre_movilidad.Entidad.Region;

public interface RegionServicio {
    
    public List<Region> listarRegiones();
    
    public Region guardarRegion(Region Region);

    public Region obtenerRegionPorId(Long Id);

    public Region actualizarRegion(Region Region);

    public void eliminarRegion(Long id);
}
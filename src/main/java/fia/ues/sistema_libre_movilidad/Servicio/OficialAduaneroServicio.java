package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import fia.ues.sistema_libre_movilidad.Entidad.OficialAduanero;

public interface OficialAduaneroServicio{

    public List<OficialAduanero> listarOficialAduanero();
    
    public OficialAduanero guardarOficialAduanero(OficialAduanero oficialAduanero);

    public OficialAduanero obtenerOficialAduaneroporId(Long Id);

    public OficialAduanero actualizarOficialAduanero(OficialAduanero oficialAduanero);

    public void eliminarOficialAduanero(Long Id); 
}
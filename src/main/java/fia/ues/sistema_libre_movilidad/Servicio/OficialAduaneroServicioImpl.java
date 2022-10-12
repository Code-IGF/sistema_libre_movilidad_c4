package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fia.ues.sistema_libre_movilidad.Entidad.OficialAduanero;
import fia.ues.sistema_libre_movilidad.Repositorio.OficialAduaneroRepositorio;

@Service
public class OficialAduaneroServicioImpl implements OficialAduaneroServicio{
    @Autowired
    private OficialAduaneroRepositorio repositorio;


    @Override
    public List<OficialAduanero> listarOficialAduanero() {
        
        return repositorio.findAll();
    }

    
    
}

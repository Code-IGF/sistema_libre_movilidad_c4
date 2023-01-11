package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fia.ues.sistema_libre_movilidad.Entidad.MedioTransporte;
import fia.ues.sistema_libre_movilidad.Repositorio.MedioTransporteRepositorio;
@Service

public class MedioTransporteServicioimpl implements MedioTransporteServicio {
    @Autowired
    private MedioTransporteRepositorio repositorio;

   
    @Override
    public List<MedioTransporte> ListarMedioTransporte() {
        
        return repositorio.findAll();
    }


    @Override
    public MedioTransporte actualizarMedioTransporte(MedioTransporte medioTransporte) {
        return repositorio.save(medioTransporte);
    }


    @Override
    public void eliminarMedioTransporte(Long Id) {
        repositorio.deleteById(Id);
        
    }


    @Override
    public MedioTransporte guardarMedioTransporte(MedioTransporte medioTransporte) {
        return repositorio.save(medioTransporte);
    }


    @Override
    public MedioTransporte obtenerMedioTransporteporId(Long Id) {
        return repositorio.findById(Id).get();

    }
  
}

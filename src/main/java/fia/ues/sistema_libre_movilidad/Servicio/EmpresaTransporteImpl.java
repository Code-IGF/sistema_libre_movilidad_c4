package fia.ues.sistema_libre_movilidad.Servicio;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fia.ues.sistema_libre_movilidad.Entidad.EmpresaTransporte;
import fia.ues.sistema_libre_movilidad.Servicio.EmpresaTransporteImpl;
import fia.ues.sistema_libre_movilidad.Repositorio.EmpresaTransporteRepositorio;
@Service
public class EmpresaTransporteImpl implements EmpresaTransporteServicio {

    @Autowired
    private EmpresaTransporteRepositorio repositorio;
    @Override
    public List<EmpresaTransporte> listarEmpresasTransporte() {
        return repositorio.findAll();
    }
    @Override
    public EmpresaTransporte guardarEmpresaTransporte(EmpresaTransporte empresaTransporte){
        return repositorio.save(empresaTransporte);
    }
    @Override
    public EmpresaTransporte actualizarEmpresaTransporte(EmpresaTransporte empresaTransporte){
        return repositorio.save(empresaTransporte);
    }
    @Override
    public void eliminarEmpresaTransporte(Long id){
        repositorio.deleteById(id);
    }
    @Override
    public EmpresaTransporte obtenerEmpresaTransporteporId(Long id){
        return repositorio.findById(id).get();
    }

   
}

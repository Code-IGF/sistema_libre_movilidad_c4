package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import fia.ues.sistema_libre_movilidad.Entidad.EmpresaTransporte;


public interface EmpresaTransporteServicio {
    public List<EmpresaTransporte> listarEmpresasTransporte();
    public EmpresaTransporte guardarEmpresaTransporte(EmpresaTransporte empresaTransporte);

    public EmpresaTransporte actualizarEmpresaTransporte(EmpresaTransporte empresaTransporte);

    public void eliminarEmpresaTransporte(Long id);
    public EmpresaTransporte obtenerEmpresaTransporteporId(Long id);
}

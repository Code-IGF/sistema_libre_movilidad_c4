package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import fia.ues.sistema_libre_movilidad.Entidad.MedioTransporte;

public interface MedioTransporteServicio {
    public List<MedioTransporte> ListarMedioTransporte();

    public MedioTransporte guardarMedioTransporte(MedioTransporte medioTransporte);

    public MedioTransporte obtenerMedioTransporteporId(Long Id);

    public MedioTransporte actualizarMedioTransporte(MedioTransporte medioTransporte);

    public void eliminarMedioTransporte(Long Id); 
}

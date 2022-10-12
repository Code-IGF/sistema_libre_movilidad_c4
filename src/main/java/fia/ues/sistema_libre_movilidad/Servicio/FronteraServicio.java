package fia.ues.sistema_libre_movilidad.Servicio;

import java.util.List;

import fia.ues.sistema_libre_movilidad.Entidad.Frontera;

public interface FronteraServicio {
    
    public List<Frontera> listarFronteras();

    public Frontera guardarFrontera(Frontera frontera);

    public Frontera obtenerFronteraPorId(Long Id);

    public Frontera actualizarFrontera(Frontera frontera);

    public void eliminarFrontera(Long Id); 
}

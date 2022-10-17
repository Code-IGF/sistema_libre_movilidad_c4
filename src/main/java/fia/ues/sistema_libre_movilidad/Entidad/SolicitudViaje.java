package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(name = "solicitud_viaje")
public class SolicitudViaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitudViaje;

    @Column(name = "fecha_solicitud", nullable = false, length = 50)
    private String fechaSolicitud;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "pais_origen", nullable = false, length = 50)
    private String paisOrigen;

    @Column(name = "pais_destino", nullable = false, length = 50)
    private String paisDestino;

    @Column(name = "motivo", nullable = false, length = 50)
    private String motivo;

    public SolicitudViaje(Long idSolicitudViaje, String fechaSolicitud, String estado, String paisOrigen,
            String paisDestino, String motivo) {
        this.idSolicitudViaje = idSolicitudViaje;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.paisOrigen = paisOrigen;
        this.paisDestino = paisDestino;
        this.motivo = motivo;
    }
    public SolicitudViaje(String fechaSolicitud, String estado, String paisOrigen,
            String paisDestino, String motivo) {
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.paisOrigen = paisOrigen;
        this.paisDestino = paisDestino;
        this.motivo = motivo;
    }

    public SolicitudViaje() {
    }

    public Long getIdSolicitudViaje() {
        return idSolicitudViaje;
    }

    public void setIdSolicitudViaje(Long idSolicitudViaje) {
        this.idSolicitudViaje = idSolicitudViaje;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}

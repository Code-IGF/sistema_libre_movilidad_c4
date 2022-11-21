package fia.ues.sistema_libre_movilidad.commands;

import fia.ues.sistema_libre_movilidad.Entidad.Frontera;
import fia.ues.sistema_libre_movilidad.Entidad.Usuario;

public class SolicitudForm {

    private Long idSolicitudViaje;

    private String fechaSolicitud;

    private String estado;

    private String paisOrigen;

    private String paisDestino;

    private String motivo;

    private Usuario usuario;

    private Frontera frontera;

    private boolean messageReceived;
    private Integer messageCount = 0;

    public SolicitudForm(Long idSolicitudViaje, String fechaSolicitud, String estado, String paisOrigen,
            String paisDestino, String motivo, Usuario usuario, Frontera frontera) {
        this.idSolicitudViaje = idSolicitudViaje;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.paisOrigen = paisOrigen;
        this.paisDestino = paisDestino;
        this.motivo = motivo;
        this.usuario=usuario;
        this.frontera=frontera;
    }
    public SolicitudForm(String fechaSolicitud, String estado, String paisOrigen,
            String paisDestino, String motivo, Usuario usuario, Frontera frontera) {
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.paisOrigen = paisOrigen;
        this.paisDestino = paisDestino;
        this.motivo = motivo;
        this.usuario=usuario;
        this.frontera=frontera;
    }

    public SolicitudForm() {
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
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Frontera getFrontera() {
        return frontera;
    }
    public void setFrontera(Frontera frontera) {
        this.frontera = frontera;
    }
    
    public boolean isMessageReceived() {
        return messageReceived;
    }
    public void setMessageReceived(boolean messageReceived) {
        this.messageReceived = messageReceived;
    }
    public Integer getMessageCount() {
        return messageCount;
    }
    public void setMessageCount(Integer messageCount) {
        this.messageCount = messageCount;
    }
}

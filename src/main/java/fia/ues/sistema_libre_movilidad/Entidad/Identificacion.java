package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "identificacion")
public class Identificacion {


    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_identificacion;

    @Column(name = "tipo", nullable = false, length = 30)
    private String tipo;

    @Column(name = "numero_unico", nullable = false, length = 50)
    private String numeroUnico;

    @Column(name = "pais_nacimiento", nullable = false, length = 30)
    private String paisNacimiento;

    @Column(name = "pais_residencia", nullable = false, length = 30)
    private String paisResidencia;

    @Column(name = "ocupacion", nullable = false, length = 30)
    private String ocupacion;

    @Column(name = "pais_emisor", nullable = false, length = 30)
    private String paisEmisor;

    @Column(name = "fecha_vencimiento", nullable = false, length = 30)
    private String fechaVencimiento;

    @OneToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    public Identificacion(Long id_identificacion, String tipo, String numeroUnico, String paisNacimiento,
            String paisResidencia, String ocupacion, String paisEmisor, String fechaVencimiento, Usuario usuario) {
        this.id_identificacion = id_identificacion;
        this.tipo = tipo;
        this.numeroUnico = numeroUnico;
        this.paisNacimiento = paisNacimiento;
        this.paisResidencia = paisResidencia;
        this.ocupacion = ocupacion;
        this.paisEmisor = paisEmisor;
        this.fechaVencimiento = fechaVencimiento;
    }
    public Identificacion(String tipo, String numeroUnico, String paisNacimiento,
    String paisResidencia, String ocupacion, String paisEmisor, String fechaVencimiento, Usuario usuario) {;
        this.tipo = tipo;
        this.numeroUnico = numeroUnico;
        this.paisNacimiento = paisNacimiento;
        this.paisResidencia = paisResidencia;
        this.ocupacion = ocupacion;
        this.paisEmisor = paisEmisor;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Identificacion(){

    }
    
    public Long getId_identificacion() {
        return id_identificacion;
    }
    public void setId_identificacion(Long id_identificacion) {
        this.id_identificacion = id_identificacion;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getNumeroUnico() {
        return numeroUnico;
    }
    public void setNumeroUnico(String numeroUnico) {
        this.numeroUnico = numeroUnico;
    }
    public String getPaisNacimiento() {
        return paisNacimiento;
    }
    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }
    public String getPaisResidencia() {
        return paisResidencia;
    }
    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }
    public String getOcupacion() {
        return ocupacion;
    }
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    public String getPaisEmisor() {
        return paisEmisor;
    }
    public void setPaisEmisor(String paisEmisor) {
        this.paisEmisor = paisEmisor;
    }
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}

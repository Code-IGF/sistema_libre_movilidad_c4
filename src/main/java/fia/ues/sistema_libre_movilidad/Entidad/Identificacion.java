package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "identificacion")
public class Identificacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_identificacion;

    @NotEmpty
    @Column(name = "tipo", nullable = false, length = 30)
    private String tipo;

    @NotEmpty
    @Column(name = "numero_unico", nullable = false, length = 50)
    private String numeroUnico;

    @OneToOne
    @JoinColumn(name = "pais_nacimiento", nullable = false)
    private Pais paisNacimiento;

    @OneToOne
    @JoinColumn(name = "pais_residencia", nullable = false)
    private Pais paisResidencia;

    @NotEmpty
    @Column(name = "ocupacion", nullable = false, length = 30)
    private String ocupacion;

    @NotEmpty
    @Column(name = "fecha_vencimiento", nullable = false, length = 30)
    private String fechaVencimiento;

    @OneToOne
    @JoinColumn(name="pais_emisor", nullable = false)
    private Pais paisEmisor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario")
    private Usuario usuario;



    public Identificacion(Long id_identificacion, String tipo, String numeroUnico, Pais paisNacimiento,
            Pais paisResidencia, String ocupacion, Pais paisEmisor, String fechaVencimiento,
            Usuario usuario) {
        this.id_identificacion = id_identificacion;
        this.tipo = tipo;
        this.numeroUnico = numeroUnico;
        this.paisNacimiento = paisNacimiento;
        this.paisResidencia = paisResidencia;
        this.ocupacion = ocupacion;
        this.paisEmisor = paisEmisor;
        this.fechaVencimiento = fechaVencimiento;
        this.usuario=usuario;
    }
    public Identificacion(String tipo, String numeroUnico, Pais paisNacimiento,
    Pais paisResidencia, String ocupacion, Pais paisEmisor, String fechaVencimiento,
    Usuario usuario) {;
        this.tipo = tipo;
        this.numeroUnico = numeroUnico;
        this.paisNacimiento = paisNacimiento;
        this.paisResidencia = paisResidencia;
        this.ocupacion = ocupacion;
        this.paisEmisor = paisEmisor;
        this.fechaVencimiento = fechaVencimiento;
        this.usuario=usuario;
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
    public Pais getPaisNacimiento() {
        return paisNacimiento;
    }
    public void setPaisNacimiento(Pais paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }
    public Pais getPaisResidencia() {
        return paisResidencia;
    }
    public void setPaisResidencia(Pais paisResidencia) {
        this.paisResidencia = paisResidencia;
    }
    public String getOcupacion() {
        return ocupacion;
    }
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    } 
    public Pais getPaisEmisor() {
        return paisEmisor;
    }
    public void setPaisEmisor(Pais paisEmisor) {
        this.paisEmisor = paisEmisor;
    }
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}

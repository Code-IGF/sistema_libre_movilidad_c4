package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
<<<<<<< HEAD
=======
import javax.persistence.OneToOne;
>>>>>>> 33371b3b902f29f900c2b7e10cf11c80010e477d
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

    @NotEmpty
    @Column(name = "pais_nacimiento", nullable = false, length = 30)
    private String paisNacimiento;

    @NotEmpty
    @Column(name = "pais_residencia", nullable = false, length = 30)
    private String paisResidencia;

    @NotEmpty
    @Column(name = "ocupacion", nullable = false, length = 30)
    private String ocupacion;

    @NotEmpty
    @Column(name = "fecha_vencimiento", nullable = false, length = 30)
    private String fechaVencimiento;

    @OneToOne
    @JoinColumn(name="pais_emisor", nullable = false)
    private Pais paisEmisor;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuarioId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario")
    private Usuario usuario;


    public Identificacion(Long id_identificacion, String tipo, String numeroUnico, String paisNacimiento,
            String paisResidencia, String ocupacion, String paisEmisor, String fechaVencimiento,
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
    public Identificacion(String tipo, String numeroUnico, String paisNacimiento,
<<<<<<< HEAD
    String paisResidencia, String ocupacion, String paisEmisor, String fechaVencimiento,
    Usuario usuario) {;
=======
    String paisResidencia, String ocupacion, Pais paisEmisor, String fechaVencimiento) {;
>>>>>>> 33371b3b902f29f900c2b7e10cf11c80010e477d
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
<<<<<<< HEAD
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
=======

    public Usuario getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

>>>>>>> 33371b3b902f29f900c2b7e10cf11c80010e477d
}

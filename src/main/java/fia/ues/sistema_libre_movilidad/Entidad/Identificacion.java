package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private String numero_unico;

    @Column(name = "pais_nacimiento", nullable = false, length = 30)
    private String pais_nacimiento;

    @Column(name = "pais_residencia", nullable = false, length = 30)
    private String pais_residencia;

    @Column(name = "ocupacion", nullable = false, length = 30)
    private String ocupacion;

    @Column(name = "pais_Emisor", nullable = false, length = 30)
    private String pais_Emisor;

    @Column(name = "fecha_vencimiento", nullable = false, length = 30)
    private String fecha_vencimiento;

    public Identificacion (Long id_identificacion, String tipo, String numero_unico, String pais_nacimiento, String pais_residencia,String ocupacion,String pais_Emisor, String fecha_vencimiento ) {
        this.id_identificacion = id_identificacion;
        this.tipo = tipo;
        this.numero_unico = numero_unico;
        this.pais_nacimiento = pais_nacimiento;
        this.pais_residencia = pais_residencia;
        this.ocupacion = ocupacion;
        this.pais_Emisor = pais_Emisor;
        this.fecha_vencimiento = fecha_vencimiento;
    }
    public Identificacion (String tipo, String numero_unico, String pais_nacimiento, String pais_residencia,String ocupacion,String pais_Emisor, String fecha_vencimiento) {
        this.tipo = tipo;
        this.numero_unico = numero_unico;
        this.pais_nacimiento = pais_nacimiento;
        this.pais_residencia = pais_residencia;
        this.ocupacion = ocupacion;
        this.pais_Emisor = pais_Emisor;
        this.fecha_vencimiento = fecha_vencimiento;
    }
    public Identificacion() {
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
    public String getNumero_unico() {
        return numero_unico;
    }
    public void setNumero_unico(String numero_unico) {
        this.numero_unico = numero_unico;
    }
    public String getPais_nacimiento() {
        return pais_nacimiento;
    }
    public void setPais_nacimiento(String pais_nacimiento) {
        this.pais_nacimiento = pais_nacimiento;
    }
    public String getPais_residencia() {
        return pais_residencia;
    }
    public void setPais_residencia(String pais_residencia) {
        this.pais_residencia = pais_residencia;
    }
    public String getOcupacion() {
        return ocupacion;
    }
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    public String getPais_Emisor() {
        return pais_Emisor;
    }
    public void setPais_Emisor(String pais_Emisor) {
        this.pais_Emisor = pais_Emisor;
    }
    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }
    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
    

}

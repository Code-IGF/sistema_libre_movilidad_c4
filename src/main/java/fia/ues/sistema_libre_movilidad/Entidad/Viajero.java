package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "viajero")
public class Viajero {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_viajero", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido_viajero", nullable = false, length = 50)
    private String apellido;

    @Column(name = "fecha_nacimiento", nullable = false, length = 10)
    private String fechaNacimiento;
    
    @Column(name = "sexo", nullable = false, length = 1)
    private String sexo;

    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;

    public Viajero() {
    }

    public Viajero(Long id, String nombre, String apellido, String fechaNacimiento, String sexo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}


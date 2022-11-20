package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "usuarios", uniqueConstraints={@UniqueConstraint(columnNames={"correo"})})
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "correo",nullable = false, length = 100)
    private String correo;

    @NotEmpty
    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    @NotEmpty
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @NotEmpty
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @NotEmpty
    @Column(name = "fecha_nacimiento", nullable = false, length = 10)
    private String fechaNacimiento;
    
    @NotEmpty
    @Column(name = "sexo", nullable = false, length = 1)
    private String sexo;

    @NotEmpty
    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;
    
    @Column(name = "rol", nullable = false, length = 14)
    private String rol;

    public Usuario() {        
    }

    public Usuario(Long id, String nombre, String apellido, String fechaNacimiento, String sexo, String telefono, String correo, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
    public Usuario(Long id, String nombre, String apellido, 
        String fechaNacimiento, String sexo, String telefono, 
        String correo, String contrasenia, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.rol=rol;
    }
    

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getContrasenia(){
        return contrasenia;
    }

    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
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

    public void setRol(String rol){
        this.rol = rol;
    }
    public String getRol(){
        return rol;
    }

}

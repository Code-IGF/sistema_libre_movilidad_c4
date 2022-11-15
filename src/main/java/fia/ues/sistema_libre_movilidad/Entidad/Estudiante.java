package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @NotEmpty
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @NotEmpty
    @Email
    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    public Estudiante(Long id, String nombre, String apellido, String email, Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario=usuario;
    }
    public Estudiante(String nombre, String apellido, String email, Usuario usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario=usuario;
    }
    public Estudiante() {

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido=apellido;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}

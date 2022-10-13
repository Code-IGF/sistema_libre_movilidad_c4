package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "correo", nullable = false, length = 50)
    private String correo;

    @Column(name = "contrasenia", nullable = false, length = 50)
    private String contrasenia;

    public Usuario(Long id, String correo, String contrasenia) {
        this.id = id;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
    public Usuario(String correo) {
        this.correo = correo;
    }
    public Usuario() {        
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
}

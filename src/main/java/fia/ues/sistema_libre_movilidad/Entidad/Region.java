package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "region")
public class Region {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@NotEmpty
@Column(name = "nombre", nullable = false, length = 50)
private String nombre;

@OneToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

public Region(long id, String nombre) {
    this.id = id;
    this.nombre = nombre;
}

public Region( String nombre, Usuario usuario) {
    this.usuario=usuario;
    this.nombre = nombre;
}

public Region(){

}

}


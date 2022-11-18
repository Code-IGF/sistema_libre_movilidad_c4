package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "pais")
public class Pais {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@NotEmpty
@Column(name = "nombre", nullable = false, length = 50)
private String nombre;

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

public Pais(long id, String nombre) {
    this.id = id;
    this.nombre = nombre;
}

public Pais( String nombre) {
    this.nombre = nombre;
}

public Pais(){

}

}


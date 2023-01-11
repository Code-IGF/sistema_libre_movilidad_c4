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

import org.hibernate.annotations.CollectionId;

@Entity
@Table(name = "regiones")
public class Region {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@NotEmpty
@Column(name = "nombre", nullable = false, length = 50)
private String nombre;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="id_pais")
private Pais pais;

    public Pais getPais() {
    return pais;
}

public void setPais(Pais pais) {
    this.pais = pais;
}

    public Region (Long id, String nombre, Pais pais){
        this.id=id;
        this.nombre=nombre;
        this.pais=pais;
    }

    public Region (String nombre, Usuario usuario, Pais pais){
        this.nombre=nombre;
        this.pais=pais;
    }

    public Region() {

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

}


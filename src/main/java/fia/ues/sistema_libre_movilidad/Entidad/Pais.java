package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name = "pais", nullable = false, length = 50)
private String pais;

public Pais(long id, String pais) {
    this.id = id;
    this.pais = pais;
}
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Pais(){

}
public String getPais(){
    return pais;
}

public void setPais(String pais){
    this.pais = pais;
} 
}


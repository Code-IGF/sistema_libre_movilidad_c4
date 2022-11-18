package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "region")
public class Region {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name = "region", nullable = false, length = 50)
private String region;

@ManyToOne
    @JoinColumn(name="id_pais")
    private Pais pais;

public Region(long id, String region, Pais pais) {
    this.id = id;
    this.region = region;
    this.pais = pais;
}
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Region(){

}
public String getRegion(){
    return region;
}

public void setRegion(String region){
    this.region = region;
} 

public Pais getPais(){
    return pais;
}

public void setPais(Pais pais){
    this.pais = pais;
} 
}



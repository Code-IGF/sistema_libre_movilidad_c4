package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regiones")
public class Region {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name = "Region", nullable = false, length = 50)
private String region;

public Region(long id, String region) {
    this.id = id;
    this.region = region;
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
}



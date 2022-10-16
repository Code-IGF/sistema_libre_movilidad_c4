package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "frontera")
public class Frontera {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_frontera", nullable = false, length = 50)
    private String nombreFrontera;

    public Frontera(Long id, String nombreFrontera) {
        this.id = id;
        this.nombreFrontera = nombreFrontera;
    }
    public Frontera(String nombreFrontera) {
        this.nombreFrontera = nombreFrontera;
    }
    public Frontera() {        
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getNombreFrontera(){
        return nombreFrontera;
    }

    public void setNombre(String nombreFrontera){
        this.nombreFrontera=nombreFrontera;
    }
}

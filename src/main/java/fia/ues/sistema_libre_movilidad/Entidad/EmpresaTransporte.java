package fia.ues.sistema_libre_movilidad.Entidad;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "empresa_transporte")
public class EmpresaTransporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    public EmpresaTransporte(Long id,String nombre,Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
    }
    public EmpresaTransporte(String nombre,Usuario usuario) {
        this.nombre = nombre;
    }
    public EmpresaTransporte(){
        
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
}

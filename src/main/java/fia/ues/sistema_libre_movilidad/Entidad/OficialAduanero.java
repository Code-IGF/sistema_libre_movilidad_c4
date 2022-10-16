package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="oficial_aduanero")
public class OficialAduanero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    @Column(name = "nombre_oficial_aduanero", nullable = false, length = 55)
    private String nombreOficialAduanero;
    
    //constructor con dos parametros
    public OficialAduanero(Long id, String nombreOficialAduanero) {
        this.id = id;
        this.nombreOficialAduanero = nombreOficialAduanero;
    }
    //constructor con un parametro
    public OficialAduanero(String nombreOficialAduanero) {
        this.nombreOficialAduanero = nombreOficialAduanero;
    }
    //constructor vacio
    public OficialAduanero() {
    }

    public String getNombreOficialAduanero() {
            return nombreOficialAduanero;
    }

    public void setNombreOficialAduanero(String nombreOficialAduanero) {
        this.nombreOficialAduanero = nombreOficialAduanero;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}

package fia.ues.sistema_libre_movilidad.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Medio-Transporte")
public class MedioTransporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "Id_Medio_Transporte",nullable = false,length = 10)
    private String idMedio;

    public String getIdMedio() {
        return idMedio;
    }

    public void setIdMedio(String idMedio) {
        this.idMedio = idMedio;
    }

    @Column(name = "medio",nullable = false,length = 10)
    private String medio;


    
    public MedioTransporte(Long id, String medio) {
        Id = id;
        this.medio = medio;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }


    
}

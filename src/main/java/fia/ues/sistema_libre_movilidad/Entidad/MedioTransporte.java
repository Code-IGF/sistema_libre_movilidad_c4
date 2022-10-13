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
    private Long idMedio;

    public Long getIdMedio() {
        return idMedio;
    }

    public void setIdMedio(Long idMedio) {
        this.idMedio = idMedio;
    }

    @Column(name = "medio",nullable = false,length = 10)
    private String medio;


    
    public MedioTransporte(Long idMedio, String medio) {
        this.idMedio = idMedio;
        this.medio = medio;
    }
    public MedioTransporte(String medio) {
        this.medio = medio;
    }

    public MedioTransporte() {
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }


    
}

package fia.ues.sistema_libre_movilidad.Entidad;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "medio_transporte")
public class MedioTransporte {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedio;

    @Column(name = "medio",nullable = false,length = 10)
    private String medio;

    
    @ManyToMany
	@JoinTable(name="medio_empresa"
		,joinColumns=@JoinColumn(name="id_medio")
		,inverseJoinColumns=@JoinColumn(name="id_empresa")
	)
	private List<EmpresaTransporte> empresa_transporte;


    public MedioTransporte(Long idMedio, String medio, List<EmpresaTransporte> empresa_transporte) {
        this.idMedio = idMedio;
        this.medio = medio;
        this.empresa_transporte=empresa_transporte;
    }
    public MedioTransporte(String medio, List<EmpresaTransporte> empresa_transporte) {
        this.medio = medio;
        this.empresa_transporte=empresa_transporte;
    }

    public MedioTransporte() {
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }
    public Long getIdMedio() {
        return idMedio;
    }

    public void setIdMedio(Long idMedio) {
        this.idMedio = idMedio;
    }
    public List<EmpresaTransporte> getEmpresa_transporte() {
        return empresa_transporte;
    }
    public void setEmpresa_transporte(List<EmpresaTransporte> empresa_transporte) {
        this.empresa_transporte = empresa_transporte;
    }

    
}

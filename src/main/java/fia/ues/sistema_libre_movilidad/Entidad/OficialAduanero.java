package fia.ues.sistema_libre_movilidad.Entidad;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name ="oficial_aduanero")
public class OficialAduanero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    @ManyToOne
    @JoinColumn(name="pais", nullable = false)
    private Pais pais;

    @OneToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
    
    //constructor con dos parametros
    public OficialAduanero(Long id, Pais pais, Usuario usuario) {
        this.id = id;
        this.pais=pais;
        this.usuario=usuario;
    }
    //constructor con un parametro
    public OficialAduanero(Pais pais, Usuario usuario) {
        this.pais=pais;
        this.usuario =usuario;
    }
    //constructor vacio
    public OficialAduanero() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Pais getPais() {
        return pais;
    }
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

package mx.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "domicilio")
public class Domicilio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_domicilio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDomicilio;

    private String calle;

    @Column(name = "no_calle")
    private String noCalle;

    private String pais;
    
    @OneToOne(mappedBy = "domicilio")
    private Alumno alumno;

    @Override
    public String toString() {
        return "Domicilio{" + "idDomicilio=" + idDomicilio + ", calle=" + calle + ", noCalle=" + noCalle + ", pais=" + pais + '}';
    }

}

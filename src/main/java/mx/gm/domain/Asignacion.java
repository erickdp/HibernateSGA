package mx.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "asignacion")
public class Asignacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_asignacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsignacion;

    private String turno;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    private Curso curso;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno")
    private Alumno alumno;

    @Override
    public String toString() {
        return "Asignacion{" + "idAsignacion=" + idAsignacion + ", turno=" + turno + ", curso=" + curso + ", alumno=" + alumno + '}';
    }

}

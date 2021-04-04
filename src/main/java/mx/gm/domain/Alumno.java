package mx.gm.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_alumno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlumno;

    private String nombre;

    private String apellido;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id_domicilio")
    private Domicilio domicilio;
    
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto")
    private Contacto contacto;
    
    @OneToMany(mappedBy = "alumno")
    private List<Asignacion> asignacionesAlumno;

//    Usar el toString o lanza error al imprimir el objeto
    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio + ", contacto=" + contacto + '}';
    }
    
}

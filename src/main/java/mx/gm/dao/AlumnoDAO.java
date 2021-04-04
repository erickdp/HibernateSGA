package mx.gm.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.gm.domain.Alumno;

public class AlumnoDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public AlumnoDAO() {
        emf = Persistence.createEntityManagerFactory("HibernatePU");
        em = emf.createEntityManager();
    }

    public void listar() {
        String hql = "SELECT p FROM Alumno p";
        Query query = em.createQuery(hql);
        List<Alumno> alumnos = query.getResultList();
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }
}

package mx.gm.dao;

import java.util.List;
import mx.gm.domain.Alumno;

public class AlumnoDAO extends GenericDAO<Alumno> {
    
    @Override
    public List<Alumno> listar() {
        em = getEntityManager();
        return em.createQuery("FROM Alumno a").getResultList();
    }

    @Override
    public void insertar(Alumno objetoPersistir) {
//        Se debe inicializar la transaccion porque no tengo servidor de aplicaciones
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(objetoPersistir);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } 
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    @Override
    public void actualizar(Alumno objetoMerge) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(objetoMerge);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Alumno buscarPorId(Alumno objetoBuscar) {
        em = getEntityManager();
        return em.find(Alumno.class, objetoBuscar.getIdAlumno());
    }

    @Override
    public void eliminarRegistro(Alumno objetoEliminar) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(objetoEliminar));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}

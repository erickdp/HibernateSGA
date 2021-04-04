package mx.gm.dao;

import java.util.List;
import mx.gm.domain.Curso;

public class CursoDAO extends GenericDAO<Curso> {
    
    @Override
    public List<Curso> listar() {
        em = getEntityManager();
        return em.createQuery("SELECT c FROM Curso c").getResultList();
    }

    @Override
    public void insertar(Curso objetoPersistir) {
//        Se debe inicializar la transaccion porque no tengo servidor de aplicaciones
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(objetoPersistir);
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
    public void actualizar(Curso objetoMerge) {
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
    public Curso buscarPorId(Curso objetoBuscar) {
        em = getEntityManager();
        return em.find(Curso.class, objetoBuscar.getIdCurso());
    }

    @Override
    public void eliminarRegistro(Curso objetoEliminar) {
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

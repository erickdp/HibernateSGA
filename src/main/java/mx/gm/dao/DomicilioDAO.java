package mx.gm.dao;

import java.util.List;
import mx.gm.domain.Domicilio;

public class DomicilioDAO extends GenericDAO<Domicilio> {

    @Override
    public List<Domicilio> listar() {
        em = getEntityManager();
        return em.createQuery("SELECT d FROM Domicilio d").getResultList();
    }

    @Override
    public void insertar(Domicilio objetoPersistir) {
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
    public void actualizar(Domicilio objetoMerge) {
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
    public Domicilio buscarPorId(Domicilio objetoBuscar) {
        em = getEntityManager();
        return em.find(Domicilio.class, objetoBuscar.getIdDomicilio());
    }

    @Override
    public void eliminarRegistro(Domicilio objetoEliminar) {
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

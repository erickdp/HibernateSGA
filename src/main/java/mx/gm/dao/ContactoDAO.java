package mx.gm.dao;

import java.util.List;
import mx.gm.domain.Alumno;
import mx.gm.domain.Contacto;

public class ContactoDAO extends GenericDAO<Contacto> {

    @Override
    public List<Contacto> listar() {
        em = getEntityManager();
        return em.createQuery("FROM Contacto c").getResultList();
    }

    @Override
    public void insertar(Contacto objetoPersistir) {
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
    public void actualizar(Contacto objetoMerge) {
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
    public Contacto buscarPorId(Contacto objetoBuscar) {
        em = getEntityManager();
        return em.find(Contacto.class, objetoBuscar.getIdContacto());
    }

    @Override
    public void eliminarRegistro(Contacto objetoEliminar) {
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

    //    Ejemplo para crear queries personalizados pero como se tiene el 
    //    mapeo bidireccional se puede acceder de igual forma
    public Alumno buscarAlumnoPorEmail(Contacto contactoBuscar) {
        em = getEntityManager();
        String email = contactoBuscar.getEmail();
        return (Alumno) em.createQuery("SELECT c.alumno FROM Contacto c WHERE c.email = :email").setParameter("email", email).getSingleResult();
    }

}

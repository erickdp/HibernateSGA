package mx.gm.dao;

import java.util.List;
import mx.gm.domain.Domicilio;

public class DomicilioDAO extends GenericDAO<Domicilio> {

    @Override
    public List<Domicilio> listar() {
        return em.createQuery("SELECT d FROM Domicilio d").getResultList();
    }

    @Override
    public void insertar(Domicilio objetoPersistir) {
//        Se debe inicializar la transaccion porque no tengo servidor de aplicaciones
        try {
            em.getTransaction().begin();
            em.persist(objetoPersistir);
            em.getTransaction().commit();
        } catch (Exception e) {
            
        }
    }

    @Override
    public void actualizar(Domicilio objetoMerge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Domicilio buscarPorId(Domicilio objetoBuscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

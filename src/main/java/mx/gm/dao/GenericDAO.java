package mx.gm.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO<T> {

    protected static EntityManager em;
    private static EntityManagerFactory emf;
    private static final String PU = "HibernatePU";

    public GenericDAO() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PU);
        }
    }

    protected EntityManager getEntityManager() {
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }

    public abstract List<T> listar();

    public abstract void insertar(T objetoPersistir);

    public abstract void actualizar(T objetoMerge);

    public abstract T buscarPorId(T objetoBuscar);

//    Solo utilizar en caso necesario
    public abstract void eliminarRegistro(T objetoEliminar);
}

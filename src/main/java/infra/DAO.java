package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> eClass;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        } catch (Exception e) {
            // ... Logar Log4j
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> eClass) {
        this.eClass = eClass;
        em = emf.createEntityManager();
    }

    public DAO<E> openTransaction() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> closeTransaction() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> insert(E entity) {
        em.persist(entity);
        return this;
    }

    public DAO<E> insertAtomic(E entity) {
        return this.openTransaction().insert(entity).closeTransaction();
    }

    public E getById(Object id) {
        return em.find(eClass, id);
    }

    public List<E> getAll(int limit, int offset) {
        if (eClass == null) {
            throw new UnsupportedOperationException("Class null!");
        }

        String jpql = "SELECT e FROM " + eClass.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, eClass);
        query.setMaxResults(limit);
        query.setFirstResult(offset);

        return query.getResultList();
    }

    public List<E> getAll() {
        return this.getAll(10, 0);
    }

    public void close() {
        em.close();
    }

}

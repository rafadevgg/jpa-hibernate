package test.basic;

import model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ChangeUser3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        User user = em.find(User.class, 7L);
        em.detach(user); // remove o objeto do estado gerenciado...

        user.setName("Leozinho");
        em.merge(user);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}

package test.basic;

import model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NewUser {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();
        User user = new User("Leonardo", "leonardo@gmail.com");

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        System.out.println("O Id gerado foi: " + user.getId());

        em.close();
        emf.close();
    }
}

package test.basic;

import model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class GetUsers {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT u FROM User u"; // nome da class
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setMaxResults(5);
        List<User> users = query.getResultList();

        for (User u : users) {
            System.out.println("ID: " + u.getId() + " E-mail: " + u.getEmail());
        }

        em.close();
        emf.close();
    }
}

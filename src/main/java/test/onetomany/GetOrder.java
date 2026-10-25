package test.onetomany;

import infra.DAO;
import model.onetomany.Order;
import model.onetomany.OrderItem;

public class GetOrder {
    public static void main(String[] args) {
        DAO<Order> dao = new DAO<>(Order.class);
        Order o = dao.getById(1L);

        for (OrderItem i : o.getItens()) {
            System.out.println(i.getQuantify());
            System.out.println(i.getProduct().getName());
        }

        dao.close();
    }
}

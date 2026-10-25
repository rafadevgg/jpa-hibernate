package test.onetomany;

import infra.DAO;
import model.basic.Product;
import model.onetomany.Order;
import model.onetomany.OrderItem;

public class NewOrder {
    public static void main(String[] args) {
        DAO<Object> dao = new DAO<>();
        Product p = new Product("Mousepad", 179.99);
        Order o = new Order();
        OrderItem i = new OrderItem(o, p, 10);

        dao.openTransaction()
                .insert(p)
                .insert(o)
                .insert(i)
                .closeTransaction()
                .close();
    }
}

package test.basic;

import infra.ProductDAO;
import model.basic.Product;

import java.util.List;

public class GetProducts {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.getAll();

        for (Product p : products) {
            System.out.println("ID: " + p.getId() + ", Nome: " + p.getName());
        }

        double precoTotal = products
                .stream()
                .map(p -> p.getPreco())
                .reduce(0.0, (t, p) -> t + p)
                .doubleValue();
        System.out.println("O valor total é R$ " + precoTotal);

        dao.close();
    }
}

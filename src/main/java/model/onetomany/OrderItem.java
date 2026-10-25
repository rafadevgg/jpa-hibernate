package model.onetomany;

import model.basic.Product;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "order_itens")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private int quantify;

    @Column(nullable = false)
    private Double price;

    public OrderItem() {}

    public OrderItem(Order order, Product product, int quantify) {
        this.setOrder(order);
        this.setProduct(product);
        this.setQuantify(quantify);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setProduct(Product product) {
        this.product = product;

        if (product != null && this.price == null) {
            this.setPrice(product.getPreco());
        }
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantify(int quantify) {
        this.quantify = quantify;
    }

    public int getQuantify() {
        return quantify;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

}

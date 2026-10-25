package model.onetomany;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> itens;

    public Order() {
        this(new Date());
    }

    public Order(Date date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setItens(List<OrderItem> itens) {
        this.itens = itens;
    }

    public List<OrderItem> getItens() {
        return itens;
    }

}

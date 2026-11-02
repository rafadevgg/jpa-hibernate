package model.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double nota;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "atores_filmes",
            joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id")
    )
    private List<Ator> atores;

    public Filme() {}

    public Filme(String name, Double nota) {
        this.name = name;
        this.nota = nota;
    }

    public void addAtor(Ator ator) {
        if (ator != null && !getAtores().contains(ator)) {
            getAtores().add(ator);
            if (!ator.getFilmes().contains(this)) {
                ator.getFilmes().add(this);
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public List<Ator> getAtores() {
        if (atores == null) {
            atores = new ArrayList<>();
        }
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }
}

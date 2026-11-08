package test.find;

import infra.DAO;
import model.manytomany.Ator;
import model.manytomany.Filme;

import java.util.List;

public class ObterFilmes {
    public static void main(String[] args) {
        DAO<Filme> dao = new DAO<>(Filme.class);
        List<Filme> filmes = dao.find("filmesNotaMaiorQue", "nota", 8.5);

        for (Filme f : filmes) {
            System.out.println(f.getName() + " => " + f.getNota());

            for (Ator a : f.getAtores()) {
                System.out.println(a.getName());
            }
        }
    }
}

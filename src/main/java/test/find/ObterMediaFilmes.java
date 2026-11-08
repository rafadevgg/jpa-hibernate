package test.find;

import infra.DAO;
import model.find.NotaFilme;

public class ObterMediaFilmes {
    public static void main(String[] args) {
        DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
        NotaFilme nota = dao.findOne("mediaGeral");
        System.out.println("Média dos filmes => " + nota.getMedia());
        dao.close();
    }
}

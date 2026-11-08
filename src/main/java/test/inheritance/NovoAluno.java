package test.inheritance;

import infra.DAO;
import model.inheritance.Aluno;
import model.inheritance.AlunoBolsista;

public class NovoAluno {
    public static void main(String[] args) {
        DAO<Aluno> alunoDAO = new DAO<>();
        Aluno aluno1 = new Aluno(123L, "João");
        AlunoBolsista aluno2 = new AlunoBolsista(345L, "Maria", 1000);
        alunoDAO.insertAtomic(aluno1);
        alunoDAO.insertAtomic(aluno2);
        alunoDAO.close();
    }
}

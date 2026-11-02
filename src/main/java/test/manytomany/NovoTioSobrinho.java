package test.manytomany;

import infra.DAO;
import model.manytomany.Sobrinho;
import model.manytomany.Tio;

public class NovoTioSobrinho {
    public static void main(String[] args) {
        Tio tia1 = new Tio("Maria");
        Tio tio2 = new Tio("João");
        Sobrinho sobrinho1 = new Sobrinho("Davi");
        Sobrinho sobrinha2 = new Sobrinho("Ana");

        tia1.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tia1);

        tia1.getSobrinhos().add(sobrinha2);
        sobrinha2.getTios().add(tia1);

        tio2.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tio2);

        tio2.getSobrinhos().add(sobrinha2);
        sobrinha2.getTios().add(tio2);

        DAO<Object> dao = new DAO<>();
        dao.openTransaction()
                .insert(tia1)
                .insert(tio2)
                .insert(sobrinho1)
                .insert(sobrinha2)
                .closeTransaction()
                .close();
    }
}

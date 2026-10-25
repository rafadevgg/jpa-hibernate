package test.onetoone;

import infra.DAO;
import model.onetoone.Client;
import model.onetoone.Seat;

public class NewClientSeat1 {
    public static void main(String[] args) {
        Seat s = new Seat("16A");
        Client c = new Client("Carlos", s);

        DAO<Object> dao = new DAO<>();
        dao.openTransaction()
                .insert(s)
                .insert(c)
                .closeTransaction()
                .close();
    }
}

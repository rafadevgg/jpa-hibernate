package test.onetoone;

import infra.DAO;
import model.onetoone.Client;
import model.onetoone.Seat;

public class NewClientSeat2 {
    public static void main(String[] args) {
        Seat s = new Seat("17F");
        Client c = new Client("Carlos", s);
        DAO<Client> dao = new DAO<>(Client.class);

        dao.insertAtomic(c);
    }
}

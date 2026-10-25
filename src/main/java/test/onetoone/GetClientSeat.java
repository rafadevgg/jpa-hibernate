package test.onetoone;

import infra.DAO;
import model.onetoone.Client;
import model.onetoone.Seat;

public class GetClientSeat {
    public static void main(String[] args) {
        DAO<Client> daoC = new DAO<>(Client.class);
        Client c = daoC.getById(1L);
        System.out.println(c.getSeat().getName());
        daoC.close();

        DAO<Seat> daoS = new DAO<>(Seat.class);
        Seat s = daoS.getById(5L);
        System.out.println(s.getClient().getName());
        daoS.close();
    }
}

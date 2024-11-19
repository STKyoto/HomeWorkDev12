package org.example;

import org.example.crud.ClientCrudService;
import org.example.crud.PlanetCrudService;
import org.example.crud.TicketCrudService;
import org.example.db.DataBase;
import org.example.models.Client;
import org.example.models.Planet;
import org.example.models.Ticket;

import java.sql.Time;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();
        TicketCrudService ticketCrudService = new TicketCrudService();

//        clientCrudService.saveClient("Nastya");
//        System.out.println(clientCrudService.findById(11));
//        clientCrudService.updateClient(new Client(11, "Josh Bush"));
//        clientCrudService.deleteById(11);


//        planetCrudService.savePlanet("Earth");
//        System.out.println(planetCrudService.findById("MARS"));
//        planetCrudService.updatePlanet(new Planet("MARS", "mmaarrss"));
//        planetCrudService.deleteById("Mars");


//        ticketCrudService.createTicket(new Ticket(
//                LocalDateTime.now(),
//                clientCrudService.findById(1),
//                planetCrudService.findById("VENUS"),
//                planetCrudService.findById("SATURN")
//                ));
//        System.out.println(ticketCrudService.findTicketById(11));
//        ticketCrudService.deleteTicket(3L);
//        ticketCrudService.updateTicket(new Ticket(
//                4L,
//                LocalDateTime.now(),
//                clientCrudService.findById(1),
//                planetCrudService.findById("MARS"),
//                planetCrudService.findById("VENUS")));
    }
}
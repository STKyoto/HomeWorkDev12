package org.example;

import org.example.crud.ClientCrudService;
import org.example.crud.PlanetCrudService;
import org.example.db.DataBase;
import org.example.models.Client;
import org.example.models.Planet;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();

//        clientCrudService.saveClient("Nastya");
//        System.out.println(clientCrudService.findById(11));
//        clientCrudService.updateClient(new Client(11, "Josh Bush"));
//        clientCrudService.deleteById(11);


//        planetCrudService.savePlanet("Earth");
//        System.out.println(planetCrudService.findById("MARS"));
//        planetCrudService.updatePlanet(new Planet("MARS", "mmaarrss"));
//        planetCrudService.deleteById("Mars");
    }
}
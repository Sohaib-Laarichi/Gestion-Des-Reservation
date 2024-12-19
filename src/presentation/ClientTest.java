package presentation;

import service.ClientService;
import entities.Client;

public class ClientTest {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();

        // Test create
        Client client = new Client("sohaib", "laarichi", "local@test", "070770");
        //clientService.create(client);
       

        // Test update
        

        //clientService.update(new Client(7, "update test", "laarichi", "local@test", "070770"));

        

        // Test delete
       	clientService.delete(new Client(7, "update test", "laarichi", "local@test", "070770"));
        

        // Test findAll
        clientService.findAll();

        // Test findById
        Client foundClient = clientService.findById(3);
        
    }
}

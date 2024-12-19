
package presentation;

import java.sql.Connection;
import java.sql.SQLException;
import connexion.Connexion;
import service.ClientService;
import entities.Client;

public class Main {
    public static void main(String[] args) {
        
           	
                ClientService clientService = new ClientService();
                Client client = new Client("sohaib", "laarichi", "local@test", "070770");
                //clientService.create(client);
                
                //client.setEmail("saa3ed@test");
                //clientService.update(client);
                
                System.out.println(clientService.findById(1));
                //clientService.delete(client);
                
                clientService.findAll();
                
    
}

}
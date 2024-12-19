/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package presentation;

import entities.Chambre;
import entities.Client;
import entities.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import service.ChamberService;
import service.ClientService;
import service.ReservationService;

/**
 *
 * @author Dark
 */
public class ReservationTest {
    
    public static void main(String[] args) {
        ReservationService reservationService = new ReservationService();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Create test
            Date dateDebut = dateFormat.parse("2024-02-01");
            Date dateFin = dateFormat.parse("2024-02-02");
            Chambre chambre = new Chambre(12,"Deluxe", true, 101, "A deluxe room", 2);
            Client client = new Client(2,"John", "Doe", "john.doe@example.com", "1234567890");
            Reservation reservation = new Reservation(8,dateDebut, dateFin, chambre, client);
            ClientService clientService = new ClientService();
            //clientService.create(client);
            ChamberService chambreService = new ChamberService();
            //chambreService.create(chambre);
           // reservationService.create(reservation);

            // Update test
            //reservation.setDateFinFromString("2024-02-03");
            //reservationService.update(reservation);

            // Find by ID test
            reservationService.findById(9);
            

            // Find all test
            reservationService.findAll();


            // Delete test
            //reservationService.delete(reservation);

        } catch (ParseException e) {
            System.out.println("Erreur lors du parsing des dates");
            e.printStackTrace();
        }
    }
}

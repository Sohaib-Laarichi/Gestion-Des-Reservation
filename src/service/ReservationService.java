package service;

import DAO.IDAO;
import connexion.Connexion;
import entities.Chambre;
import entities.Client;
import entities.Reservation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationService implements IDAO<Reservation> {

    @Override
    public boolean create(Reservation o) {
        String req = "INSERT INTO reservation (dateDebut, dateFin, chambreId, clientId) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setDate(1, new java.sql.Date(o.getDateDebut().getTime()));
            ps.setDate(2, new java.sql.Date(o.getDateFin().getTime()));
            ps.setInt(3, o.getChambre().getId());
            ps.setInt(4, o.getClient().getId());
            if (ps.executeUpdate() == 1) {
                System.out.println("Reservation créée");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la création de reservation");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Reservation o) {
        String req = "DELETE FROM reservation WHERE id = ?";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                System.out.println("Reservation supprimée");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de reservation");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Reservation o) {
        String req = "UPDATE reservation SET dateDebut=?, dateFin=?, chambreId=?, clientId=? WHERE id=?";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setDate(1, new java.sql.Date(o.getDateDebut().getTime()));
            ps.setDate(2, new java.sql.Date(o.getDateFin().getTime()));
            ps.setInt(3, o.getChambre().getId());
            ps.setInt(4, o.getClient().getId());
            ps.setInt(5, o.getId());
            if (ps.executeUpdate() == 1) {
                System.out.println("Reservation modifiée");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de reservation");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Reservation> findAll() {
        String req = "SELECT * FROM reservation";
        List<Reservation> reservations = new ArrayList<>();
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reservation reservation = new Reservation(
                    rs.getInt("id"),
                    rs.getDate("dateDebut"),
                    rs.getDate("dateFin"),
                    new Chambre(rs.getInt("chambreId")),
                    new Client(rs.getInt("clientId"))
                );
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des reservations");
            e.printStackTrace();
        }

        // Display all reservations
        for (Reservation reservation : reservations) {
            System.out.println("Reservation Details:");
            System.out.println("ID: " + reservation.getId());
            System.out.println("Date Debut: " + reservation.getDateDebutAsString());
            System.out.println("Date Fin: " + reservation.getDateFinAsString());
            System.out.println("Chambre ID: " + reservation.getChambre().getId());
            System.out.println("Client ID: " + reservation.getClient().getId());
        }

        return reservations;
    }

    @Override
    public Reservation findById(int id) {
        String req = "SELECT * FROM reservation WHERE id = ?";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Reservation reservation = new Reservation(
                    rs.getInt("id"),
                    rs.getDate("dateDebut"),
                    rs.getDate("dateFin"),
                    new Chambre(rs.getInt("chambreId")),
                    new Client(rs.getInt("clientId"))
                );
                System.out.println("Reservation Details:");
                System.out.println("ID: " + reservation.getId());
                System.out.println("Date Debut: " + reservation.getDateDebutAsString());
                System.out.println("Date Fin: " + reservation.getDateFinAsString());
                System.out.println("Chambre ID: " + reservation.getChambre().getId());
                System.out.println("Client ID: " + reservation.getClient().getId());
                return reservation;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche de reservation");
            e.printStackTrace();
        }
        return null;
    }
}

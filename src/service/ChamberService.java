package service;

import DAO.IDAO;
import connexion.Connexion;
import entities.Chambre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChamberService implements IDAO<Chambre> {

    @Override
    public boolean create(Chambre o) {
        String req = "insert into chambre values(null, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getType());
            ps.setBoolean(2, o.isAvailable());
            ps.setInt(3, o.getNumber());
            ps.setString(4, o.getDescription());
            ps.setInt(5, o.getCategorieId());
            if (ps.executeUpdate() == 1) {
                System.out.println("Chambre ajoutée");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insert de chambre");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Chambre o) {
        String req = "DELETE FROM chambre WHERE id = ?";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                System.out.println("Chambre supprimée");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de chambre");
            return false;
        }
        return false;
    }

    @Override
    public boolean update(Chambre o) {
        String req = "update chambre set type=?, available=?, number=?, description=?, categorieId=? where id=?";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getType());
            ps.setBoolean(2, o.isAvailable());
            ps.setInt(3, o.getNumber());
            ps.setString(4, o.getDescription());
            ps.setInt(5, o.getCategorieId());
            ps.setInt(6, o.getId());
            if (ps.executeUpdate() == 1) {
                System.out.println("Chambre modifiée");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de chambre");
            e.printStackTrace();
        }
        return false;
    }

    @Override

public List<Chambre> findAll() {
    String req = "select * from chambre";
    List<Chambre> chambres = new ArrayList<>();
    try {
        PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Chambre chambre = new Chambre(
                rs.getInt("id"),
                rs.getString("type"),
                rs.getBoolean("available"),
                rs.getInt("number"),
                rs.getString("description"),
                rs.getInt("categorieId")
            );
            chambres.add(chambre);
            System.out.println("Chambre ID: " + chambre.getId());
            System.out.println("Type: " + chambre.getType());
            System.out.println("Available: " + chambre.isAvailable());
            System.out.println("Number: " + chambre.getNumber());
            System.out.println("Description: " + chambre.getDescription());
            System.out.println("Categorie ID: " + chambre.getCategorieId());
            System.out.println("---------------------------");
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la récupération des chambres");
        e.printStackTrace();
    }
    return chambres;
}


    @Override
    public Chambre findById(int id) {
        String req = "select * from chambre where id = ?";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Chambre chambre = new Chambre(
                    rs.getInt("id"),
                    rs.getString("type"),
                    rs.getBoolean("available"),
                    rs.getInt("number"),
                    rs.getString("description"),
                    rs.getInt("categorieId")
                );
                System.out.println("Chambre trouvée: ");
                System.out.println("ID: " + chambre.getId());
                System.out.println("Type: " + chambre.getType());
                System.out.println("Available: " + chambre.isAvailable());
                System.out.println("Number: " + chambre.getNumber());
                System.out.println("Description: " + chambre.getDescription());
                System.out.println("Categorie ID: " + chambre.getCategorieId());
                return chambre;
            } else {
                System.out.println("Chambre non trouvée");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de la chambre");
            e.printStackTrace();
        }
        return null;
    }

    public String getCategoryNameById(int categoryId) {
        String req = "SELECT name FROM categorie WHERE id = ?";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de la catégorie");
            e.printStackTrace();
        }
        return null;
    }

    public boolean verifyCategory(Chambre chambre, String expectedCategory) {
        String categoryName = getCategoryNameById(chambre.getCategorieId());
        return expectedCategory.equals(categoryName);
    }
}

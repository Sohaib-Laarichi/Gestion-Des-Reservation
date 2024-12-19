package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.IDAO;
import connexion.Connexion;
import entities.Categorie;

public class CategorieService implements IDAO<Categorie> {

	@Override
	public boolean create(Categorie o) {
		String req = "insert into Categorie values(null, ?, ?)";
		try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getLibelle());
            ps.setString(2, o.getCode());
            if (ps.executeUpdate() == 1) {
                System.out.println("Categorie ajoutée");
            	return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insert de categorie");
		return false;
	}
		return false;
		}

	@Override
	public boolean delete(Categorie o) {
		String req = "DELETE FROM Categorie WHERE id = ?";
		try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
            	System.out.println("Categorie supprimée");
                return true;
            }
        } catch (SQLException e) {
        	System.out.println("Erreur lors de la suppression de categorie");
        	return false;
	}
		return false;
	}
		

	@Override
	public boolean update(Categorie o) {
		String req = "update Categorie set libelle=?, code=? where id=?";
		try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getLibelle());
            ps.setString(2, o.getCode());
            ps.setInt(3, o.getId());
            if (ps.executeUpdate() == 1) {
                System.out.println("Categorie modifiée");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de categorie");
            e.printStackTrace();
		return false;
	}
	return false;
}

	@Override
	public List<Categorie> findAll() {
		String req = "select * from Categorie";
		try {
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			if (ps.executeQuery() != null) {
				Statement stmt = Connexion.getConnection().createStatement();
				System.out.println("Liste des catégories");
				ResultSet rs = stmt.executeQuery(req);
				while (rs.next()) {
					System.out.println("id: " + rs.getInt("id") + " libelle: " + rs.getString("libelle") + " code: "
							+ rs.getString("code"));
				}
			}
			
		} catch (SQLException e) {
			System.out.println("Erreur lors de la récupération de la liste des catégories");
			e.printStackTrace();
		}
		return null;
	}

	@Override

public Categorie findById(int id) {
    String req = "select * from Categorie where id = ?";
    try {
        PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Categorie categorie = new Categorie(rs.getString("libelle"), rs.getString("code"));
            System.out.println("ID: " + id);
            System.out.println("Libelle: " + categorie.getLibelle());
            System.out.println("Code: " + categorie.getCode());
            return categorie;
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la recherche de categorie");
        e.printStackTrace();
    }
    return null;
}


}

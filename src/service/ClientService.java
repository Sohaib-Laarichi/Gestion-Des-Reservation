package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.IDAO;
import connexion.Connexion;
import entities.Client;

public class ClientService implements IDAO<Client> {

	@Override
	public boolean create(Client o) {
		String req = "insert into Client values(null, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(3, o.getEmail());
			ps.setString(4, o.getTelephone());
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de l'insert de client");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Client o) {
		String req = "DELETE FROM Client WHERE id = ?";
		try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
            	System.out.println("Client supprimé");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de client");
            
		return false;
	}
	return false;
}

	@Override
	public boolean update(Client o) {
		String req="update Client set nom=?, prenom=?, email=?, telephone=? where id=?";
		try {
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(3, o.getEmail());
			ps.setString(4, o.getTelephone());
			ps.setInt(5, o.getId());
			if (ps.executeUpdate() == 1) {
				System.out.println("Client mis à jour");
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de la mise à jour de client");
			e.printStackTrace();
		}
		return false;
	}

	@Override

public Client findById(int id) {
    String req = "select * from Client where id = ?";
    try {
        PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        System.out.println("Client trouvé");
        if (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Nom: " + rs.getString("nom"));
            System.out.println("Prenom: " + rs.getString("prenom"));
            System.out.println("Email: " + rs.getString("email"));
            System.out.println("Telephone: " + rs.getString("telephone"));
            return new Client(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getString("email"),
                rs.getString("telephone")
            );
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la recherche de client");
        e.printStackTrace();
    }
    return null;
}


	@Override
	public List<Client> findAll() {
		String req = "select * from Client";
		try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			if (ps.executeQuery() != null) {
				Statement stmt = Connexion.getConnection().createStatement();
				System.out.println("Liste des clients");
				ResultSet rst = stmt.executeQuery(req);
				while (rst.next()) {
					System.out.println("ID: " + rst.getInt("id"));
					System.out.println("Nom: " + rst.getString("nom"));
					System.out.println("Prenom: " + rst.getString("prenom"));
					System.out.println("Email: " + rst.getString("email"));
					System.out.println("Telephone: " + rst.getString("telephone"));
					System.out.println("**********************************");
					System.out.println();
				}
				return null;
			}
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche de client");
		return null;
	}
	return null;
}
}

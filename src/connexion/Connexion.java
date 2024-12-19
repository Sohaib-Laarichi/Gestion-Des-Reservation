package connexion;

import java.sql.*;

public class Connexion {
	
       private static final String url = "jdbc:mysql://localhost:3306/gestionDesReservationt?useUnicode=true" +
                					"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
       private static final String user="root";
       private static final String password="";
       private static Connection cnx=null;
       static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver chargé");
				cnx=DriverManager.getConnection(url,user,password);
				System.out.println("Connexion établie");
			} catch (ClassNotFoundException e) {
				System.out.println("Erreur de chargement de pilote");
			} catch (SQLException e) {
		        System.out.println("Erreur de connexion à la base de données");
			}
       }

		public static Connection getConnection() {
			return cnx;
		}

		public static void close() {
			try {
				cnx.close();
				System.out.println("Connexion fermée");
			} catch (SQLException e) {
				System.out.println("Erreur de fermeture de connexion");
			}
		}
}

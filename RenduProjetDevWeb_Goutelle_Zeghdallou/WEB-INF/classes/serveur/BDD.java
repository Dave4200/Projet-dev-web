package serveur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Objet qui permet de se connecter a la base de donnée
 * et de faire des requetes
 * @author jeremy ilyes 
 * 
 * */
public class BDD {
	private static Connection connection;


	/**
	 * 
	 * @return true si la connexion a la bdd a réussi false sinon 
	 */
	public boolean ConnectionBDD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver OK");
			String url = "jdbc:mysql://localhost:3306/gj01587m";
			String user = "root";
			String password = "";

			connection = DriverManager.getConnection(url, user, password);

			System.out.println("Connexion établie ");
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 
	 * @param pseudo  De l'utilisateur
	 * @param mdp De l'utilisateur
	 * @return true si l'utilisateur est bien crée sinon false
	 */
	public static boolean CreerUtilisateur(String pseudo, String mdp) {
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM utilisateur WHERE IdPseudo=?");
			statement.setString(1, pseudo);
			ResultSet resultSet = statement.executeQuery();
			if (!resultSet.next()) {
				statement = connection.prepareStatement("INSERT INTO utilisateur(IdPseudo,Mdp) VALUES(?,?)");
				statement.setString(1, pseudo);
				statement.setString(2, mdp);
				statement.executeUpdate();
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 
	 * @param pseudo  De l'utilisateur
	 * @param mdp De l'utilisateur
	 * @return true si l'utilisateur est bien authentifié sinon false
	 */
	public static boolean seConnecter(String pseudo, String mdp) {
		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM utilisateur WHERE IdPseudo=? AND mdp=?");
			statement.setString(1, pseudo);
			statement.setString(2, mdp);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 
	 * @param pseudo de l'utilisateur
	 * @param mdp de l'utilisateur
	 * @param nouveauMdp de l'utilisateur
	 * @return true si le changement est autoriser sinon false
	 */
	public static boolean ChangeMotDePasse(String pseudo, String mdp, String nouveauMdp) {
		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM utilisateur WHERE IdPseudo=? AND mdp=?");
			statement.setString(1, pseudo);
			statement.setString(2, mdp);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				statement = connection.prepareStatement("UPDATE utilisateur Set mdp=? WHERE IdPseudo = ?");
				statement.setString(1, nouveauMdp);
				statement.setString(2, pseudo);
				statement.executeUpdate();

				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 
	 * @param nom du document
	 * @param mdp du document
	 * @param createur du document
	 * @param ispublic true si le document est pubic 
	 * @param proteger true si le document est proteger par un mot de passe
	 * @param lectureSeul true si le document peut seulement être lu
	 * @return true si le document a bien été crée
	 */
	public static boolean creerDocument(String nom, String mdp, String createur, Boolean ispublic, Boolean proteger,
			Boolean lectureSeul) {
		PreparedStatement statement;
		try {
			statement = connection
					.prepareStatement("INSERT INTO Document (Nom,Mdp,Createur,Public,Proteger) VALUES (?,?,?,?,?)");
			statement.setString(1, nom);
			statement.setString(2, mdp);
			statement.setString(3, createur);
			statement.setBoolean(4, ispublic);
			statement.setBoolean(5, proteger);
			statement.execute();

			statement = connection.prepareStatement(
					"INSERT INTO Accede (IdPseudo,NomDocument,Createur,LectureSeul) VALUES (?,?,?,?)");
			statement.setString(1, createur);
			statement.setString(2, nom);
			statement.setString(3, createur);
			statement.setBoolean(4, false);
			statement.execute();


			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 
	 * @param pseudo de l'utilisateur
	 * @param nom du document
	 * @param createur du document
	 * @param isPublic true si le document est public
	 * @return un objet de type DocumentTexte
	 */
	public static DocumentTexte afficheDocument(String pseudo, String nom, String createur, Boolean isPublic) {
		DocumentTexte doc;
System.out.println(isPublic);
		PreparedStatement statement;
		try {
			if (isPublic) {
				statement = connection.prepareStatement("SELECT * FROM document  WHERE Public =? AND Createur=? AND Nom=?");
				statement.setBoolean(1, true);
				statement.setString(2, createur);
				statement.setString(3, nom);

			} else {
				statement = connection.prepareStatement(
						"SELECT * FROM accede JOIN document ON accede.NomDocument = document.Nom AND accede.Createur = document.Createur WHERE IdPseudo =?  AND accede.Createur=? AND NomDocument=?");

				statement.setString(1, pseudo);
				statement.setString(2, createur);
				statement.setString(3, nom);
			}
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				System.out.println("affiche un document  " +resultSet.getString("Texte") + "IS PUBLIC "+ resultSet.getBoolean("Public"));
				Boolean lecture = false;
				if(!isPublic)
					lecture = resultSet.getBoolean("LectureSeul");
				doc = new DocumentTexte(nom, createur, resultSet.getString("Texte"),
						lecture, resultSet.getBoolean("Public"),
						resultSet.getBoolean("Proteger"));
				return doc;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param pseudo de l'utilisateur
	 * @return une ArrayList de type DocumentTexte
	 */
	public static ArrayList<DocumentTexte> listeDocument(String pseudo) {
		ArrayList<DocumentTexte> list = new ArrayList<>();

		System.out.println("Pseudo " + pseudo);
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(
					"SELECT * FROM accede JOIN document ON accede.NomDocument = document.Nom AND accede.Createur = document.Createur WHERE IdPseudo =?");
			statement.setString(1, pseudo);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				list.add(new DocumentTexte(resultSet.getString("NomDocument"), resultSet.getString("Createur"),
						resultSet.getBoolean("LectureSeul"), resultSet.getBoolean("Public"),
						resultSet.getBoolean("Proteger")));
			}

			statement = connection.prepareStatement("SELECT * FROM document  WHERE Public =? AND NOT Createur=?");
			statement.setBoolean(1, true);
			statement.setString(2, pseudo);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				list.add(new DocumentTexte(resultSet.getString("Nom"), resultSet.getString("Createur"), false,
						resultSet.getBoolean("Public"), resultSet.getBoolean("Proteger")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	
	/**
	 * 
	 * @param nom du document
	 * @param createur du document
	 * @param texte du document
	 * @return true si le texte a bien été modifié
	 */
	public static boolean mdofiDocument(String nom, String createur, String texte) {
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(
					"UPDATE document SET document.Texte=? WHERE document.Nom =? AND document.Createur =? ");
			statement.setString(1, texte);
			statement.setString(2, nom);
			statement.setString(3, createur);
			statement.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 
	 * @param nom du document
	 * @param createur du document
	 * @return ArrayList de type Message 
	 */
	public static ArrayList<Message> afficheMessage(String nom, String createur) {
		ArrayList<Message> list = new ArrayList<>();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("SELECT * FROM message WHERE NomDoc =? AND NomCreateur =?");
			statement.setString(1, nom);
			statement.setString(2, createur);
			statement.execute();
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				list.add(new Message(resultSet.getString("IdPseudo"), resultSet.getString("texteMessage"),
						resultSet.getString("Date")));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param pseudo de l'utilisateur
	 * @param nomDoc du document
	 * @param createur du document
	 * @param texte du message
	 * @param date de l'envoie du message
	 */
	public static void EnvoyerMessage(String pseudo, String nomDoc, String createur, String texte, String date) {
		try {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO message(IdPseudo,NomDoc,NomCreateur,texteMessage,Date) VALUES(?,?,?,?,?)");
			statement.setString(1, pseudo);
			statement.setString(2, nomDoc);
			statement.setString(3, createur);
			statement.setString(4, texte);
			statement.setString(5, date);

			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	/**
	 * 
	 * @param pseudo de l'utilisateur qui obient l'acces au document
	 * @param nom du document
	 * @param createur du document
	 * @param lectureSeul true si l'acces au document sera lecture seul
	 * @return true si le partage a bien été  effectuer
	 */
	public static boolean partagerDocument(String pseudo, String nom, String createur, Boolean lectureSeul) {
		System.out.println(" partager Document  " + pseudo + " " + nom + " " + createur + " " + lectureSeul);
		PreparedStatement statement;
		try {

			statement = connection.prepareStatement("SELECT IdPseudo FROM utilisateur WHERE  IdPseudo =?");
			statement.setString(1, pseudo);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				System.out.println(" ID PSEUDO  " + resultSet.getString("IdPseudo"));
				statement = connection.prepareStatement(
						"INSERT INTO Accede (IdPseudo,NomDocument,Createur,LectureSeul) VALUES (?,?,?,?)");
				statement.setString(1, pseudo);
				statement.setString(2, nom);
				statement.setString(3, createur);
				statement.setBoolean(4, lectureSeul);
				statement.execute();

				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public void closeConnectionBDD() {
		try {
			Statement st = connection.createStatement();
			ResultSet rS = st.executeQuery("SELECT * FROM utilisateur");
			while (rS.next()) {
				System.out.println("Pseudo " + rS.getString(1) + " Mdp " + rS.getString(2));
			}
			connection.close();
			System.out.println("Connexion fermé " + connection.isClosed());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		BDD bdd = new BDD();
		// bdd.CreerUtilisateur("TEST2", "123");

		bdd.closeConnectionBDD();
	}
}

package serveur;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Objet qui stock les données récuperer par BDD
 * @author jeremy
 *
 */
public class Message {
	private String pseudo;
	private String texte;
	private String date;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * Constructeur pour lire le message depuis la basse de donnée
	 * @param pseudo 
	 * @param texte
	 * @param date
	 */
	public Message(String pseudo, String texte, String date) {
		this.pseudo = pseudo;
		this.texte = texte;
		this.date = date;
	}

	/**
	 * 
	 * @param pseudo
	 * @param texte
	 */
	public Message(String pseudo, String texte) {
		date = format.format(new Date());
		this.pseudo = pseudo;
		this.texte = texte;
	}

	public String getPseudo() {
		return pseudo;
	}

	public String getTexte() {
		return texte;
	}

	public String getDate() {
		return date;
	}

	public static void main(String[] args) {
		Message test = new Message("test", "test de message");
		System.out.println(test.date);
	}
}

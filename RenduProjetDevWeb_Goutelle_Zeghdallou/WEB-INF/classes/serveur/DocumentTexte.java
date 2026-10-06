package serveur;

import java.util.ArrayList;


/**
 * Objet qui stock les données récuperer par BDD
 * @author jeremy
 *
 */
public class DocumentTexte {

	private String nom;
	private String createur;
	private String texte;
	private Boolean lectureSeul;
	private Boolean isPublic;
	private Boolean isProteger;
	private ArrayList<Message> listMessage;

	/**
	 * Constructeur de DocumentTexte sans le texte
	 * @param nom du document
	 * @param createur du document
	 * @param lectureSeul true si seulement la lecture est autoriser sinon false
	 * @param isPublic true si le document est public sinon false
	 * @param isProteger true si le document est proteger sinon false
	 */
	public DocumentTexte(String nom, String createur, Boolean lectureSeul, Boolean isPublic,
			Boolean isProteger) {
		this.nom = nom;
		this.createur = createur;
		this.lectureSeul = lectureSeul;
		this.isPublic = isPublic;
		this.isProteger = isProteger;
	}
	
	/**
	 * Constructeur de DocumentTexte avec le texte
	 * @param nom du document
	 * @param createur du document
	 * @param texte du document
	 * @param lectureSeul true si seulement la lecture est autoriser sinon false
	 * @param isPublic true si le document est public sinon false
	 * @param isProteger true si le document est proteger sinon false
	 */
	public DocumentTexte(String nom, String createur, String texte, Boolean lectureSeul, Boolean isPublic,
			Boolean isProteger) {
		this.nom = nom;
		this.createur = createur;
		this.texte = texte;
		this.lectureSeul = lectureSeul;
		this.isPublic = isPublic;
		this.isProteger = isProteger;
	}

	/**
	 * 
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * 
	 * @return
	 */
	public String getCreateur() {
		return createur;
	}
	/**
	 * 
	 * @param createur
	 */
	public void setCreateur(String createur) {
		this.createur = createur;
	}
	/**
	 * 
	 * @return
	 */
	public String getTexte() {
		return texte;
	}

	/**
	 * 
	 * @param texte
	 */
	public void setTexte(String texte) {
		this.texte = texte;
	}

	/**
	 * 
	 * @return
	 */
	public Boolean getLectureSeul() {
		return lectureSeul;
	}

	/**
	 * 
	 * @param lectureSeul
	 */
	public void setLectureSeul(Boolean lectureSeul) {
		this.lectureSeul = lectureSeul;
	}

	/**
	 * 
	 * @return
	 */
	public Boolean getIsPublic() {
		return isPublic;
	}
	
	/**
	 * 
	 * @param isPublic
	 */
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	/**
	 * 
	 * @return
	 */
	public Boolean getIsProteger() {
		return isProteger;
	}

	/**
	 * 
	 * @param isProteger
	 */
	public void setIsProteger(Boolean isProteger) {
		this.isProteger = isProteger;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Message> getListMessage() {
		return listMessage;
	}

	/**
	 * 
	 * @param listMessage
	 */
	public void setListMessage(ArrayList<Message> listMessage) {
		this.listMessage = listMessage;
	}

	
	
}

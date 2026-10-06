package serveur;

import java.util.ArrayList;

/**
 * Objet qui stock les données récuperer par BDD
 * @author jerem
 *
 */
public class Utilisateur {
	private String idPseudo;
	private ArrayList<DocumentTexte> listeDocument;
	private DocumentTexte document;

	public Utilisateur(String pseudo) {
		this.idPseudo = pseudo;
	}

	public String getIdPseudo() {
		return idPseudo;
	}

	public void setIdPseudo(String idPseudo) {
		this.idPseudo = idPseudo;
	}

	public ArrayList<DocumentTexte>  getListeDocument() {
		return listeDocument;
	}

	public void setListeDocument(ArrayList<DocumentTexte>  listeDocument) {
		this.listeDocument = listeDocument;
	}

	public DocumentTexte getDocument() {
		return document;
	}

	public void setDocument(DocumentTexte document) {
		this.document = document;
	}

}

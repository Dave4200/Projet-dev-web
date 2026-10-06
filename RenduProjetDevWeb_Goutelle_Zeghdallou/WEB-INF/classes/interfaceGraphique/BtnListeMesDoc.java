package interfaceGraphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import serveur.DocumentTexte;

public class BtnListeMesDoc extends JButton {

	DocumentTexte doc;
	FenetrePrincipal fenetre;
	public BtnListeMesDoc(DocumentTexte doc,FenetrePrincipal f ) {
		this.doc = doc;
		this.fenetre = f;
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.utilisateur.setDocument(doc);
				
			}
		});
	}
}

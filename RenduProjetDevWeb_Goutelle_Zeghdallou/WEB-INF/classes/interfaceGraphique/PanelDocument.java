package interfaceGraphique;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;
import serveur.Utilisateur;

public class PanelDocument extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelDocument(FenetrePrincipal f) {

		setPreferredSize(new Dimension(1800, 800));
		setMinimumSize(new Dimension(1800, 800));
		setLayout(new MigLayout("", "[][]", "[][]"));

		JTextArea editorPane = new JTextArea(100, 100);

		if (f.utilisateur.getDocument() != null) {
			f.client.EnvoieRequete("rDoc|" + f.utilisateur.getIdPseudo() + "|" + f.utilisateur.getDocument().getNom()
					+ "|" + f.utilisateur.getDocument().getCreateur() + "\n");

			editorPane.setText(f.client.ReponseRequete());
		}
		// p.add(editorPane, "flowy,cell 1 1,grow");

		JScrollPane scrollPane = new JScrollPane(editorPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// p.add(scrollPane);
		add(new PanelListeDocument(f));
		add(scrollPane);
		add(new PanelChat());
		// add(p);
	}

}
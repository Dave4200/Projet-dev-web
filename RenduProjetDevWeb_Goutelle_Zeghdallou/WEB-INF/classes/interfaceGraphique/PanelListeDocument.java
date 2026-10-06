package interfaceGraphique;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import serveur.DocumentTexte;

public class PanelListeDocument extends JPanel {

	public PanelListeDocument(FenetrePrincipal f) {
		setPreferredSize(new Dimension(200, 800));
		setMinimumSize(new Dimension(200, 800));
		setLayout(new CardLayout(1, 100));
		setBackground(Color.YELLOW);
		JButton mesDocument = new JButton("Mes Documents");
		JButton docPartager = new JButton("Document partager");
		JButton docPublic = new JButton("Documents public");

		mesDocument.setBackground(new Color(211, 211, 211));
		mesDocument.setMnemonic(KeyEvent.VK_ENTER);
		mesDocument.setFont(new Font("Tahoma", Font.PLAIN, 22));
		mesDocument.setSize(new Dimension(200, 40));

		docPartager.setBackground(new Color(211, 211, 211));
		docPartager.setMnemonic(KeyEvent.VK_ENTER);
		docPartager.setFont(new Font("Tahoma", Font.PLAIN, 22));
		docPartager.setSize(new Dimension(200, 40));

		docPublic.setBackground(new Color(211, 211, 211));
		docPublic.setMnemonic(KeyEvent.VK_ENTER);
		docPublic.setFont(new Font("Tahoma", Font.PLAIN, 22));
		docPublic.setSize(new Dimension(200, 40));

		JPanel panelMesDoc = new JPanel();
		JPanel panelDocPart = new JPanel();
		JPanel panelDocPublic = new JPanel();

		panelMesDoc.setLayout(new CardLayout(1, 100));
		panelDocPart.setLayout(new CardLayout(1, 100));
		panelDocPublic.setLayout(new CardLayout(1, 100));

		f.client.EnvoieRequete("lsiteDoc|" + f.utilisateur.getIdPseudo() + "\n");
		String rep = f.client.ReponseRequete();
		String docList[] = rep.split("\\|");
		for (String docuTexte : docList) {
			String doc[] = docuTexte.split(",");
			Boolean pub = false, prot = false, lect = false;
			if (doc[2].equals("true"))
				lect = true;
			if (doc[3].equals("true"))
				pub = true;
			if (doc[4].equals("true"))
				prot = true;
			f.utilisateur.getListeDocument().add(new DocumentTexte(doc[0], doc[1], lect, pub, prot));

		}

		for (DocumentTexte doc : f.utilisateur.getListeDocument()) {
			if (doc.getCreateur() == f.utilisateur.getIdPseudo()) {
				panelMesDoc.add(new BtnListeMesDoc(doc, f));
			} else if (doc.getIsPublic()) {
				panelDocPublic.add(new BtnListeMesDoc(doc, f));

			} else {
				panelDocPart.add(new BtnListeMesDoc(doc, f));
			}
		}

		mesDocument.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (panelMesDoc.isVisible()) {
					panelMesDoc.setVisible(false);
				} else {
					panelMesDoc.setVisible(true);
				}

			}
		});
		docPartager.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (panelDocPart.isVisible()) {
					panelDocPart.setVisible(false);
				} else {
					panelDocPart.setVisible(true);
				}
			}
		});

		docPublic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (panelDocPublic.isVisible()) {
					panelDocPublic.setVisible(false);
				} else {
					panelDocPublic.setVisible(true);
				}
			}
		});
		add(mesDocument);
		add(panelMesDoc);

		add(docPartager);
		add(panelDocPart);

		add(docPublic);
		add(panelDocPublic);

	}

}

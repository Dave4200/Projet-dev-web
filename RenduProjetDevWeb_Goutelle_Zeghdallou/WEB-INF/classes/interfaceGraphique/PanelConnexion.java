package interfaceGraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import net.miginfocom.swing.MigLayout;
import serveur.Utilisateur;
import socket.ClientTCP;

public class PanelConnexion extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;

	public PanelConnexion(FenetrePrincipal f) {
		setPreferredSize(new Dimension(1280, 720));
		setMinimumSize(new Dimension(1280, 720));
		setBackground(Color.GRAY);
		setLayout(new MigLayout("", "[1280]", "[720]"));

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
		panel.setPreferredSize(new Dimension(300, 250));
		add(panel, "cell 0 0,alignx center,aligny center");
		panel.setLayout(new MigLayout("", "[46.00][199.00]", "[35][30][][30][][30][30]"));
		JTextField name = new JTextField();
		panel.add(name, "cell 1 1,alignx center,aligny top");
		name.setPreferredSize(new Dimension(200, 30));

		JLabel lblPseudoManquant = new JLabel("Pseudo manquant");
		lblPseudoManquant.setForeground(Color.RED);
		panel.add(lblPseudoManquant, "cell 1 2,alignx left");

		passwordField = new JPasswordField();
		panel.add(passwordField, "cell 1 3,alignx center,aligny top");
		passwordField.setPreferredSize(new Dimension(200, 30));

		JLabel lblMotDePasse = new JLabel("Mot de passe manquant");
		lblMotDePasse.setForeground(Color.RED);
		panel.add(lblMotDePasse, "cell 1 4,alignx left");
		JButton valider = new JButton("Connection");
		valider.setMnemonic(KeyEvent.VK_ENTER);
		valider.setBackground(Color.LIGHT_GRAY);
		panel.add(valider, "cell 1 5,alignx center,aligny top");
		valider.setPreferredSize(new Dimension(200, 30));

		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (name.getText().equals("")) {
					lblPseudoManquant.setVisible(true);
				} else {
					lblPseudoManquant.setVisible(false);

				}
				if (new String(passwordField.getPassword()).equals("")) {
					lblMotDePasse.setVisible(true);
				} else {
					lblMotDePasse.setVisible(false);

				}

				if (name.getText().equals("") || new String(passwordField.getPassword()).equals("")) {
					return;
				} else {

					// if(ClientTCP.OuvrirSocket()) {

					String requete = "connexion|" + name.getText() + "|" + new String(passwordField.getPassword())
							+ "\n";
					System.out.println(requete);
					f.client.OuvrirSocket();
					f.client.EnvoieRequete(requete);
					if (f.client.ReponseRequete().equals("oui")) {
						f.utilisateur = new Utilisateur(name.getText());
						
						f.getContentPane().add(new PanelMenu(f));
						setVisible(false);
					}
					
					f.client.FermerSocket();
					return;
					// }
				}

			}
		});
		JButton inscription = new JButton("Inscription");
		inscription.setBackground(Color.LIGHT_GRAY);
		panel.add(inscription, "cell 1 6,alignx center,aligny top");
		inscription.setPreferredSize(new Dimension(200, 30));
		inscription.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new FenetreInscription(f);
			}
		});

		lblPseudoManquant.setVisible(false);
		lblMotDePasse.setVisible(false);
	}

}

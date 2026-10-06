package interfaceGraphique;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class PanelProfil extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	public PanelProfil(FenetrePrincipal fen) {

		setPreferredSize(new Dimension(1280, 720));
		setMinimumSize(new Dimension(1280, 720));
		setLayout(new MigLayout("", "[][][][256.00]", "[][][][][][50][][][][][][50][][][][][]"));

		JLabel lblPseudo = new JLabel("Pseudo :");
		lblPseudo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblPseudo, "cell 1 4");

		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(label, "cell 3 4");

		JLabel lblNouveauMotDe = new JLabel("Nouveau mot de passe :");
		lblNouveauMotDe.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblNouveauMotDe, "cell 1 6");

		passwordField = new JPasswordField();
		add(passwordField, "cell 3 6,grow");

		JLabel lblMotDePasse = new JLabel("Mot de passe  manquant");
		lblMotDePasse.setForeground(Color.RED);
		add(lblMotDePasse, "cell 3 7");

		JLabel lblConfirmationDuNouveau = new JLabel("Confirmation du nouveau mot de passe : ");
		lblConfirmationDuNouveau.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblConfirmationDuNouveau, "cell 1 8");

		passwordField_1 = new JPasswordField();
		add(passwordField_1, "cell 3 8,grow");

		JLabel lblConfirmationManquante = new JLabel("Confirmation manquante");
		lblConfirmationManquante.setForeground(Color.RED);
		add(lblConfirmationManquante, "cell 3 9");

		JButton btnChangerLeMot = new JButton("Changer le mot de passe");
		btnChangerLeMot.setBackground(Color.LIGHT_GRAY);
		btnChangerLeMot.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(btnChangerLeMot, "cell 3 10,grow");

		JLabel lblNouvelleAdresseMail = new JLabel("Nouvelle adresse mail : ");
		lblNouvelleAdresseMail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblNouvelleAdresseMail, "cell 1 12");

		textField_2 = new JTextField();
		add(textField_2, "cell 3 12,grow");
		textField_2.setColumns(10);

		JLabel lblNouvelleAdresseMail_1 = new JLabel("Nouvelle adresse mail manquante");
		lblNouvelleAdresseMail_1.setForeground(Color.RED);
		add(lblNouvelleAdresseMail_1, "cell 3 13");

		JLabel lblConfirmationDeLa = new JLabel("Confirmation de la nouvelle adresse mail : ");
		lblConfirmationDeLa.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblConfirmationDeLa, "cell 1 14");

		textField_3 = new JTextField();
		add(textField_3, "cell 3 14,grow");
		textField_3.setColumns(10);

		JLabel lblConfirmationManquante_1 = new JLabel("Confirmation manquante");
		lblConfirmationManquante_1.setForeground(Color.RED);
		add(lblConfirmationManquante_1, "cell 3 15");

		JButton btnChangerLadresseMail = new JButton("Changer l'adresse mail");
		btnChangerLadresseMail.setBackground(Color.LIGHT_GRAY);
		btnChangerLadresseMail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(btnChangerLadresseMail, "cell 3 16,grow");

		label.setText(FenetrePrincipal.pseudo);

		btnChangerLeMot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (new String(passwordField.getPassword()).equals("")) {
					lblMotDePasse.setVisible(true);
				} else {
					lblMotDePasse.setVisible(false);
				}

				if (new String(passwordField_1.getPassword()).equals("")) {
					lblConfirmationManquante.setText("Comfiramation manquante");
					lblConfirmationManquante.setVisible(true);
				} else {
					lblConfirmationManquante.setVisible(false);
				}
				
				
				if (!new String(passwordField_1.getPassword()).equals("")) {
					if (new String(passwordField.getPassword()).equals(new String(passwordField_1.getPassword()))) {
						System.out.println("new mdp");
					}
				}
			}
		});

		btnChangerLadresseMail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField_2.getText().equals("")) {
					lblNouvelleAdresseMail_1.setVisible(true);

				} else {
					lblNouvelleAdresseMail_1.setVisible(false);

				}

				if (textField_3.getText().equals("")) {
					lblConfirmationManquante_1.setVisible(true);

				} else {
					lblConfirmationManquante_1.setVisible(false);

				}

			}
		});
		lblMotDePasse.setVisible(false);
		lblConfirmationManquante.setVisible(false);
		lblNouvelleAdresseMail_1.setVisible(false);
		lblConfirmationManquante_1.setVisible(false);
	}
}

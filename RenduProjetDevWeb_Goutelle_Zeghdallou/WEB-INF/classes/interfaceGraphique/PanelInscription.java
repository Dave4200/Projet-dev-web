package interfaceGraphique;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class PanelInscription extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField pseudoTxt;
	private JTextField txtId;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	public PanelInscription(FenetreInscription f) {
		setPreferredSize(new Dimension(1280, 720));
		setMinimumSize(new Dimension(600, 400));
		setBackground(Color.GRAY);
		setLayout(new MigLayout("", "[1280px]", "[720px]"));

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(600, 450));
		panel.setBorder(new LineBorder(Color.RED));
		panel.setPreferredSize(new Dimension(600, 450));
		add(panel, "cell 0 0,alignx center,aligny center");
		panel.setLayout(new MigLayout("", "[39.00px][1px][276.00px,grow]",
				"[45.00][45.00][40px][][35px][][][][][][][][][35.00][][][]"));

		JLabel lblInscription = new JLabel("Inscription");
		panel.add(lblInscription, "cell 0 0 3 2,alignx center,aligny center");
		lblInscription.setFont(new Font("Tahoma", Font.PLAIN, 26));

		JLabel lblPseudo = new JLabel("Pseudo");
		lblPseudo.setOpaque(true);
		panel.add(lblPseudo, "cell 1 2,alignx left,aligny top");
		lblPseudo.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblPseudo.setPreferredSize(new Dimension(0, 40));

		pseudoTxt = new JTextField();
		panel.add(pseudoTxt, "cell 2 2,grow");
		pseudoTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pseudoTxt.setPreferredSize(new Dimension(120, 22));
		pseudoTxt.setColumns(10);

		JLabel lblPseudoObligatoire = new JLabel("Pseudo manquant");
		lblPseudoObligatoire.setForeground(Color.RED);
		panel.add(lblPseudoObligatoire, "cell 2 3");

		JLabel lblIdentifiant = new JLabel("Identifiant");
		panel.add(lblIdentifiant, "cell 1 4,alignx left,aligny top");
		lblIdentifiant.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblIdentifiant.setPreferredSize(new Dimension(0, 40));
		lblIdentifiant.setOpaque(true);

		txtId = new JTextField();
		panel.add(txtId, "cell 2 4,grow");
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtId.setPreferredSize(new Dimension(120, 22));
		txtId.setColumns(10);

		JLabel lblIdentifiantObligatoire = new JLabel("Identifiant manquant");
		lblIdentifiantObligatoire.setForeground(Color.RED);
		panel.add(lblIdentifiantObligatoire, "cell 2 5");

		JLabel lblAdresseMail = new JLabel("adresse mail");
		panel.add(lblAdresseMail, "cell 1 6,alignx left,aligny top");
		lblAdresseMail.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblAdresseMail.setPreferredSize(new Dimension(0, 40));
		lblAdresseMail.setOpaque(true);

		textField_1 = new JTextField();
		panel.add(textField_1, "cell 2 6,grow");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setPreferredSize(new Dimension(120, 22));
		textField_1.setColumns(10);

		JLabel lblAdresseMailObligatoire = new JLabel("adresse mail manquante");
		lblAdresseMailObligatoire.setForeground(Color.RED);
		panel.add(lblAdresseMailObligatoire, "cell 2 7");

		JLabel lblMotDePasse = new JLabel("Mot de passe");
		panel.add(lblMotDePasse, "cell 1 8,alignx left,aligny top");
		lblMotDePasse.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblMotDePasse.setPreferredSize(new Dimension(0, 40));
		lblMotDePasse.setOpaque(true);

		passwordField = new JPasswordField();
		panel.add(passwordField, "cell 2 8,grow");
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setPreferredSize(new Dimension(120, 22));

		JLabel lblMotDePass = new JLabel("Mot de passe manquant");
		lblMotDePass.setForeground(Color.RED);
		panel.add(lblMotDePass, "cell 2 9");

		JLabel lblConfirmerMotDe = new JLabel("Confirmer mot de passe");
		panel.add(lblConfirmerMotDe, "cell 1 10,alignx trailing,aligny top");
		lblConfirmerMotDe.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblConfirmerMotDe.setPreferredSize(new Dimension(0, 40));
		lblConfirmerMotDe.setOpaque(true);

		passwordField_1 = new JPasswordField();
		panel.add(passwordField_1, "cell 2 10,grow");

		JLabel lblComfiramationManquante = new JLabel("Confirmation manquante");
		lblComfiramationManquante.setForeground(Color.RED);
		panel.add(lblComfiramationManquante, "cell 2 11");

		JButton btnValider = new JButton("Valider");
		btnValider.setBackground(Color.LIGHT_GRAY);
		btnValider.setPreferredSize(new Dimension(200, 0));
		panel.add(btnValider, "cell 1 13 2 1,alignx center,aligny center");
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JButton btnRetour = new JButton("Retour");
		btnRetour.setBackground(Color.LIGHT_GRAY);
		btnRetour.setPreferredSize(new Dimension(200, 0));
		panel.add(btnRetour, "cell 1 15 2 1,alignx center,aligny top");
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnRetour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		btnValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (pseudoTxt.getText().equals("")) {
					lblPseudoObligatoire.setVisible(true);
				} else {
					lblPseudoObligatoire.setVisible(false);
				}

				if (txtId.getText().equals("")) {
					lblIdentifiantObligatoire.setVisible(true);
				} else {
					lblIdentifiantObligatoire.setVisible(false);
				}

				if (textField_1.getText().equals("")) {
					lblAdresseMailObligatoire.setVisible(true);
				} else {
					lblAdresseMailObligatoire.setVisible(false);
				}

				if (new String(passwordField.getPassword()).equals("")) {
					lblMotDePass.setVisible(true);
				} else {
					lblMotDePass.setVisible(false);
				}

				if (new String(passwordField_1.getPassword()).equals("")) {
					lblComfiramationManquante.setText("Comfiramation manquante");
					lblComfiramationManquante.setVisible(true);
				} else {
					lblComfiramationManquante.setVisible(false);
				}

				System.out.println(new String(passwordField.getPassword()) + "  ------------"
						+ new String(passwordField_1.getPassword()));
				if (!new String(passwordField_1.getPassword()).equals("")) {
					if (new String(passwordField.getPassword()).equals(new String(passwordField_1.getPassword()))) {
						lblComfiramationManquante.setVisible(false);

					} else {
						passwordField.setText("");
						passwordField_1.setText("");
						lblComfiramationManquante.setText("Le mot de passe et la confirmation sont différente");

						lblComfiramationManquante.setVisible(true);
					}
				}

			}
		});

		lblPseudoObligatoire.setVisible(false);
		lblAdresseMailObligatoire.setVisible(false);
		lblIdentifiantObligatoire.setVisible(false);
		lblComfiramationManquante.setVisible(false);
		lblMotDePass.setVisible(false);

	}
}

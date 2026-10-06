package interfaceGraphique;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

public class PanelChangementMDP extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	public PanelChangementMDP(FenetreChangementMDP f) {
		setPreferredSize(new Dimension(800, 200));
		setLayout(new MigLayout("", "[65.00][290.00][146.00][120.00]", "[38.00][][][][][]"));
		
		JLabel lblNouveuMotDe = new JLabel("Nouveu Mot de passe ");
		lblNouveuMotDe.setBackground(Color.WHITE);
		lblNouveuMotDe.setOpaque(true);
		lblNouveuMotDe.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblNouveuMotDe, "cell 1 1,grow");
		
		passwordField = new JPasswordField();
		add(passwordField, "cell 2 1 2 1,growx");
		
		JLabel lblConfirmationDeuNouveau = new JLabel("Confirmation deu nouveau mot de passe");
		lblConfirmationDeuNouveau.setBackground(Color.WHITE);
		lblConfirmationDeuNouveau.setOpaque(true);
		lblConfirmationDeuNouveau.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblConfirmationDeuNouveau, "cell 1 2,grow");
		
		passwordField_1 = new JPasswordField();
		add(passwordField_1, "cell 2 2 2 1,growx");
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBackground(Color.LIGHT_GRAY);
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnRetour, "cell 2 4,grow");
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBackground(Color.LIGHT_GRAY);
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnValider, "cell 3 4,grow");
		
		
		
		btnRetour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				
			}
		});

	}
}

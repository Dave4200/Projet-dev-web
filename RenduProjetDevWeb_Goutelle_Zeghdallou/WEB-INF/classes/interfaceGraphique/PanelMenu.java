package interfaceGraphique;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

public class PanelMenu extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numPanelVisible;
	private FenetrePrincipal fen;

	public PanelMenu(FenetrePrincipal f) {
		fen = f;
		setPreferredSize(new Dimension(1800, 1000));
		setMinimumSize(new Dimension(1800, 1000));
		setLayout(new MigLayout("", "[1928px,fill]", "[80px][730px,fill]"));
		JPanel btnMenu = new JPanel();
		btnMenu.setBackground(Color.GRAY);
		btnMenu.setPreferredSize(new Dimension(1200, 60));
		btnMenu.setBorder(new LineBorder(new Color(255, 0, 0)));
		GridBagLayout gbl_btnMenu = new GridBagLayout();
		gbl_btnMenu.columnWidths = new int[] { 33, 0, 0, 61, 116, 31, 110, 30, 101, 379, 0, 0 };
		gbl_btnMenu.rowHeights = new int[] { 0, 53, 0, 0 };
		gbl_btnMenu.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_btnMenu.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		btnMenu.setLayout(gbl_btnMenu);
		
		JLabel lblBonjour = new JLabel("Bonjour ");
		lblBonjour.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblBonjour = new GridBagConstraints();
		gbc_lblBonjour.insets = new Insets(0, 0, 5, 5);
		gbc_lblBonjour.gridx = 1;
		gbc_lblBonjour.gridy = 1;
		btnMenu.add(lblBonjour, gbc_lblBonjour);
		
		JLabel label = new JLabel("");
		label.setText(f.utilisateur.getIdPseudo());
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		btnMenu.add(label, gbc_label);
		JButton btnProfil = new JButton("Profil");
		btnProfil.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnProfil.setBackground(Color.LIGHT_GRAY);

		GridBagConstraints gbc_btnProfil = new GridBagConstraints();
		gbc_btnProfil.fill = GridBagConstraints.BOTH;
		gbc_btnProfil.insets = new Insets(0, 0, 5, 5);
		gbc_btnProfil.gridx = 4;
		gbc_btnProfil.gridy = 1;
		btnMenu.add(btnProfil, gbc_btnProfil);
		add(btnMenu, "cell 0 0,grow");
		

		PanelProfil panelProfil = new PanelProfil(f);
		PanelDocument panelDocument = new PanelDocument(f);
		JPanel menu = new JPanel();
		menu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		menu.add(panelProfil);
		menu.add(panelDocument);
		add(menu, "cell 0 1,growx,aligny center");

		btnProfil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (numPanelVisible) {
				case 2:
					panelDocument.setVisible(false);
					break;
				}
				panelProfil.setVisible(true);
				numPanelVisible = 1;
			}
		});
		JButton btnDocument = new JButton("Document");
		btnDocument.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnDocument.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_btnDocument = new GridBagConstraints();
		gbc_btnDocument.fill = GridBagConstraints.BOTH;
		gbc_btnDocument.insets = new Insets(0, 0, 5, 5);
		gbc_btnDocument.gridx = 6;
		gbc_btnDocument.gridy = 1;
		btnMenu.add(btnDocument, gbc_btnDocument);
				
						JButton btnDconnexion = new JButton("D\u00E9connexion");
						btnDconnexion.setFont(new Font("Tahoma", Font.PLAIN, 22));
						btnDconnexion.setBackground(Color.LIGHT_GRAY);
						GridBagConstraints gbc_btnDconnexion = new GridBagConstraints();
						gbc_btnDconnexion.insets = new Insets(0, 0, 5, 0);
						gbc_btnDconnexion.fill = GridBagConstraints.BOTH;
						gbc_btnDconnexion.gridx = 10;
						gbc_btnDconnexion.gridy = 1;
						btnMenu.add(btnDconnexion, gbc_btnDconnexion);

		
		btnDconnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fen.client.FermerSocket();
				 new FenetrePrincipal();
					fen.dispose();

			}
		});
		
		btnDocument.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (numPanelVisible) {
				case 1:
					panelProfil.setVisible(false);
					break;		

				}
				panelDocument.setVisible(true);
				numPanelVisible = 2;

			}
		});
		
		
		
		panelProfil.setVisible(false);
		panelDocument.setVisible(false);
	}

}

package interfaceGraphique;

import java.awt.Dimension;

import javax.swing.JDialog;

public class FenetreInscription extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FenetreInscription(FenetrePrincipal f) {
		super(f, true);
		add(new PanelInscription(this));
		setMinimumSize(new Dimension(600, 450));
		setLocationRelativeTo(f);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);

	

	}

}

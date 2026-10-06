package interfaceGraphique;

import java.awt.Dimension;

import javax.swing.JDialog;

public class FenetreChangementMDP extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FenetreChangementMDP(FenetrePrincipal f) {
		super(f, true);
		add(new PanelChangementMDP(this));
		setMinimumSize(new Dimension(800, 200));
		setPreferredSize(new Dimension(800, 200));

		setLocationRelativeTo(f);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
	}
}

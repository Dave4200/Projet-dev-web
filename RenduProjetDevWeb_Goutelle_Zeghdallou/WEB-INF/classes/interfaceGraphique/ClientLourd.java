package interfaceGraphique;


import javax.swing.SwingUtilities;

public class ClientLourd {
	public static void main(String[] args) {
		
		
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				@SuppressWarnings("unused")
				FenetrePrincipal fen = new FenetrePrincipal();
			
			}
		});
	}

}

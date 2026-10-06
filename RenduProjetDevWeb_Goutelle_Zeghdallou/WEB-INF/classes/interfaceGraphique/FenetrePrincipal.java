package interfaceGraphique;


import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;

import serveur.Utilisateur;
import socket.ClientTCP;

public class FenetrePrincipal extends JFrame {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	static String pseudo = "pseudo";
	

		
	 ClientTCP client;
	 Utilisateur utilisateur;
	
	public FenetrePrincipal() {
		client = new ClientTCP();

		PanelConnexion pc = new PanelConnexion(this);
		//PanelProfil pp = new PanelProfil();
		setTitle("Document");
		setPreferredSize(new Dimension(1800, 1000));
		setMinimumSize(new Dimension(1800, 1000));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		add(pc);
		//add(pp);
		setVisible(true);
		
	}

}

package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.InflaterInputStream;

import serveur.BDD;
import serveur.DocumentTexte;

public class ServeurTCP implements Runnable {

	final int PORT = 8888;
	ServerSocket server;

	@Override
	public void run() {
		Socket s = null;
		try {
			s = server.accept();
			Thread t = new Thread(this);
			t.start();
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(s.getOutputStream());
			String ligne;
			ligne = in.readLine();
			System.out.println("run");
			while (s != null) {
				// System.out.println("En attente d'un client...");
				String[] temp = ligne.split("\\|");
				switch (temp[0]) {
				case "connexion":
					System.out.println("requete de connexion");
					if (BDD.seConnecter(temp[1], temp[2])) {
						out.println("oui");
					} else {
						out.println("non");

					}
					break;
				case "inscription":
					break;
				case "rDoc":
					Boolean isPublic = false;
					if(temp[4].equals("true")) {
						isPublic = true;
					}
				out.println(BDD.afficheDocument(temp[1], temp[2], temp[3],isPublic));
					break;
				case "eDoc":
					break;
				case "rTchat":
					break;
				case "eTchat":
					break;
				case "nouveauDoc":
					break;
				case "partageDoc":
					break;
				case "lsiteDoc":
					String reponse = "";
					for (DocumentTexte doc : BDD.listeDocument(temp[1])) {
						reponse += doc.getNom() + "," 
						+ doc.getCreateur() + "," 
					+ doc.getLectureSeul().toString()+","
					+	 doc.getIsPublic().toString()+","
					+doc.getIsProteger().toString()+ "|";
					}
					out.println(reponse);

					break;
				}
				out.flush();
				ligne = in.readLine();

				while (ligne == null) {
					ligne = in.readLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				s.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public ServeurTCP() {
		try {
			server = new ServerSocket(PORT, 100);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServeurTCP serveur = new ServeurTCP();
		// serveur.run();
		Thread t = new Thread(serveur);
		t.start();
	}

	/*
	 * public static void main(String[] args) throws IOException { final int PORT =
	 * 8888; ServerSocket server = new ServerSocket(PORT, 1);
	 * System.out.println("En attente d'un client..."); while (true) { Socket s =
	 * server.accept(); try { BufferedReader in = new BufferedReader(new
	 * InputStreamReader(s.getInputStream())); PrintWriter out = new
	 * PrintWriter(s.getOutputStream()); String ligne; ligne = in.readLine(); while
	 * (!(ligne.equals("xyz") || ligne == null)) { int val =
	 * Integer.parseInt(ligne); val = val + 100;
	 * System.out.println("Serveur Recu : " + ligne);
	 * System.out.println("Serveur Envoyer : " + val); out.println(val);
	 * out.flush(); ligne = in.readLine(); } System.out.println("Bye !");
	 * 
	 * } catch (IOException e) { s.close(); } } }
	 */
}

package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTCP {
	final static int PORT = 8888;
	 Socket s;
	 InputStream in;
	 OutputStream out;
	 BufferedReader reader;
	 PrintWriter writer;

	public ClientTCP() {

	}

	public  void EnvoieRequete(String requete) {
		System.out.println("envoyer le requete  " + requete+"\n");
		writer.print(requete);
		System.out.println("requte envoyer");
		writer.flush();
		System.out.println("flush");
	}

	public  String ReponseRequete() {
		System.out.println("reponse requete");
		try {
			String reponse = reader.readLine();
			System.out.println("reponse "+ reponse);
			return reponse;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public  boolean OuvrirSocket() {
		System.out.println("Ouvrir socket");
		try {
			s = new Socket("localhost", PORT);
			System.out.println("s");
			in = s.getInputStream();
			System.out.println("in");
			out = s.getOutputStream();
			System.out.println("out");
			reader = new BufferedReader(new InputStreamReader(in));
			System.out.println("reader");
			writer = new PrintWriter(out);
			System.out.println("writer");
			return true;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public  void FermerSocket() {
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public static void main(String[] args) throws IOException {
		ClientTCP client = new ClientTCP();
		client.OuvrirSocket();
		client.EnvoieRequete("test|test|test\n");
		System.out.println("reponse du serveur " + client.ReponseRequete());
		client.FermerSocket();
	}
	
	
	/*
	public static void main(String[] args) throws IOException {
		final int PORT = 8888;
		Socket s = new Socket("localhost", PORT);
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		PrintWriter writer = new PrintWriter(out);
		
		
		String commande  = "5\n";
		System.out.println("Envoi : "+commande);
		writer.print(commande);
		writer.flush();
		String reponse = reader.readLine();
		System.out.println("Recu : "+reponse);
		commande = "xyz\n";
		System.out.println("Envoi : "+commande);
		writer.print(commande);
		writer.flush();
		s.close();
	}
*/
}

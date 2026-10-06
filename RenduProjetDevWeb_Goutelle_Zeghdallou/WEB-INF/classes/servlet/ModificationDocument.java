package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serveur.BDD;
import serveur.DocumentTexte;
import serveur.Utilisateur;

/**
 * Servlet implementation class ModificationDocument
 */
@WebServlet("/ModificationDocument")
public class ModificationDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificationDocument() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Je modifie le document");
		HttpSession session = request.getSession();
		
		System.out.println("session recuperer");

		Utilisateur ut = (Utilisateur) session.getAttribute("utilisateur");
		System.out.println("utilisateur recuperer");
		
		String texteDoc = request.getParameter("texteDocument");
		System.out.println("texte recuperer"+texteDoc);

		System.out.println("getNom " + ut.getDocument().getNom() );
		System.out.println("getCreateur " + ut.getDocument().getCreateur() );

		BDD.mdofiDocument(ut.getDocument().getNom(), ut.getDocument().getCreateur(), texteDoc);
response.sendRedirect("Document");
	}

}

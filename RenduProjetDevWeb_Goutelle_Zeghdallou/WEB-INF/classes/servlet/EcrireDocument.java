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
 * Servlet implementation class EcrireDocument
 */
@WebServlet("/EcrireDocument")
public class EcrireDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EcrireDocument() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur ut = (Utilisateur) session.getAttribute("utilisateur");
		if (ut.getDocument() != null) {
			DocumentTexte doc;
			doc = BDD.afficheDocument(ut.getIdPseudo(), ut.getDocument().getNom(), ut.getDocument().getCreateur(),ut.getDocument().getIsPublic());
			String toSend = doc.getTexte();
			response.getOutputStream().write(toSend.getBytes());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur ut = (Utilisateur) session.getAttribute("utilisateur");
		String texteDoc = request.getParameter("texteDocument");
		BDD.mdofiDocument(ut.getDocument().getNom(), ut.getDocument().getCreateur(), texteDoc);
	}

}

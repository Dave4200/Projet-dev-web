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
 * Servlet implementation class Document
 */
@WebServlet("/Document")
public class Document extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Document() {
		super();
		// TODO Auto-generated constructor stub
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
			doc = BDD.afficheDocument(ut.getIdPseudo(), ut.getDocument().getNom(), ut.getDocument().getCreateur(),
					ut.getDocument().getIsPublic());
			ut.setDocument(doc);
			session.setAttribute("utilisateur", ut);
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/document.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur ut = (Utilisateur) session.getAttribute("utilisateur");
		DocumentTexte doc;
		String nomDoc = request.getParameter("nomDocu");
		String nomCrea = request.getParameter("nomCrea");
		String estPublic = request.getParameter("isPublic");
		Boolean ispublic = false;
		if (estPublic.equals("true")) {
			ispublic = true;
		}
		System.out.println("EST PUBLIC "+estPublic + "  " + ispublic);
		doc = BDD.afficheDocument(ut.getIdPseudo(), nomDoc, nomCrea, ispublic);
		ut.setDocument(doc);
		session.setAttribute("utilisateur", ut);
		this.getServletContext().getRequestDispatcher("/WEB-INF/document.jsp").forward(request, response);

	}

}

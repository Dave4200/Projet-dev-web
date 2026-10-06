package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serveur.BDD;
import serveur.DocumentTexte;
import serveur.Message;
import serveur.Utilisateur;

/**
 * Servlet implementation class TexteTchat
 */
@WebServlet("/TexteTchat")
public class TexteTchat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TexteTchat() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		Utilisateur ut = (Utilisateur) session.getAttribute("utilisateur");

		if (ut.getDocument() != null) {

			ArrayList<Message> list = new ArrayList<>();
			list = BDD.afficheMessage(ut.getDocument().getNom(), ut.getDocument().getCreateur());
			ut.getDocument().setListMessage(list);
			session.setAttribute("utilisateur", ut);
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/textTchat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

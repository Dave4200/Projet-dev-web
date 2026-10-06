package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serveur.BDD;
import serveur.Message;
import serveur.Utilisateur;

/**
 * Servlet implementation class EnvoyerMessage
 */
@WebServlet("/EnvoyerMessage")
public class EnvoyerMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnvoyerMessage() {
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
		HttpSession session = request.getSession(true);
		Utilisateur ut = (Utilisateur) session.getAttribute("utilisateur");
		Message message = new Message(ut.getIdPseudo(), request.getParameter("msg"));
		BDD.EnvoyerMessage(ut.getIdPseudo(), ut.getDocument().getNom(), ut.getDocument().getCreateur(),
				message.getTexte(), message.getDate());

		response.sendRedirect("TexteTchat");
	}

}

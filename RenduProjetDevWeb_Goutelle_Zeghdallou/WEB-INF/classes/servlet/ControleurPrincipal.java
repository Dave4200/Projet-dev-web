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
import socket.ServeurTCP;

/**
 * Servlet implementation class ControleurPrincipal
 */
@WebServlet("/index")
public class ControleurPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BDD bdd;
	ArrayList<HttpSession> listSession;
	ServeurTCP serveur;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControleurPrincipal() {
		super();
		this.bdd = new BDD();
		if (!bdd.ConnectionBDD()) {

		}
		this.listSession = new ArrayList<>();
		serveur = new ServeurTCP();
		Thread t = new Thread(serveur);
		t.start();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.sendRedirect("/WEB-INF/index.jsp");
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

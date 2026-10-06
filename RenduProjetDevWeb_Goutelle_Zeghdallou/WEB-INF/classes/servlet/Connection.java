package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import serveur.BDD;
import serveur.Utilisateur;

/**
 * Servlet implementation class Connection
 */
@WebServlet("/Connection")
public class Connection extends ControleurPrincipal {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");
		
		if(BDD.seConnecter(pseudo, mdp)){
			Utilisateur utilisateur =  new Utilisateur(pseudo);
			request.getSession(true).setAttribute("utilisateur",utilisateur);
			request.getSession(false).setMaxInactiveInterval(100000);
			listSession.add(request.getSession());
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
			
		}else {
			request.getSession().setAttribute("erreurLogin", "vrai");
			response.sendRedirect("/ProjetDevWeb/Connection");
		}
		
	
	}

}

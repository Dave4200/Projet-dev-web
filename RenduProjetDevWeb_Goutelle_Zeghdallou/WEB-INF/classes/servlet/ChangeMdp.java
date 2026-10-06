package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serveur.BDD;
import serveur.Utilisateur;

/**
 * Servlet implementation class ChangeMdp
 */
@WebServlet("/ChangeMdp")
public class ChangeMdp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeMdp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Debut changement de mot de passe");
		HttpSession session = request.getSession(true);
		Utilisateur ut = (Utilisateur)session.getAttribute("utilisateur");
		
		String mdp = request.getParameter("mdp");
		String nouveauMdp = request.getParameter("nouveauMdp");
		
		BDD.ChangeMotDePasse(ut.getIdPseudo(),mdp,nouveauMdp);
		System.out.println("Fin changement de mot de passe");

		this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
	}

}

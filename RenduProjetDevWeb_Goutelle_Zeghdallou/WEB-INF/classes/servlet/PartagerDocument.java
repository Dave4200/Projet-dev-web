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
 * Servlet implementation class PartagerDocument
 */
@WebServlet("/PartagerDocument")
public class PartagerDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartagerDocument() {
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
		System.out.println("Debut partage document");
		HttpSession session = request.getSession(true);
		Utilisateur ut = (Utilisateur)session.getAttribute("utilisateur");
		String pseudoPartage = request.getParameter("pseudoPartage");
		String lS = request.getParameter("lectureSeul");
		Boolean lectureSeul;
		if(lS != null) {
			lectureSeul = true;
		}else {
			lectureSeul = false;
		}
		BDD.partagerDocument(pseudoPartage, ut.getDocument().getNom(), ut.getDocument().getCreateur(), lectureSeul);
		System.out.println("Fin partage document");

	}

}

package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xpath.internal.operations.Bool;

import serveur.BDD;
import serveur.Utilisateur;

/**
 * Servlet implementation class NouveauDocument
 */
@WebServlet("/NouveauDocument")
public class NouveauDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NouveauDocument() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/nouveauDocument.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomDoc = request.getParameter("nomDocument");
		String publ = request.getParameter("isPublic");
		String lect = request.getParameter("lectureSeul");
		String prot = request.getParameter("proteger");
		String mdp = request.getParameter("mdp");
		//verif le nom

		HttpSession session = request.getSession();
		Utilisateur ut = (Utilisateur) session.getAttribute("utilisateur");
		String createur = ut.getIdPseudo();

		Boolean ispublic;
		Boolean proteger;
		Boolean lectureSeul;

		if (lect != null) {
			lectureSeul = true;
		} else {
			lectureSeul = false;
		}

		if (publ != null) {
			ispublic = true;
		} else {
			ispublic = false;
		}

		if (prot != null) {
			proteger = true;
		} else {
			proteger = false;
			mdp = "";
		}

		BDD.creerDocument(nomDoc, mdp, createur, ispublic, proteger, lectureSeul);

		response.sendRedirect("ListeMesDocument");
	}

}

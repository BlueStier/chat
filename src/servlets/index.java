package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Md5;
import model.Users;

import java.util.ArrayList;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp1");
		String pseudo2 = request.getParameter("pseudo2");
		String mdp2 = request.getParameter("mdp2");
		String cmdp = request.getParameter("Cmdp");
		RequestDispatcher rd;
		String msg_remplir_champs_connexion = "Veuillez remplir tous les champs pour vous connecter";
		String msg_remplir_champs_creer = "Veuillez remplir tous les champs pour creer le compte";
		String msg_mdp_diff = "les 2 mots de passes ne sont pas identiques";
		String pseudo_existe = "Ce pseudo est déjà existant choisissez en un autre";
		String mdp_hs = "Pseudo ou mot de passe erronée";

		if (request.getParameter("connexion") != null) {
			if (pseudo.isEmpty() || pseudo.trim().equals("") || mdp.isEmpty() || mdp.trim().equals("")) {
				rd = getServletContext().getRequestDispatcher("/Acceuil.jsp");
				request.setAttribute("con", msg_remplir_champs_connexion);
				rd.forward(request, response);
			} else {
				Users c = new Users(pseudo);
				try {
					ArrayList<String> liste = c.verif_mdp(pseudo, "utilisateurs");
					if (liste.size() != 0) {
						String verif_mdp = Md5.encode(mdp);

						if (verif_mdp.equals(liste.get(1))) {
							c.updateConnect(pseudo, 1);
							response.sendRedirect(request.getContextPath() + "/Choix.jsp");
							HttpSession session = request.getSession();
							session.setAttribute("pseudo", pseudo);
						}

						else {
							rd = getServletContext().getRequestDispatcher("/Acceuil.jsp");
							request.setAttribute("erreur", mdp_hs);
							rd.forward(request, response);
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (request.getParameter("creer") != null) {
			if (pseudo2.isEmpty() || pseudo2.trim().equals("") || mdp2.isEmpty() || mdp2.trim().equals("")
					|| cmdp.isEmpty() || cmdp.trim().equals("")) {
				rd = getServletContext().getRequestDispatcher("/Acceuil.jsp");
				request.setAttribute("creer", msg_remplir_champs_creer);
				rd.forward(request, response);
			}
			if (!mdp2.equals(cmdp)) {
				rd = getServletContext().getRequestDispatcher("/Acceuil.jsp");
				request.setAttribute("mdp", msg_mdp_diff);
				rd.forward(request, response);
			} else {
				Users u = new Users(pseudo2);
				try {
					boolean exist_or_not = u.creer(pseudo2, mdp2);
					if (exist_or_not) {
						response.sendRedirect(request.getContextPath() + "/Choix.jsp");
						HttpSession session = request.getSession();
						session.setAttribute("pseudo", pseudo2);

					} else {
						rd = getServletContext().getRequestDispatcher("/Acceuil.jsp");
						request.setAttribute("existe", pseudo_existe);
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

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

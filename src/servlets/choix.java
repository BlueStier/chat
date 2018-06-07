package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Users;

/**
 * Servlet implementation class choix
 */
@WebServlet("/choix")
public class choix extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public choix() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String game = request.getParameter("game");
		String prog = request.getParameter("prog");
		String sport = request.getParameter("sport");
		String sante = request.getParameter("sante");
		String peche = request.getParameter("peche");
		String decon = request.getParameter("Dec");
		
		HttpSession session = request.getSession();		
		String pseudo = (String) session.getAttribute("pseudo");
		
		Users c = new Users(pseudo);
		
		
		if (game != null) {
			String str = game.toLowerCase()+"instant";			
			
			try {
				c.insert_bddInstant(pseudo, str);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect( request.getContextPath() + "/salon.jsp");			
			session.setAttribute( "salon", game );
		}
		if (prog != null) {
			String str = prog.toLowerCase()+"instant";			
			
			try {
				c.insert_bddInstant(pseudo, str);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect( request.getContextPath() + "/salon.jsp");			
			session.setAttribute( "salon", prog);
		}
		if (sport != null) {
			String str = sport.toLowerCase()+"instant";
			
			try {
				c.insert_bddInstant(pseudo, str);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect( request.getContextPath() + "/salon.jsp");			
			session.setAttribute( "salon", sport );
		}
		if (sante != null) {
			String str = sante.toLowerCase()+"instant";			
			
			try {
				c.insert_bddInstant(pseudo, str);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect( request.getContextPath() + "/salon.jsp");			
			session.setAttribute( "salon", sante );
		}
		if (peche != null) {
			String str = peche.toLowerCase()+"instant";			
			
			try {
				c.insert_bddInstant(pseudo, str);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect( request.getContextPath() + "/salon.jsp");
			session.setAttribute( "salon", peche );
		}
		if (decon != null) {
			
			try {
				c.updateConnect(pseudo, 0);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect( request.getContextPath() + "/Acceuil.jsp");
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

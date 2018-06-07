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

import model.Utilisateurs;

/**
 * Servlet implementation class refresh_user
 */
@WebServlet("/refresh_user")
public class refresh_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public refresh_user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//String salon = (String)session.getAttribute("salon")+"instant";
		session.setAttribute("ujour", "alorsa");
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher("/WEB-INF/maju.jsp");
//		String salon_instant = salon.toLowerCase();
//		String users_a_jour;
//		Utilisateurs u = new Utilisateurs();
//		try {
//			users_a_jour = u.get_users(salon_instant);
//			session.setAttribute("ujour", "alorsa");
//			RequestDispatcher rd;
//			rd = getServletContext().getRequestDispatcher("/WEB-INF/maju.jsp");
//			rd.forward(request, response);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

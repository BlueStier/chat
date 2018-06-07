package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Message;

/**
 * Servlet implementation class refresh_message
 */
@WebServlet("/refresh_message")
public class refresh_message extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public refresh_message() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session = request.getSession();
		String salon = (String)session.getAttribute("salon");		
		Message message = new Message(salon.toLowerCase());
		String message_a_jour;
		try {
			message_a_jour = message.get_message((String)session.getAttribute("pseudo"));
			session.setAttribute("messajour", message_a_jour);
			RequestDispatcher rd;
			rd = getServletContext().getRequestDispatcher("/WEB-INF/majmess.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		try {
//			String message_a_jour=message.get_message((String)session.getAttribute("pseudo"));			
//			RequestDispatcher rd;			
//			session.setAttribute("messajour", message_a_jour);
//			rd = getServletContext().getRequestDispatcher("/WEB-INF/majmess.jsp");
//			rd.forward(request, response);
//		} catch (SQLException e) {			
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

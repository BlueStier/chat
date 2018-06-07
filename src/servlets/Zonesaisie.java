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

import model.InsertMessage;

/**
 * Servlet implementation class Zonesaisie
 */
@WebServlet("/Zonesaisie")
public class Zonesaisie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Zonesaisie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String message = request.getParameter("text");
		String pseudo = (String) session.getAttribute("pseudo");
		String public_or_not = (String) session.getAttribute("user");
		String base = session.getAttribute("salon").toString().toLowerCase();
		int pub;
		int priv;
		String des = "";
		if (public_or_not.equals("public")) {
			pub = 1;
			priv = 0;
		} else {
			pub = 0;
			priv = 1;
			des = (String) session.getAttribute("user");
		}
		InsertMessage inject = new InsertMessage();
		try {
			inject.go(base, pseudo, message, priv, pub, des);
			session.setAttribute("user","public");
			RequestDispatcher rd;
			rd = getServletContext().getRequestDispatcher("/salon.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

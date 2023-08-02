package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class general
 */
@WebServlet("/general")
public class general extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public general() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		switch(action){
		case "login":
			request.getRequestDispatcher("login.jsp").forward(request,response);
			break;
		case "blog":
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		case "signup":
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		default:
			break;
		
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id=0;
		if (request.getParameter("id") == null) {
			response.sendRedirect(request.getContextPath()+"/general?action=signup&error=invalid-id");
	    	
	    }
	    try {
	    	id=Integer.parseInt(request.getParameter("id"));
	    } catch (NumberFormatException nfe) {
	    	response.sendRedirect(request.getContextPath()+"/general?action=signup&error=invalid-id");
	    }
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/study_easy","root","1234");
		
		PreparedStatement stmt1=con.prepareStatement("insert into users values(?,?,?,?);");
		stmt1.setInt(1, Integer.parseInt(password));
    	stmt1.setString(2,username);
    	stmt1.setString(3,email);
    	stmt1.setInt(4, Integer.parseInt(password));
    	stmt1.execute();
   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
		
		
	}

}

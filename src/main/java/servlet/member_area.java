package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class member_area
 */
@WebServlet("/member_area")
public class member_area extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public member_area() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("loggedin")==null) {
				System.out.println("t");
				response.sendRedirect(request.getContextPath()+"/general?action=login&error=loginplease");
				
				
		}
		else {
		System.out.println("1");
		String action=request.getParameter("action");
		switch(action){
		case "logout":
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/general?action=login");
			break;
		case "welcome":
			System.out.println("2");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
			System.out.println("3");
			break;
		default:
			break;
		
		}
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("1");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("2");
	
    	try {
    		System.out.println("3");
    		
			Connection connect=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/study_easy","root","1234");
			
			System.out.println("4");
	    	
	    	PreparedStatement stmt1=connect.prepareStatement("select count(*) as c from users where username=? and password=?;");
	    	stmt1.setString(1,username);
	    	stmt1.setInt(2, Integer.parseInt(password));
	    	out.print(stmt1);
	    	
	    	out.println("5");
	    	
	    	ResultSet rs=stmt1.executeQuery();
	    	out.println("6");
	    	rs.next();
	    	out.println(rs.getInt("c"));
	    	out.println("7");
	    	if (rs.getInt("c")>0) {
	    		out.println("7");
	    		request.getSession().invalidate();
				HttpSession newSession=request.getSession(true);
				newSession.setAttribute("username", username);
				newSession.setAttribute("loggedin",true);
				newSession.setMaxInactiveInterval(300);
				response.sendRedirect(request.getContextPath()+"/member_area?action=welcome");
	      }
	    	else {
	    		PreparedStatement stmt2=connect.prepareStatement("select count(*) from users where username=? ;");
		    	stmt2.setString(1,username);
		    	out.println("6");
		    	ResultSet rs2=stmt2.executeQuery();
		    	rs2.next();
		    	if (rs2.getInt("count(*)")!=0) {
	    		System.out.println("8");
	    		response.sendRedirect(request.getContextPath()+"/general?action=login&error=wrong+password");
		    	}
	    	    else {
	    		System.out.println("9");
	    		response.sendRedirect(request.getContextPath()+"/general?action=login&error=wrong+username");
	    	}
	    	}
	    	
	    	
	    	
	    	
	    	
	    	//step4 : process the result set
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} 
		
		
		
//		if (username.equals("sarthak") && password.equals("1234")) {
//			request.getSession().invalidate();
//			HttpSession newSession=request.getSession(true);
//			newSession.setAttribute("username", username);
//			newSession.setAttribute("loggedin",true);
//			newSession.setMaxInactiveInterval(300);
//			
//			response.sendRedirect(encode+"/member_area?action=welcome");
//			
//			
//		}
//		else if (!username.equals("sarthak")) {
//			
//			response.sendRedirect(request.getContextPath()+"/general?action=login&error=wrong+username");
//		}
//		else  if (!password.equals("1234")){
//			response.sendRedirect(request.getContextPath()+"/general?action=login&error=w+password");
//		}
//		else {
//			response.sendRedirect(request.getContextPath()+"/general?action=login&error=w+username+w+password");
//			
//		}
	}
	

}

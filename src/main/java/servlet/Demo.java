package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import jakarta.annotation.Resource;

/**
 * Servlet implementation class Demo
 */
@WebServlet("/Demo")
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
//    @Resource(name="jdbc/project")
//    private DataSource dataSource;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	PrintWriter out=response.getWriter();
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver.class");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Connection connect=null;
    	Statement stmt=  null;
    	ResultSet rs=null;
    	
    	try {
    		
			connect=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/study_easy","root","1234");
			//step2 : create a sql statements string
	    	String query="select * from users"; 
	    	// step3 : create a sql query
	    	stmt=connect.createStatement();
	    	rs=stmt.executeQuery(query); 
	    	while(rs.next()) {
	    		out.println("<br>"+rs.getString("email"));
	    		
	    		
	    	}
	    	//step4 : process the result set
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
    	
    	
    	//step2 : create a sql statements string
    	
    	// step3 : create a sql query
    	//step4 : process the result set
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}

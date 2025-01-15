package login_pk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginprogress
 */
@WebServlet("/loginprogress")
public class loginprogress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginprogress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String a1 = request.getParameter("un");
		pw.print("<h3>"+a1+"</h3>");
		String a2 = request.getParameter("pw");
		pw.print("<h3>"+a2+"</h3>");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerinfo","root","");
			String sql = "select * from insert_data where USERNAME= ? and PASSWORD= ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,a1);
			ps.setString(2,a2);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				response.sendRedirect("loginsuccess.jsp");
			}
			else
			{
				response.sendRedirect("loginfail.jsp");
			}
		 
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}

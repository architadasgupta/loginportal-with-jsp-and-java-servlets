package registrationn_pk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public registration() {
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
		String a1 = request.getParameter("na");
		pw.print("<h3>"+a1+"</h3>");
		String a2 = request.getParameter("ad");
		pw.print("<h3>"+a2+"</h3>");
		String a33 = request.getParameter("ph");
		long a3=Long.parseLong(a33);
		pw.print("<h3>"+a3+"</h3>");
		String a4 = request.getParameter("un");
		pw.print("<h3>"+a4+"</h3>");
		String a5 = request.getParameter("pw");
		pw.print("<h3>"+a5+"</h3>");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerinfo","root","");
			String sql = "insert into insert_data values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,a1);
			ps.setString(2,a2);
			ps.setLong(3,a3);
			ps.setString(4,a4);
			ps.setString(5,a5);
			
			int x =ps.executeUpdate();
			System.out.println(x);
			if(x>0)
			{
				response.sendRedirect("login.jsp");
			}
			else
			{
				response.sendRedirect("registrationfail.jsp");
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}

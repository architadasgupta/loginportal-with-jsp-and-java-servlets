package passwordck_pk;

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class passwordcheck
 */
@WebServlet("/passwordcheck")
public class passwordcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public passwordcheck() {
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
		String a4 = request.getParameter("un");
		pw.print("<h3>"+a4+"</h3>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerinfo","root","");
			String sql = "select * from insert_data where USERNAME= ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,a4);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				HttpSession sess = request.getSession();
				sess.setAttribute("user", a4);
				response.sendRedirect("useridmatch.jsp");
			}
			else
			{
				response.sendRedirect("useridfail.jsp");
			}
		 
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}

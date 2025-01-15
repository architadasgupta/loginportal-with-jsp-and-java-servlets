package passwordupdate_pk;

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class pwdchnsuccessupdate
 */
@WebServlet("/pwdchnsuccessupdate")
public class pwdchnsuccessupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pwdchnsuccessupdate() {
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
        pw.print("<h3>" + a1 + "</h3>");
        String a2 = request.getParameter("pw");
        pw.print("<h3>" + a2 + "</h3>");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerinfo","root","");
            String sql = "update insert_data set PASSWORD=? where USERNAME=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a2);
            ps.setString(2, a1);
            int x = ps.executeUpdate();
            if(x>0)
    		{
    			response.sendRedirect("pwdchnsuccess.jsp");
    			
    		}
    		else
    		{
    			response.sendRedirect("useridmatch.jsp");
    		}

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}

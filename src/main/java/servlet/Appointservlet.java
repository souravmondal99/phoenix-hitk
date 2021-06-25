

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
 * Servlet implementation class Appointservlet
 */
@WebServlet("/Appointservlet")
public class Appointservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Appointservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String pn=request.getParameter("patientname");
		String phn=request.getParameter("contact");
		String apfor=request.getParameter("appoint");
		String dname="Dr. Rajiv Bajaj";
		String doa=request.getParameter("doa");
		String toa=request.getParameter("time");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","MYDB","admin");
				if(con==null)
					out.println("connect not created");
				else
				{
					System.out.println("connection created");
					PreparedStatement ps=con.prepareStatement("INSERT INTO APPOINT VALUES (?,?,?,?,?,?)");
					ps.setString(1, pn);
					ps.setString(2, phn);
					ps.setString(3, apfor);
					ps.setString(4, dname);
					ps.setString(5, doa);
					ps.setString(6, toa);
					int x=ps.executeUpdate();
					if(x>0)
						response.sendRedirect("BookingConfirm.jsp");
					else
						
						out.println("no record inserted!");
				}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}

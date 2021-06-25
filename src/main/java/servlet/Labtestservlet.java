

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
 * Servlet implementation class Labtestservlet
 */
@WebServlet("/Labtestservlet")
public class Labtestservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Labtestservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String nm=request.getParameter("nm");
		String phn=request.getParameter("phn");
		String dr=request.getParameter("dr");
		String date=request.getParameter("date");
		String lab=request.getParameter("lab");
		String test=request.getParameter("tst1");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","MYDB","admin");
				if(con==null)
					out.println("connect not created");
				else
				{
					System.out.println("connection created");
					PreparedStatement ps=con.prepareStatement("INSERT INTO LABTEST VALUES (?,?,?,?,?,?)");
					ps.setString(1, nm);
					ps.setString(2, phn);
					ps.setString(3, dr);
					ps.setString(4, date);
					ps.setString(5, lab);
					ps.setString(6, test);
					int x=ps.executeUpdate();
					if(x>0)
						response.sendRedirect("Testbook.jsp");
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



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
 * Servlet implementation class Nurseservlet
 */
@WebServlet("/Nurseservlet")
public class Nurseservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nurseservlet() {
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
		String pn=request.getParameter("nm");
		String phn=request.getParameter("phn");
		String ad=request.getParameter("add");
		String nur=request.getParameter("nur");
		String dis=request.getParameter("dis");
		String tim=request.getParameter("t1");
		try
		{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","MYDB","admin");
			String connectionUrl = System.getenv("JDBC_DATABASE_URL");
			Connection con=DriverManager.getConnection(connectionUrl);
			if(con==null)
					out.println("connect not created");
				else
				{
					System.out.println("connection created");
					PreparedStatement ps=con.prepareStatement("INSERT INTO NURSEBOOK VALUES (?,?,?,?,?,?)");
					ps.setString(1, pn);
					ps.setString(2, phn);
					ps.setString(3, ad);
					ps.setString(4, nur);
					ps.setString(5, dis);
					ps.setString(6, tim);
					int x=ps.executeUpdate();
					if(x>0)
						response.sendRedirect("Nurseconfirm.jsp");
					else
						
						out.println("no record inserted!");
				}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}

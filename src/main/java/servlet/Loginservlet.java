

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Loginservlet() {
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
		String uid=request.getParameter("t1");
		String pass=request.getParameter("t2");
		RequestDispatcher rd=null;
		//HttpSession hs=request.getSession(true);
		//ServletContext sc=getServletContext();
		try
		{
			//String connectionUrl = "jdbc:sqlserver://HYL-777749\\SQL2K2019DEV:1433;databaseName=MYDB;user=hsi;password=wstinol";
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","MYDB","admin");
			//Connection con=DriverManager.getConnection(connectionUrl);
				if(con==null)
					out.println("connect not created");
				else
				{
					System.out.println("connection created");
					PreparedStatement ps=con.prepareStatement("SELECT * FROM P_USER WHERE USERID=? AND PASS=?");
					ps.setString(1, uid);
					ps.setString(2, pass);
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{
						response.sendRedirect("MainMenu.html");
					}
					else
					{
						rd=request.getRequestDispatcher("login.jsp");
						request.setAttribute("errorMessage", "Sorry UserName or Password Error!");  
					}
					rd.forward(request, response);
				}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}

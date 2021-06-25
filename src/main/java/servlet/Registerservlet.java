

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
 * Servlet implementation class Registerservlet
 */
@WebServlet("/Registerservlet")
public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Registerservlet() {
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
		String fn=request.getParameter("fn");
		String ln=request.getParameter("ln");
		String dob=request.getParameter("dob");
		String phn=request.getParameter("phn");
		String uid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		String gen=request.getParameter("radiogroup1");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","MYDB","admin");
				if(con==null)
					out.println("connect not created");
				else
				{
					System.out.println("connection created");
					PreparedStatement ps=con.prepareStatement("INSERT INTO P_USER VALUES (?,?,?,?,?,?,?)");
					ps.setString(1, fn);
					ps.setString(2, ln);
					ps.setString(3, dob);
					ps.setString(4, phn);
					ps.setString(5, uid);
					ps.setString(6, pass);
					ps.setString(7, gen);
					int x=ps.executeUpdate();
					if(x>0)
						out.println("<!DOCTYPE html>\r\n" + 
								"<html>\r\n" + 
								"\r\n" + 
								"<head>\r\n" + 
								"    <title>Registration Page</title>\r\n" + 
								"    <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\r\n" + 
								"    <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\r\n" + 
								"    <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n" + 
								"\r\n" + 
								"\r\n" + 
								"    <!--Bootsrap 4 CDN-->\r\n" + 
								"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\"\r\n" + 
								"        integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\r\n" + 
								"\r\n" + 
								"    <!--Fontawesome CDN-->\r\n" + 
								"    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\"\r\n" + 
								"        integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">\r\n" + 
								"\r\n" + 
								"    <!--Custom styles-->\r\n" + 
								"    <link rel=\"stylesheet\" type=\"text/css\" href=\"registration.css\">\r\n" + 
								"    <link rel=\"stylesheet\" href=\"mainmenu.css\">\r\n" + 
								"</head>\r\n" + 
								"\r\n" + 
								"<body>\r\n"
								+ "<script>\r\n" + 
								"  alert(\"Account Created Successfully!\");\r\n" + 
								"</script>" + 
								"    <div class=\"nav\">\r\n" + 
								"        <div class=\"logo\">\r\n" + 
								"            <h4>Phoenix HealthCare</h4>\r\n" + 
								"        </div>\r\n" + 
								"        <div class=\"links\">\r\n" + 
								"            <a href=\"#\" class=\"mainlink\">Covid-19 Updates</a>\r\n" + 
								"            <a href=\"#\">Help</a>\r\n" + 
								"            <a href=\"#\">About</a>\r\n" + 
								"            <a href=\"#\">Contact Us</a>\r\n" + 
								"        </div>\r\n" + 
								"    </div>\r\n" + 
								"    <div class=\"wrapper\" style=\"box-shadow: 4px 30px 50px rgba(0, 0, 0, 0.1);\">\r\n" + 
								"        <h2>\r\n" + 
								"            Patient Registration Form</h2>\r\n" + 
								"        <div class=\" form-conteniar\">\r\n" + 
								"            <form method=\"post\" action=\"Registerservlet\">\r\n" + 
								"                <div class=\"input-name\">\r\n" + 
								"                    <i class=\"fa fa-user lock\"></i>\r\n" + 
								"                    <input type=\"text\" name=\"fn\" placeholder=\"First Name\" class=\"name\">\r\n" + 
								"                    <span class=\"last\">\r\n" + 
								"                        <i class=\"fa fa-user lock\"></i>\r\n" + 
								"                        <input type=\"text\" name=\"ln\" placeholder=\"Last Name\" class=\"name\">\r\n" + 
								"                    </span>\r\n" + 
								"                </div>\r\n" + 
								"\r\n" + 
								"                <div class=\"input-name\">\r\n" + 
								"                    <p>Date of Birth :</p>\r\n" + 
								"                    <i class=\"fa fa-calendar email\"></i>\r\n" + 
								"                    <input type=\"text\" name=\"dob\" placeholder=\"Date of Birth\" required class=\"text-name\">\r\n" + 
								"                </div>\r\n" + 
								"                <div class=\"input-name\">\r\n" + 
								"                    <i class=\"fa fa-phone email\"></i>\r\n" + 
								"                    <input type=\"text\" name=\"phn\" placeholder=\"Contact No.\" required class=\"text-name\">\r\n" + 
								"                </div>\r\n" + 
								"                <div class=\"input-name\">\r\n" + 
								"                    <i class=\"fa fa-user email\"></i>\r\n" + 
								"                    <input type=\"text\" name=\"uid\" placeholder=\"Username\" required class=\"text-name\">\r\n" + 
								"                </div>\r\n" + 
								"                <div class=\"input-name\">\r\n" + 
								"                    <i class=\"fa fa-lock lock\"></i>\r\n" + 
								"                    <input type=\"password\" name=\"pass\" placeholder=\"Password\" class=\"text-name\">\r\n" + 
								"                </div>\r\n" + 
								"                <div class=\"input-name\">\r\n" + 
								"                    <i class=\"fa fa-lock lock\"></i>\r\n" + 
								"                    <input type=\"password\" placeholder=\"Re-type Password\" class=\"text-name\">\r\n" + 
								"                </div>\r\n" + 
								"                <div class=\"input-name\">\r\n" + 
								"                    <p>Gender :</p>\r\n" + 
								"                    <input type=\"radio\" name=\"radiogroup1\" id=\"ravi\" value=\"male\" class=\"radio-button\">\r\n" + 
								"                    <label for=\"ravi\" class=\"gender\">Male</label>\r\n" + 
								"                    <input type=\"radio\" name=\"radiogroup1\" id=\"ravi1\" value=\"female\" class=\"radio-button\">\r\n" + 
								"                    <label for=\"ravi1\" class=\"gender\">Female</label>\r\n" + 
								"                    <input type=\"radio\" name=\"radiogroup1\" id=\"ravi1\" value=\"other\" class=\"radio-button\">\r\n" + 
								"                    <label for=\"ravi1\" class=\"gender\">Others</label>\r\n" + 
								"                </div>\r\n" + 
								"                <div class=\"form-group\">\r\n" + 
								"\r\n" + 
								"                    <input type=\"button\" onclick=\"location.href='index.html';\" value=\"Go Back\" class=\"btn login_btn\"\r\n" + 
								"                        style=\"\r\n" + 
								"            margin-right: 10px;\">\r\n" + 
								"                    <input type=\"submit\" value=\"Sign up\" class=\"btn float-right login_btn\">\r\n" + 
								"                </div>\r\n" + 
								"\r\n" + 
								"                <div class=\"d-flex justify-content-center links\">\r\n" + 
								"                    Existing User ?<a href=\"login.jsp\">Login</a>\r\n" + 
								"                </div>\r\n" + 
								"            </form>\r\n" + 
								"        </div>\r\n" + 
								"    </div>\r\n" + 
								"\r\n" + 
								"\r\n" + 
								"</body>\r\n" + 
								"\r\n" + 
								"</html>");
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

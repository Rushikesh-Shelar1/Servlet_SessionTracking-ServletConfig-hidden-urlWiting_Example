package contoller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CheckBalanceServlet
 */
@WebServlet("/checkbal")
public class CheckBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBalanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//fetching all cookie from request object or request header
		Cookie[] cookie=request.getCookies();
		
		//Iterating each cookie
		for(Cookie ck:cookie) {
			String name=ck.getName();
			String value=ck.getValue();
			if(name.equals("UserCookie")) {
				out.println("hello"+" "+value);
				out.println("using your user name we will fetching your account balance");
				break;
				
			}
		}
		out.println("<h1><font color='blue'>if you want to continue then vist customer profile</font></h1>");
		out.println("<a href='UserProfile.html'>Click here ....to go Menu</a><br>");
		out.println("<a href='logout'>click here to logout...</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

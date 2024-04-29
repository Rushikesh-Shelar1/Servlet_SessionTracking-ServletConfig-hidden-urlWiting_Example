package contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CookieCreater
 */
@WebServlet("/cookie1")
public class CookieCreater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieCreater() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//fetching the request parameter fro html input element
		String userName=request.getParameter("t1");
		//creating cookie object
		//creating cookie btb setting name of the cookie as "un"
		//the value of cookie is userName(which reading from html)
		
		Cookie ck =new Cookie("un",userName);
		//setting the age of cookie
		//the cookie age is 24 hrs
		ck.setMaxAge(24*60*60);
		//binding cookie with response header of Http protocol
		//void addCookie(Cookie object)
		response.addCookie(ck);
		
		PrintWriter writer =response.getWriter();
		writer.println("cookie created succeefully");
		RequestDispatcher rd=request.getRequestDispatcher("Input.html");
		rd.include(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

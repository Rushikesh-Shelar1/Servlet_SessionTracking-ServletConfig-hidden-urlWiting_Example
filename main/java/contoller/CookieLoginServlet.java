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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Servlet implementation class CookieLoginServlet
 */
@WebServlet("/loginCookie")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//getting the object of PrintWriter
		PrintWriter out=response.getWriter();
		//reading inputs from html input elements
		String userName=request.getParameter("un");
		String password =request.getParameter("pass");
		
		List<String> listOfUserName=new ArrayList();
		listOfUserName.add("ravi");
		listOfUserName.add("abc");
		listOfUserName.add("xyz");
		
		List<String> listOfPassword=new ArrayList();
		listOfPassword.add("ravi@123");
		listOfPassword.add("abc@123");
		listOfPassword.add("xyz@123");
		
		//creating object of Iterator
		Iterator<String> itr1=listOfUserName.iterator();
		Iterator<String> itr2=listOfPassword.iterator();
		
		int flag=0;
		while(itr1.hasNext()&&itr2.hasNext()) {
			String name=itr1.next();
			String pass=itr2.next();

			if(name.equalsIgnoreCase(userName)&& pass.equals(password)) {
				flag=1;
				break;
			}
			
		}
		if(flag==1) {
			Cookie userCookie=new Cookie("UserCookie",userName);
			Cookie passCookie=new Cookie("PassCookie",password);
			userCookie.setMaxAge(24*60*60);
			passCookie.setMaxAge(24*60*60);
			response.addCookie(userCookie);
			response.addCookie(passCookie);
			RequestDispatcher rd=request.getRequestDispatcher("UserProfile.html");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

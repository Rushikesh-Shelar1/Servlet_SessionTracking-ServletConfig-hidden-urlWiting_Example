package contoller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;

/**
 * Servlet implementation class SecondSession
 */
@WebServlet("/session2")
public class SecondSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondSession() {
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
		//getting the object of session
		HttpSession oldSession =request.getSession(false);
		String companyName=(String) oldSession.getAttribute("key1");
		out.println("<h1>welcome to "+" "+companyName+"</h1>");
		Map<String,Long> sessionMap=(Map<String,Long>)oldSession.getAttribute("key2");
		out.println("<table border='2'>");
		out.println("<thread>");
		out.println("<th> Name</th>"); 
		out.println("<th>Phone</th>");
		out.println("</thread>");
		for(Entry<String,Long> e:sessionMap.entrySet()) {
			out.println("<tr>");
			out.println("<td>"+e.getKey()+"</td>");
			out.println("<td>"+e.getValue()+"</td>");
			out.println("</tr>");
			
		}
		out.println("</table>");
		out.println("<h5><font color='blue'>"+new Date(oldSession.getLastAccessedTime())+"</font></h5>");
		out.print("<a href='sessionLogout'>Logout from Here....</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

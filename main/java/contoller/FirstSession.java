package contoller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.*;
/**
 * Servlet implementation class FirstSession
 */
@WebServlet("/session1")
public class FirstSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstSession() {
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
		HttpSession session =request.getSession();
		out.println("<h3> <font color='blue'>"+" "+session.getId()+"</font></h3><br>");
		out.println("<h3> <font color='red'>"+ new Date(session.getCreationTime())+"</font></h3>");
		session.setAttribute("key1", "Wipro Limited");
		Map<String,Long> map=new HashMap();
		map.put("Ravi",4555665L);
		map.put("ABC", 546515L);
		session.setAttribute("key2",map);
		RequestDispatcher rd=request.getRequestDispatcher("SessionLink.html");
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

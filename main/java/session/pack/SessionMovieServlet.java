package session.pack;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Servlet implementation class SessionMovieServlet
 */
@WebServlet("/ViewMovie")
public class SessionMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<Integer,Movie> movieStore=new HashMap();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) {
    	movieStore.put(1,new Movie("Article_370","230","city","1:30","2024-04-08"));
    	movieStore.put(2,new Movie("Shaitan","230","city","12:30","2024-05-08"));
    	movieStore.put(3,new Movie("Sam_Bahadur","230","city","11:30","2024-06-08"));
    	movieStore.put(4,new Movie("12th_Fail","230","city","10:30","2024-08-08"));
    	
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
	

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession oldsession =request.getSession(false);
		String userName=(String) oldsession.getAttribute("Namekey");
		out.println("<center><h3> Welcome"+" "+userName);
		out.println("<center><h4>****Movie List*****</center></h4>");
		Set<Entry<Integer,Movie>> setOfEntry=movieStore.entrySet();
		out.println("<center><table border='2'>");
		out.println("<thread>");
		out.println("<th>Name</th>");
		out.println("<th>Price</th>");
		out.println("<th>Cinema Hall</th>");
		out.println("<th>Time</th>");
		out.println("<th>Date</th>");
		out.println("<th>Book</th>");
		for(Entry<Integer,Movie> e:setOfEntry) {
			Movie m=e.getValue();
			String movieName=m.getMovieName();
			String moviePrice=m.getMoivePrice();
			String movieHall=m.getCinemaHall();
			String movieTime=m.getMovieTime();
			String movieDate=m.getMovieDate();
			out.println("<tr>");
			out.println("<td>"+movieName+"</td>");
			out.println("<td>"+moviePrice+"</td>");
			out.println("<td>"+movieHall+"</td>");
			out.println("<td>"+movieTime+"</td>");
			out.println("<td>"+movieDate+"</td>");
			//url rewriting
			out.println("<td><a href='movieBookSevlet?name="+movieName+"'>"+"BOOK SHOW</a></td>");
			
			
		}
		out.println("<a href='LogoutServlet1'>Logout</a>");
		
	}

}

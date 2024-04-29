package session.pack;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/LogoutServlet1")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
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
		HttpSession session =request.getSession(false);
		session.removeAttribute("key1");
		session.removeAttribute("key2");
		session.invalidate();
		out.println("session Killed");
		try {
		String cn=(String) session.getAttribute("key1");
		}catch(Exception e) {
			out.println(e);
			out.println("session closed.....not able to access");
		}
		
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");;
		
		RequestDispatcher rd=request.getRequestDispatcher("SessionLogin.html");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

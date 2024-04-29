package hidden.pack;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class NextHidden
 */
@WebServlet("/NextHiddenServlet")
public class NextHidden extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextHidden() {
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

		response.setContentType("text/html");
		PrintWriter wr=response.getWriter();
		String un=request.getParameter("myUserParam");
		String pw=request.getParameter("myPassParam");
		wr.println("<h3>"+" "+un+" and the Password is:  "+pw+"</h3>");
		wr.println("<script>"+"alert('your user name is'+' '+'"+un+"')"+"</script>");
		
		//RequestDispatcher rd=request.getRequestDispatcher("ThirdServlet");
		//rd.include(request, response);
		
		//if response.sendRedirect("ThirdServlet") is used then the parameters are not forwarded to the ThirdServlet, because it is only limited to NextServlet
		//response.sendRedirect("ThirdServlet");
	}

}

package hidden.pack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MyHiddenServlet
 */
@WebServlet("/HiddenServlet")
public class MyHiddenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyHiddenServlet() {
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
		String userName=request.getParameter("t1");
		String password=request.getParameter("t2");
		PrintWriter out=response.getWriter();
		out.println("<form action='NextHiddenServlet' method='post'>");
		out.println("<input type='hidden' name='myUserParam' value="+userName+">");
		out.println("<input type='hidden' name='myPassParam' value="+password+">");
		out.println("<input type='submit'  value='+click to next'>");
		out.println("</form");
	}

}

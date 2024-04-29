package session.pack;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class LoginSessionServlet
 */
@WebServlet("/loginWithSession")
public class LoginSessionServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
	List <UserLogin> listOfUser=new ArrayList();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) {
    	listOfUser.add(new UserLogin("admin","admin@123"));
    	listOfUser.add(new UserLogin("trainer","trainer@123"));
    	listOfUser.add(new UserLogin("hr","hr@123"));
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
		HttpSession session =request.getSession();
		String userName=request.getParameter("UserName");
		String userPass=request.getParameter("UserPassword");
		
		//collection from listOfUser
		int flag=0;
		for(UserLogin user:listOfUser) {
			if(user.getUserName().equalsIgnoreCase(userName)&&user.getUserPassword().equals(userPass)) {
				flag=1;
				break;
				
			}
		}
		if(flag==1) {
			out.println("<center><h3><font color='green'>Login Success"+"</font></h3>");
			HttpSession session1 =request.getSession();
			session1.setMaxInactiveInterval(200);
			session1.setAttribute("Namekey", userName);
			session.setAttribute("Passkey", userPass);
			
			RequestDispatcher rd=request.getRequestDispatcher("ViewMovie");
			rd.include(request, response);
			
		}
		
	}

}

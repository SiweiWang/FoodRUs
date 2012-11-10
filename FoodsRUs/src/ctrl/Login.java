package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login, used for login 
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String target;
		HttpSession session = request.getSession();
		System.out.println("inlogin" + login);
		if (login==null)
		{
			target = "/login.jspx";
		}
		else
		{
			if (login.equals("lgoin"))
			{
				//check db and login
				System.out.println("login");
				boolean loginOK = false;

				//TODO check and set loginOk
				session.setAttribute("login", loginOK);		
			}
			target = "/index.jspx";
		}	
		request.getRequestDispatcher(target).forward(request, response);

	}
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

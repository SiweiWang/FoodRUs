package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FRUModel;

/**
 * Servlet implementation class Login, used for login 
 */
@WebServlet("/Login")
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
		System.out.println("IN outter login page");
		String login = request.getParameter("login");
		String target;
		System.out.println(login);

		HttpSession session = request.getSession(true);

		if (login==null)
		{
			target = "/login.jspx";
		}
		else
		{
			if (login.equals("lgoin"))
			{
				System.out.println("IN login page");
				String clientID = request.getParameter("ClientID");
				String password =request.getParameter("Password");
				
				System.out.println(clientID + " " + clientID);
				//check db and login
				FRUModel model = (FRUModel) this.getServletContext().getAttribute("fru"); 
				
				if(clientID!=null && password!=null)
				{
					try 
					{
						String ClientName = model.validatePassword(clientID, password);
						if (! ClientName.equals(" "))
						{
							session.setAttribute("login", 1);	
							session.setAttribute("clientID", ClientName);
						}
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
						session.setAttribute("loginError", e.getMessage());
					}

				}
			}
			target = "/login.jspx";
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

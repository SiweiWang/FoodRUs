package ctrl;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

/**
 * Servlet implementation class FRU
 */
@WebServlet(urlPatterns = {"/Start", "/Login"} )
public class FRU extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FRU() {
        super();
    }
    
    /**
     * 
     */
	@Override
	public void init() throws ServletException {
		
		super.init();

		//the singleton model need to be initialized here
		FRUModel fru;
		try {
			fru = new FRUModel();
			this.getServletContext().setAttribute("fru", fru);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// assume that index.html, we have four buttons , each called login , shopping cart, check out and express check out
		// let the button call doit 
		HttpSession session;
		String target;
		String doit = request.getParameter("doit");
		FRUModel model = (FRUModel) this.getServletContext().getAttribute("fru"); 
		if (doit == null)
		{
			//first time
			try
			{
				request.setAttribute("categories", model.retrieveCategory());
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			target = "/index.jspx";
		}
		else 
		{
			session = request.getSession(true);
			if (doit.equals("login"))
			{
				target = "/login.jspx";
			}
			else if (doit.equals("cart"))
			{
				target = "/cart.jspx";
			}
			else if (doit.equals("checkout"))
			{
				target = "/checkout.jspx";
			}
			else
			{
				target = "/express.jspx";
			}
			System.out.println(doit);
			
		}
		
		
		RequestDispatcher rd= request.getRequestDispatcher(target);
		rd.forward(request, response);
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet (request, response);
	}

}

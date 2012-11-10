package ctrl;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import model.Mortgage;


/**

 * Servlet implementation class Start

 */

@WebServlet(urlPatterns = {"/Start", "/Startup/*"} )

public class Start extends HttpServlet {

private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */



    public Start() {

        super();

        // TODO Auto-generated constructor stub

    }


    @Override
	public void init() throws ServletException 
	{
		// TODO Auto-generated method stub
		super.init();
		this.getServletContext().setAttribute("model", new Mortgage());
		
	}


/**

* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

*/

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 

{
				String target;
				double payment = 0;
						
					if (request.getParameter("doit")==null)
					{
						//Send it to JSP
						request.getSession(true).invalidate();
						target= "/UI.jspx";			
					}
					else
					{
						String principle = request.getParameter("principle");
						String amortization = request.getParameter("amortization");
						String interest = request.getParameter("interest");	
						
						// using session to save information from client 
						HttpSession session = request.getSession();
						
						
						if ( principle  == null )
						{
							principle = (String) session.getAttribute("principle");
							
						}
						if (amortization == null )
						{
							amortization = (String) session.getAttribute("amortization");
						}
						
						session.setAttribute("principle", principle);
						session.setAttribute("amortization", amortization);
						session.setAttribute("interest",interest);
						System.out.println("-------------------------");
						System.out.println(session.getId());
						System.out.println("before Compute");
						System.out.println(request.getSession().getAttribute("principle"));
						System.out.println(request.getSession().getAttribute("interest"));
						System.out.println("-------------------------");
						
						try
						{ 
							Mortgage mort = (Mortgage) this.getServletContext().getAttribute("model");
							payment = mort.computePayment(principle,amortization,interest);
							request.setAttribute("payment", payment);
							target = "/Result.jspx";
						}
						
						catch (Exception e)
						{
							//request.setAttribute("errorMessage", e.getMessage());
							request.setAttribute("errorMessage", e.toString());
							target = "/UI.jspx";
						}
					}
					RequestDispatcher rd= request.getRequestDispatcher(target);
					rd.forward(request, response);
	}
	
	/**
	
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	
	*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
	
		this.doGet(request, response);
	}
	
	
} 
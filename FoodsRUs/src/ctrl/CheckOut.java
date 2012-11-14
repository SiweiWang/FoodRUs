package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import Util.*;
import model.ClientBean;
import model.FRUModel;
import model.ShoppingCartHelper;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkout = request.getParameter("checkout");
		String target;
		if (checkout==null)
		{
			if (request.getSession(false) == null || !request.getSession().getAttribute("login").equals("login"))
			{
				target = "/login.jspx";
				System.out.println("checkout -> login");
			}
			else
			{
				
				target="/checkout.jspx";
				
			}
		}
		else
		{
			if (checkout.equals("checkout") )
			{
				//do check out 
				
				FRUModel model = (FRUModel)this.getServletContext().getAttribute("fru");
				String filename = Constants.FOLDERTOEXPORT + request.getSession().getId()+ Constants.XMLEXTENSION;

				try {
					ShoppingCartHelper cart = (ShoppingCartHelper) request.getSession().getAttribute("cart");
					model.checkOut(cart);
					model.exportPO(this.getServletContext().getRealPath(filename), (Integer)this.getServletContext().getAttribute("id"), 
							(ClientBean)this.getServletContext().getAttribute("client"), cart);
				} catch (JAXBException e) {
					e.printStackTrace();
					response.sendError(500);
				}
				
				target= "/confirm.jspx";
				System.out.println("confirmed");
			}
			else
			{
				target = "/index.jspx";
				System.out.println("continue shopping");

			}
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

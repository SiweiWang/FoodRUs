package ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemBean;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCart() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String add = request.getParameter("add");
		String target ;
		if (add != null)
		{
			if (add.equals("AddToCart"))
			{
				/*
				ShoppingCartBean cart = (ShoppingCartBean)request.getSession().getAttribute("cart");
				if (cat == null)
				{
					
					//ShoppingCartBean cart = new ShoppingCartBean();
					request.getSession().setAttribute("cart", cart);
				}
				
				request.getParameter("itemToAdd");
				request.getParameter("catID");
				
				*/
				target ="/cart.jspx";
			}
			else
			{
				target ="/checkout.jspx";
			}
		}
		else
		{
			target ="/index.jspx";
		}
		
		request.getRequestDispatcher(target).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}

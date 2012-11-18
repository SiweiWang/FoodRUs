package ctrl;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class FRUListener
 *
 */
@WebListener
public class FRUListener implements HttpSessionAttributeListener {

	

	private double totalAveTime =0;
	private int totalCustomer =0;
	private double ave_fresh_checkout=0;
	final double MINISECOND_PER_SECOND = 1000;

    /**
     * Default constructor. 
     */
	
    public FRUListener() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
    	  handle(arg0);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0){
        // TODO Auto-generated method stub
    	 handle(arg0);
    }
    
    public void handle(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
         // this listener only respone to the first checkout
    	if(arg0.getName().equals("checkout"))
    	{
    		if(arg0.getSession().getAttribute("continue").equals("first"))
    		{
    		long startT = arg0.getSession().getCreationTime();
            double checkoutTime = arg0.getSession().getLastAccessedTime();
    	    double diffTime = (checkoutTime - startT)/MINISECOND_PER_SECOND;
            totalCustomer = totalCustomer + 1;
    	    totalAveTime = totalAveTime + diffTime;
    	    ave_fresh_checkout = totalAveTime /totalCustomer;
    	    System.out.println("the ave time1 is: " + ave_fresh_checkout);
    	    
    	    arg0.getSession().getServletContext().setAttribute("ave_fresh_checkout", ave_fresh_checkout);
    	    arg0.getSession().getServletContext().setAttribute("totalCustomer",totalCustomer);
    		}
    	}


    	
    }
	
}

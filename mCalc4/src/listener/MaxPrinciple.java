package listener;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class MaxPrinciple implements HttpSessionAttributeListener {
    /**
     * Default constructor. 
     */
    public MaxPrinciple() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("listener added");

    	this.handle(arg0);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
    	this.handle(arg0);

    }
    
    private synchronized void handle (HttpSessionBindingEvent arg0)
    {
    	// get max from app scope
    	if (arg0.getName().equals("principle"))
    	{
    		
    		if ( arg0.getSession().getServletContext().getAttribute("maxPrinciple")  == null )
    		{
    			 arg0.getSession().getServletContext().setAttribute("maxPrinciple", new Double(0.0)) ;
    		}
    		
    			double max = 0.0;
    			System.out.println("listener");
    			System.out.println(arg0.getValue());
    	
    		if ( Double.parseDouble((String)arg0.getValue()) > (Double)arg0.getSession().getServletContext().getAttribute("maxPrinciple"))
    		{
    			max = Double.parseDouble((String)arg0.getValue()) ;
    			arg0.getSession().getServletContext().setAttribute("maxPrinciple", max);
    			System.out.println("adjust to: " + max);
    		}
    	}
    	// return max
    }
	
}

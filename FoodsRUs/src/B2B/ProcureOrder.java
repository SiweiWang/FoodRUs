/**
 * 
 */
package B2B;
import model.OrderWrapper;
import model.ShoppingCartHelper;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * @author Vicky
 *
 */
public class ProcureOrder {

	/**
	 * 
	 */
	public ProcureOrder() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception 
	{
		
		if (args.length != 1 )
		{
			System.out.println("Wrong number of arguments");
		}
		else
		{
			File folder = new File(args[0]);
			File[] listOfFiles = folder.listFiles();
	
			for (File i : listOfFiles) 
			{

			          System.out.println(i.getName());
						// Create the unmarshaller, this is the nifty little thing that will actually transform the XML back into an object
			          JAXBContext context = JAXBContext.newInstance(OrderWrapper.class);
			          
			          Unmarshaller unmarshaller = context.createUnmarshaller();
			   
			          // Unmarshal the XML in the stringWriter back into an object
			          OrderWrapper ow = (OrderWrapper) unmarshaller.unmarshal(i);
			          
			          
			          // Print out the contents of the JavaObject we just unmarshalled from the XML
			          System.out.println(ow.getHST());
			               
			}  
		}
	}
}




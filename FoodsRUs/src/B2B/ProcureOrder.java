/**
 * 
 */
package B2B;
import model.*;

import java.io.File;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;


/**
 * @author Vicky
 *
 */
public class ProcureOrder {

	private static HashMap<String,ItemBean> procurementOrder = new HashMap<String, ItemBean>();;

	
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

			          System.out.println(i.getAbsolutePath());
						// Create the unmarshaller, this is the nifty little thing that will actually transform the XML back into an object
			          JAXBContext context = JAXBContext.newInstance(OrderWrapper.class);
			          
			          Unmarshaller unmarshaller = context.createUnmarshaller();
			  			   
			          // Unmarshal the XML in the stringWriter back into an object
			          OrderWrapper ow =  (OrderWrapper) unmarshaller.unmarshal(i);

			          for (ItemBean item: ow.getItems().getItems())
			          {
			        	  produceOrder(item);
			          }
			          // Print out the contents of the JavaObject we just unmarshalled from the XML			               
			}
			
			WebServiceClient.order(procurementOrder.values());
			
			System.out.println(procurementOrder);
		}
	}

	/**
	 * 
	 * @param item
	 */
	private static void produceOrder(ItemBean item)
	{
		
		String itemNumber = item.getItemNumber();
		if (ProcureOrder.procurementOrder.containsKey(itemNumber))// the map already has the item
		{
			ItemBean it = ProcureOrder.procurementOrder.get(itemNumber);
			int qty = it.getQuantity() + item.getQuantity();
			it.setQuantity(qty);
		}else //the map does not have the item
		{
			
			ProcureOrder.procurementOrder.put(itemNumber, item);
		}
		
	}


}




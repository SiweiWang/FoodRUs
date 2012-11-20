/**
 * 
 */
package B2B;
import model.OrderWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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
			      StringBuffer sb = new StringBuffer();  
			      BufferedReader reader = null;       
			      reader = new BufferedReader(new FileReader(i));  
			      String strRead = "";  
			      while((strRead = reader.readLine())!=null)
			      {  
			    	  sb.append(strRead);  
			      }  
			          reader.close();
			          // Create the unmarshaller, this is the nifty little thing that will actually transform the XML back into an object
			          JAXBContext context = JAXBContext.newInstance(OrderWrapper.class);
			          
			          Unmarshaller unmarshaller = context.createUnmarshaller();
			   
			          // Unmarshal the XML in the stringWriter back into an object
			          OrderWrapper ow = (OrderWrapper) unmarshaller.unmarshal(i);
			   
			          // Print out the contents of the JavaObject we just unmarshalled from the XML
			          System.out.println(ow);
			      }  
			 }
		}
	}




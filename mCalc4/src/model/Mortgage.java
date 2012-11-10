package model;

public class Mortgage {

	final int MonthOfYear = 12;		

	
		public Mortgage()
		{
			
		}
		

		public double computePayment (String p, String a,
				String i) {
			
			
			double principle = Double.parseDouble(p); 
			int amortization= Integer.parseInt(a);
			double interest =  Double.parseDouble(i);
			double r = interest /100; // rpercent -> percentage 
			
			r =  r / MonthOfYear; 
			
			int n = amortization * MonthOfYear;
		
			double payment = r * principle ;

				
			return payment /= (1- Math.pow(1+r, -n));
			
		}

}

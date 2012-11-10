  function validate()
  {
	var ok = true;
	var p = document.getElementById("principle").value;
	if (isNaN(p) || p <= 0)
	{
		//alert("Principle invalid!");
		document.getElementById("PrincipleMsg").innerHTML="Principle is not positive";
		ok = false;
	}

	if (!ok) return false;
	p = document.getElementById("interest").value;
	if (isNaN(p) || p <= 0 || p >= 100)
	{
		//alert("Invalid. Must be in (0,100).");
		document.getElementById("InterestMsg").innerHTML="Invalid. Must be in (0.100).";
		ok = false;
	}	
	return ok;
  }
  
 function checkPrinciple(node)
 {
	 var principle=document.getElementById("principle").value;
	 var msg = "*";
	 if(isNaN(principle))
		 {
		 	msg = "Principle Must be a number";
		 }
	 else if (principle <=0)
		 {
	 		msg= "Principle is not positive";
		 }
	 document.getElementById("PrincipleMsg").innerHTML=msg;
 }
 
 function setPM(node)
 {
	 var msg = "*";
	 document.getElementById("PrincipleMsg").innerHTML=msg;
 }
 
 function setIM(node)
 {
	 var msg = "*";
	 document.getElementById("InterestMsg").innerHTML=msg;
 }
 
 function checkInterest(node)
 {
	 var interest=document.getElementById("interest").value;
	 var msg = "*";
	 if(isNaN(interest))
		 {
		 	msg = "Interest Must be a number";
		 }
	 else if (interest <=0 ||  interest >= 100)
		 {
	 		msg= "Invalid. Must be in (0.100)";
		 }
	 document.getElementById("InterestMsg").innerHTML=msg;
 }
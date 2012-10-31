  function validate()
  {
	var ok = true;
	var p = document.getElementById("principle").value;
	if (isNaN(p) || p <= 0)
	{
		alert("Principle invalid!");
		ok = false;
	}
	if (!ok) return false;
	p = document.getElementById("interest").value;
	if (isNaN(p) || p <= 0 || p >= 100)
	{
		alert("Invalid. Must be in (0,100).");
		ok = false;
	}	
	return ok;
  }
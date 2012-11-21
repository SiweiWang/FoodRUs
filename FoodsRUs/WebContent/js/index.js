//checks whether the quantity to add in the form is valid
function checkQty(form)
{
	var qtyToAdd = form.childNodes[1].value;
	var ok = true;
	if (qtyToAdd == 0)
	{
		alert("The quantity for the item you're trying to add is 0!");
		ok = false;
	}else if (qtyToAdd < 0)
	{
		alert("You're trying to add a negative quantity!");
		ok = false;
	}
	return ok;
}

function checkUpdate()
{
	var q = document.getElementsByClassName("qtyInput");
	for(var i=0; i <= q.length; i++)
	{
		if (q[i].value < 0)
		{
			alert("The quantity for one of the items is negative!");
			return false;
		}
	}
	return true;
}

function validateQty(qty)
{
	if(qty.value < 0)
	{
		alert("The quantity for one of the items is negative!");
	}
}

function clearSearchBox(box)
{
	box.value = "";
}
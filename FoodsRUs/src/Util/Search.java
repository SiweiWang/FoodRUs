package Util;

import java.util.List;
import model.FoodRUDAO;
import model.ItemBean;

public class Search
{
    private FoodRUDAO fdao;
    private List<ItemBean> list;
	public Search() throws Exception
	{
		fdao = new FoodRUDAO();
		list = fdao.retrieveItems();
		
	}

public List<ItemBean> searchName(String n)
{
	
}
}
package Util;

import java.sql.SQLException;
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
	}

    public List<ItemBean> searchItemName(String name) throws SQLException
    {
	    list = fdao.retrieveItemsName(name);
	    return list;
    }
    
    public List<ItemBean> searchItemPrice(String price) throws SQLException
    {
	    list = fdao.retrieveItemsPrice(price);
	    return list;
    }
    public List<ItemBean> searchItemNumber(String number) throws SQLException
    {
	    list = (List<ItemBean>) fdao.retrieveItemsNumber(number);
	    return list;
    }
    
    
}
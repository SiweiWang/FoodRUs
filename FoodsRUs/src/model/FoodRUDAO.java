package model;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FoodRUDAO {

	private DataSource dataSource;
	
	public FoodRUDAO() throws Exception
	{
		this.dataSource = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/CSE");
	}
	

}

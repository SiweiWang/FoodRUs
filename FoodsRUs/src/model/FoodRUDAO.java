package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FoodRUDAO {

	private DataSource dataSource;
	
	/**
	 * 
	 * @throws Exception
	 */
	public FoodRUDAO() throws Exception
	{
		this.dataSource = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/CSE");
	}
	
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<CategoryBean> retrieveCategory() throws Exception 
	{
		List<CategoryBean> list = null;
		Connection con = null;
		Statement s = null;
		try {
			con = this.dataSource.getConnection();
			s = con.createStatement();
			String query = "Select * from roumani.category";
			ResultSet r = s.executeQuery(query);
			list = new ArrayList<CategoryBean>();
			while (r.next()) 
			{
				CategoryBean cb = new CategoryBean(r.getInt("ID"), r.getString("NAME"), r.getString("DESCRIPTION"));
				list.add(cb);
			}
		} finally {
			if (con != null) con.close();
			if (s != null) s.close();
		}
		
		return list;
	}

}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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


	/**
	 * 
	 * @param catID
	 * @return
	 * @throws SQLException 
	 */
	public List<ItemBean> retrieveItems(int catID) throws SQLException 
	{
		List<ItemBean> list = null;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = this.dataSource.getConnection();

			String query = "Select SURNAME, GIVENNAME, GPA, MAJOR, COURSES from roumani.SIS where SURNAME like ? and GPA >= ?";
			ps = con.prepareStatement(query);
	//		ps.setString(1, namePrefix);
	
			ResultSet r = ps.executeQuery();
			list = new ArrayList<ItemBean>();
			while (r.next()) {
//				ItemBean ib = new ItemBean(r.getString("SURNAME") + ", "
//						+ r.getString("GIVENNAME"), r.getDouble("GPA"), r.getString("MAJOR"), r.getInt("COURSES"));
	//			list.add(ib);
			}
		} finally {
			if (con != null) con.close();
			if (ps != null) ps.close();
		}
		return list;
	}
	
	

}

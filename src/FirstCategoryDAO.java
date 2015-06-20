
//
//  @ Project : Untitled
//  @ File Name : FirstCategoryDAO.java
//  @ Date : 2014-05-13	
//  @ Author : 김영한
//
//



import java.sql.*;
public class FirstCategoryDAO {
	private Connection conn;
	public FirstCategoryDAO() {
		connect();
	}
	
	public Connection getConn() {
		return conn;	
	}
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	private void connect() {
		try
		{
			conn = DBConnectionPool.getInstance().getConnection();	
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
	}
	
	public void disconnect() {
		try
		{
			if(conn != null){
				conn.close();
				System.out.println("DB와 연결이 끊어졌습니다.");
			}
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
	}
	
	public int insert(int firstCategoryCode, String firstCategoryName) {
		int rowNum = 0; 
		PreparedStatement pstmt = null;
		try
		{
			String sql = "insert into member_tb values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,firstCategoryCode);
			pstmt.setString(2,firstCategoryName);
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt != null) pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	
	public FirstCategoryList selectAll() {
		FirstCategoryList list = new  FirstCategoryList();
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "select * from firstCategory_tb";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				int firstCategoryCode = rs.getInt("code");
				String firstCategoryName = rs.getString("name");
				list.addFirstCategoryList(new FirstCategoryDTO(firstCategoryCode,firstCategoryName));
			}
		}	
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt != null) pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return list;
	}
	
	public FirstCategoryDTO selectFirstCategoryCode(int firstCategoryCode) {
		FirstCategoryDTO dto = null;
		PreparedStatement pstmt = null;
		try
		{
			String sql = "select * from member_tb where firstCategoryCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,firstCategoryCode);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				int firstCategoryCode_ = rs.getInt("code");
				String firstCategoryName = rs.getString("name");
				dto = new FirstCategoryDTO(firstCategoryCode_,firstCategoryName);
			}
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt != null) pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return dto;
	}
	
	public FirstCategoryList selectFirstCategoryName(String firstCategoryName) {
		FirstCategoryList list = new  FirstCategoryList();
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "select * from firstCategory_tb where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,firstCategoryName);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				int firstCategoryCode = rs.getInt("code");
				String firstCategoryName_ = rs.getString("name");
				list.addFirstCategoryList(new FirstCategoryDTO(firstCategoryCode,firstCategoryName_));
			}
		}	
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt != null) pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return list;
	}	
	
	public int updateAll(int firstCategoryCode, String firstCategoryName) {
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try
		{
			String sql = "update firstcategory_tb set name = ? where code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,firstCategoryName);
			pstmt.setInt(2,firstCategoryCode);

			rowNum =  pstmt.executeUpdate();

		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt != null) pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum; 
	}
	
	public int updateFirstCategoryName(int firstCategoryCode, String firstCategoryName) {
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try
		{
			String sql = "update firstcategory_tb set name = ? where code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,firstCategoryName);
			pstmt.setInt(2,firstCategoryCode);

			rowNum =  pstmt.executeUpdate();

		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt != null) pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum; 
	}
	
	public int deleteAll() {
		int rowNum = 0;
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "delete from firstcategory_tb";
			pstmt = conn.prepareStatement(sql);

			rowNum  = pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt != null) pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	
	public int deleteFirstCategoryCode(int firstCategoryCode) {
		int rowNum = 0;
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "delete from firstcategory_tb where code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,firstCategoryCode);

			rowNum  = pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt != null) pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	
	public int deleteFirstCategoryName(String firstCategoryName) {
		int rowNum = 0;
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "delete from firstcategory_tb where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,firstCategoryName);

			rowNum  = pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt != null) pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
}


//
//  @ Project : Untitled
//  @ File Name : OrderInfoDAO.java
//  @ Date : 2014-05-13	
//  @ Author : 김영한
//
//


import java.sql.*;
public class OrderInfoDAO {
	private Connection conn;
	
	public void OrderInfoDAO() {
		connect();
	}
	
	public void OrderInfoDAO(Connection conn) {
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
	
	public int insert(int orderInfoCode, String orderDate, String id) {
		int rowNum = 0; 
		PreparedStatement pstmt = null;
		try
		{
			String sql = "insert into orderinfo_tb values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,orderInfoCode);
			pstmt.setString(2,orderDate);
			pstmt.setString(3,id);
			rowNum = pstmt.executeUpdate();
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
	
	public OrderInfoList selectAll() {
		OrderInfoList list = new  OrderInfoList();
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "select * from orderinfo_tb";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				int orderInfoCode = rs.getInt("orderInfoCode");
				Date orderDate = rs.getDate("orderDate");
				String id = rs.getString("id");

				list.addOrderInfoList(new OrderInfoDTO(orderInfoCode,orderDate.getYear()+"/"+orderDate.getMonth()+"/"+orderDate.getDate(),id));
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
	
	public OrderInfoDTO seleteOrderInfoCode(int orderInfoCode) {
		OrderInfoDTO dto = null;
		PreparedStatement pstmt = null;
		try
		{
			String sql = "select * from orderinfo_tb where orderinfocode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,orderInfoCode);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				int code = rs.getInt("orderInfoCode");
				Date orderDate = rs.getDate("orderDate");
				String id = rs.getString("id");

				dto = new OrderInfoDTO(code,orderDate.getYear()+"/"+orderDate.getMonth()+"/"+orderDate.getDate(),id);
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
	
	public OrderInfoList seleteOrderDate(String orderDate) {
		OrderInfoList list = new OrderInfoList();
		PreparedStatement pstmt = null;

		try
		{
			String sql = "select * from orderinfo_tb where orderdate = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,orderDate);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				int code = rs.getInt("orderInfoCode");
				Date date = rs.getDate("orderDate");
				String id = rs.getString("id");

				list.addOrderInfoList( new OrderInfoDTO(code,date.getYear()+"/"+date.getMonth()+"/"+date.getDate(),id));
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
	
	public OrderInfoList seleteId(String id) {
		OrderInfoList list = new OrderInfoList();
		PreparedStatement pstmt = null;

		try
		{
			String sql = "select * from orderinfo_tb where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				int code = rs.getInt("orderInfoCode");
				java.sql.Date date = rs.getDate("orderDate");
				String id_ = rs.getString("id");

				list.addOrderInfoList(new OrderInfoDTO(code,date.getYear()+"/"+date.getMonth()+"/"+date.getDate(),id_));
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
	
	public int updateAll(int orderInfoCode, String orderDate, String id) {
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try
		{
			String sql = "update orderinfo_tb set orderdate = TO_DATE(?,'YYYY/MM/DD'), id = ? where orderinfocode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,orderDate);
			pstmt.setString(2,id);
			pstmt.setInt(3,orderInfoCode);

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
	
	public int updateOrderDate(int orderInfoCode, String orderDate) {
		int rowNum = 0;
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "update orderinfo_tb set orderdate = TO_DATE(?,'YYYY/MM/DD') where orderinfocode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,orderDate);
			pstmt.setInt(2,orderInfoCode);

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
	
	public int updateId(int orderInfoCode, String id) {
		int rowNum = 0;
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "update orderinfo_tb set id = ? where orderinfocode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setInt(2,orderInfoCode);

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
	
	public int deleteAll() {
		int rowNum = 0;
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "delete from orderinfo_tb";
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
	
	public int deleteOrderInfoCode(int orderInfoCode) {
		int rowNum = 0;
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "delete from orderinfo_tb where orderinfocode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,orderInfoCode);
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
	
	public int deleteOrderDate(String orderDate) {
		int rowNum = 0;
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "delete from orderinfo_tb where orderDate = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,orderDate);
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
	
	public int deleteId(String id) {
		int rowNum = 0;
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "delete from orderinfo_tb where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
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
	
	public Connection getConn() {
		return conn;
	}
		
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
}

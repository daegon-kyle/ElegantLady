
//
//  @ Project : Untitled
//  @ File Name : MemberDAO.java
//  @ Date : 2014-05-13	
//  @ Author : 김영한
//
//

import java.sql.*;
public class MemberDAO {
	private Connection conn;
	public MemberDAO() {
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
			System.out.println("연결에 성공했습니다.");
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
	
	public int insert(String id, String name, String password, String address, String phone, String zipCode) {
		int rowNum = 0; 
		PreparedStatement pstmt = null;
		try
		{
			String sql = "insert into member_tb values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,name);
			pstmt.setString(3,password);
			pstmt.setString(4,address);
			pstmt.setString(5,phone);
			pstmt.setString(6,zipCode);
			pstmt.setString(7,"m");
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
	
	public MemberList selectAll() {
		MemberList list = new  MemberList();
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "select * from member_tb";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String id = rs.getString("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String zipCode = rs.getString("zipCode");
				list.addMemberList(new MemberDTO(id,name,password,address,phone,zipCode));
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
	
	public MemberDTO selectId(String id) {
		MemberDTO dto = null;
		PreparedStatement pstmt = null;
		try
		{
			String sql = "select * from member_tb where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String id_ = rs.getString("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String zipCode = rs.getString("zipCode");
				dto = new MemberDTO(id_,name,password,address,phone,zipCode);
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
	
	public MemberDTO selectPassword(String password) {
		MemberDTO dto = null;
		PreparedStatement pstmt = null;
		try
		{
			String sql = "select * from member_tb where password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String id = rs.getString("id");
				String name = rs.getString("name");
				String password_ = rs.getString("password");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String zipCode = rs.getString("zipCode");
				dto = new MemberDTO(id,name,password_,address,phone,zipCode);
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
	
	public MemberDTO seletectIdPassword(String id, String password) {
		MemberDTO dto = null;
		PreparedStatement pstmt = null;
		try
		{
			String sql = "select * from member_tb where id = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String id_ = rs.getString("id");
				String name = rs.getString("name");
				String password_ = rs.getString("password");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String zipCode = rs.getString("zipCode");
				dto = new MemberDTO(id_,name,password_,address,phone,zipCode);
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
	
	public MemberList selectName(String name) {
		MemberList list = new MemberList();
		PreparedStatement pstmt = null;

		try
		{
			String sql = "select * from member_tb where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String id_ = rs.getString("id");
				String name_ = rs.getString("name");
				String password_ = rs.getString("password");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String zipCode = rs.getString("zipCode");
				list.addMemberList(new MemberDTO(id_,name_,password_,address,phone,zipCode));
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
	
	public MemberList selectAddress(String address) {
		MemberList list = new MemberList();
		PreparedStatement pstmt = null;

		try
		{
			String sql = "select * from member_tb where address = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,address);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String id_ = rs.getString("id");
				String name = rs.getString("name");
				String password_ = rs.getString("password");
				String address_ = rs.getString("address");
				String phone = rs.getString("phone");
				String zipCode = rs.getString("zipCode");
				list.addMemberList(new MemberDTO(id_,name,password_,address_,phone,zipCode));
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
	
	public MemberDTO selectPhone(String phone) {
		MemberDTO dto = null;
		PreparedStatement pstmt = null;
		try
		{
			String sql = "select * from member_tb where phone = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,phone);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String id_ = rs.getString("id");
				String name = rs.getString("name");
				String password_ = rs.getString("password");
				String address = rs.getString("address");
				String phone_ = rs.getString("phone");
				String zipCode = rs.getString("zipCode");
				dto = new MemberDTO(id_,name,password_,address,phone_,zipCode);
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
	
	public MemberList selectZipCode(String zipCode) {
		MemberList list = new MemberList();
		PreparedStatement pstmt = null;

		try
		{
			String sql = "select * from member_tb where zipCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,zipCode);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String id_ = rs.getString("id");
				String name = rs.getString("name");
				String password_ = rs.getString("password");
				String address_ = rs.getString("address");
				String phone = rs.getString("phone");
				String zipCode_ = rs.getString("zipCode");
				list.addMemberList(new MemberDTO(id_,name,password_,address_,phone,zipCode_));
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
	
	public int updateAll(String id, String name, String password, String address, String phone, String zipCode) {
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try
		{
			String sql = "update member_tb set name = ?, password = ?, address = ?, phone = ?, zipcode = ?, membergrade = ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,password);
			pstmt.setString(3,address);
			pstmt.setString(4,phone);
			pstmt.setString(5,zipCode);
			pstmt.setString(6,id);

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
	
	public int updateName(String id, String password, String name) {
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try
		{
			String sql = "update member_tb set name = ? where id = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,id);
			pstmt.setString(3,password);

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
	
	public int updatePassword(String id, String password, String changePassword) {
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try
		{
			String sql = "update member_tb set password = ? where id = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,changePassword);
			pstmt.setString(2,id);
			pstmt.setString(3,password);

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
	
	public int updateAddress(String id, String password, String address) {
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try
		{
			String sql = "update member_tb set address = ? where id = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,address);
			pstmt.setString(2,id);
			pstmt.setString(3,password);

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
	
	public int updatePhone(String id, String password, String phone) {
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try
		{
			String sql = "update member_tb set phone = ? where id = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,phone);
			pstmt.setString(2,id);
			pstmt.setString(3,password);

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
	
	public int updateZipCode(String id, String password, String zipCode) {
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try
		{
			String sql = "update member_tb set zipcode = ? where id = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,zipCode);
			pstmt.setString(2,id);
			pstmt.setString(3,password);

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
			String sql = "delete from member_tb";
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
	
	public int deleteId(String id) {
		int rowNum = 0;
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "delete from member_tb where id = ?";
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
	
	public int deleteName(String name) {
		int rowNum = 0;
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "delete from member_tb where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
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
	
	public int deletePassword(String password) {
		int rowNum = 0;
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "delete from member_tb where password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,password);
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
	
	public int deleteIdPassword(String id, String password) {
		int rowNum = 0;
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "delete from member_tb where id = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,password);
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
	
	public int deleteAddress(String address) {
		int rowNum = 0;
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "delete from member_tb address = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,address);
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
	
	public int deletePhone(String phone) {
		int rowNum = 0;
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "delete from member_tb where phone = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,phone);
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
	
	public int deleteZipCode(String zipCode) {
		int rowNum = 0;
		PreparedStatement pstmt = null; 
		try
		{
			String sql = "delete from member_tb where zipCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,zipCode);
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

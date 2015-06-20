//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : GoodsDAO.java
//  @ Date : 2014-05-13
//  @ Author : 양진영
//
//


import java.sql.*;
import java.util.*;

public class GoodsDAO {
	private Connection conn;
	public  GoodsDAO() {
		connect();	
	}
	
	private void connect() {
		try
		{
			conn=DBConnectionPool.getInstance().getConnection();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
	}
	public void disconnect() {
		try
		{
			if(conn!=null)
			{
				conn.close();
				System.out.println("DB와의 접속을 끊었습니다.");
			}
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
	}
	
	public int insert(int goodsCode, int price, int ingredientCode, int storeCode, int originCode, int goodsNum) {
		int rowNum=0;
		PreparedStatement pstmt=null;
		try
		{
			String sql="INSERT INTO goods_tb VALUES(?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,goodsCode);
			pstmt.setInt(2,price);
			pstmt.setInt(3,ingredientCode);
			pstmt.setInt(4,storeCode);
			pstmt.setInt(5,originCode);
			pstmt.setInt(6,goodsNum);
			rowNum=pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	
	public GoodsList selectAll() {
		GoodsList tmp=new GoodsList();
		GoodsDTO dto=null;
		PreparedStatement pstmt=null;
		try
		{
			String sql="SELECT * FROM goods_tb";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				dto=new GoodsDTO(rs.getInt("goodsCode"),rs.getInt("price"),rs.getInt("ingredientCode")
					,rs.getInt("storeCode"),rs.getInt("originCode"),rs.getInt("goodsNum"));
				tmp.addGoodsList(dto);
			}
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return tmp;
	}
	
	public GoodsDTO selectGoodsCode(int goodsCode) {
		GoodsDTO dto=null;
		PreparedStatement pstmt=null;
		try
		{
			String sql="SELECT * FROM goods_tb WHERE goodsCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,goodsCode);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
					dto=new GoodsDTO(rs.getInt("goodsCode"),rs.getInt("price"),rs.getInt("ingredientCode")
					,rs.getInt("storeCode"),rs.getInt("originCode"),rs.getInt("goodsNum"));	
			}
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return dto;
	}
	
	public GoodsList selectPrice(int price) {
		GoodsList tmp=new GoodsList();
		GoodsDTO dto=null;
		PreparedStatement pstmt=null;
		try
		{
			String sql="SELECT * FROM goods_tb WHERE price=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,price);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				dto=new GoodsDTO(rs.getInt("goodsCode"),rs.getInt("price"),rs.getInt("ingredientCode")
					,rs.getInt("storeCode"),rs.getInt("originCode"),rs.getInt("goodsNum"));
				tmp.addGoodsList(dto);
			}
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return tmp;
	}
	
	public GoodsList selectStoreCode(int storeCode) {
		GoodsList tmp=new GoodsList();
		GoodsDTO dto=null;
		PreparedStatement pstmt=null;
		try
		{
			String sql="SELECT * FROM goods_tb WHERE storeCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,storeCode);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				dto=new GoodsDTO(rs.getInt("goodsCode"),rs.getInt("price"),rs.getInt("ingredientCode")
					,rs.getInt("storeCode"),rs.getInt("originCode"),rs.getInt("goodsNum"));
				tmp.addGoodsList(dto);
			}
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return tmp;
	}
	
	public GoodsList selectOriginCode(int originCode) {
		GoodsList tmp=new GoodsList();
		GoodsDTO dto=null;
		PreparedStatement pstmt=null;
		try
		{
			String sql="SELECT * FROM goods_tb WHERE originCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,originCode);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				dto=new GoodsDTO(rs.getInt("goodsCode"),rs.getInt("price"),rs.getInt("ingredientCode")
					,rs.getInt("storeCode"),rs.getInt("originCode"),rs.getInt("goodsNum"));
				tmp.addGoodsList(dto);
			}
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return tmp;
	}
	
	public GoodsList selectIngredientCode(int ingredientCode) {
		GoodsList tmp=new GoodsList();
		GoodsDTO dto=null;
		PreparedStatement pstmt=null;
		try
		{
			String sql="SELECT * FROM goods_tb WHERE ingredientCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,ingredientCode);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				dto=new GoodsDTO(rs.getInt("goodsCode"),rs.getInt("price"),rs.getInt("ingredientCode")
					,rs.getInt("storeCode"),rs.getInt("originCode"),rs.getInt("goodsNum"));
				tmp.addGoodsList(dto);
			}
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return tmp;
	}
	
	public GoodsList selectGoodsNum(int goodsNum) {
		GoodsList tmp=new GoodsList();
		GoodsDTO dto=null;
		PreparedStatement pstmt=null;
		try
		{
			String sql="SELECT * FROM goods_tb WHERE goodsNum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,goodsNum);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				dto=new GoodsDTO(rs.getInt("goodsCode"),rs.getInt("price"),rs.getInt("ingredientCode")
					,rs.getInt("storeCode"),rs.getInt("originCode"),rs.getInt("goodsNum"));
				tmp.addGoodsList(dto);
			}
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return tmp;
	}
	
	public int updateAll(int goodsCode, int price, int ingredientCode, int storeCode, int originCode, int goodsNum) {
		int rowNum=0;
		PreparedStatement pstmt=null;
		try
		{
			String sql="UPDATE goods_tb SET price=?,ingredientCode=?,storeCode=?,originCode=?,goodsNum=? WHERE goodsCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,price);
			pstmt.setInt(2,ingredientCode);
			pstmt.setInt(3,storeCode);
			pstmt.setInt(4,originCode);
			pstmt.setInt(5,goodsNum);
			pstmt.setInt(6,goodsCode);
			rowNum=pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	
	public int updatePrice(int goodsCode, int price) {
		int rowNum=0;
		PreparedStatement pstmt=null;
		try
		{
			String sql="UPDATE goods_tb SET price=? WHERE goodsCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,price);
			pstmt.setInt(2,goodsCode);
			rowNum=pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	
	public int updateStoreCode(int goodsCode, int storeCode) {
		int rowNum=0;
		PreparedStatement pstmt=null;
		try
		{
			String sql="UPDATE goods_tb SET storeCode=? WHERE goodsCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,storeCode);
			pstmt.setInt(2,goodsCode);
			rowNum=pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	
	public int updateOriginCode(int goodsCode, int originCode) {
		int rowNum=0;
		PreparedStatement pstmt=null;
		try
		{
			String sql="UPDATE goods_tb SET originCode=? WHERE goodsCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,originCode);
			pstmt.setInt(2,goodsCode);
			rowNum=pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	
	public int updateIngredientCode(int goodsCode, int ingredientCode) {
		int rowNum=0;
		PreparedStatement pstmt=null;
		try
		{
			String sql="UPDATE goods_tb SET ingredientCode=? WHERE goodsCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,ingredientCode);
			pstmt.setInt(2,goodsCode);
			rowNum=pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	
	public int updateGoodsNum(int goodsCode, int goodsNum) {
		int rowNum=0;
		PreparedStatement pstmt=null;
		try
		{
			String sql="UPDATE goods_tb SET goodsNum=? WHERE goodsCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,goodsNum);
			pstmt.setInt(2,goodsCode);
			rowNum=pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	
	public int deleteAll() {
		int rowNum=0;
		PreparedStatement pstmt=null;
		try
		{
			String sql="DELETE FROM goods_tb";
			pstmt=conn.prepareStatement(sql);
			rowNum=pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	
	public int deleteGoodsCode(int goodsCode) {
		int rowNum=0;
		PreparedStatement pstmt=null;
		try
		{
			String sql="DELETE FROM goods_tb WHERE goodsCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,goodsCode);		
			rowNum=pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	
	public int deletePrice(int price) {
		int rowNum=0;
		PreparedStatement pstmt=null;
		try
		{
			String sql="DELETE FROM goods_tb WHERE price=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,price);		
			rowNum=pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	
	public int deleteStoreCode(int storeCode) {
		int rowNum=0;
		PreparedStatement pstmt=null;
		try
		{
			String sql="DELETE FROM goods_tb WHERE storeCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,storeCode);		
			rowNum=pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	
	}
	
	public int deleteOriginCode(int originCode) {
		int rowNum=0;
		PreparedStatement pstmt=null;
		try
		{
			String sql="DELETE FROM goods_tb WHERE originCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,originCode);		
			rowNum=pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	
	public int deleteIngredientCode(int ingredientCode) {
		int rowNum=0;
		PreparedStatement pstmt=null;
		try
		{
			String sql="DELETE FROM goods_tb WHERE ingredientCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,ingredientCode);		
			rowNum=pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	
	public int deleteGoodsNum(int goodsNum) {
		int rowNum=0;
		PreparedStatement pstmt=null;
		try
		{
			String sql="DELETE FROM goods_tb WHERE goodsNum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,goodsNum);		
			rowNum=pstmt.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
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
		this.conn=conn;	
	}
}

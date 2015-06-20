// 김대곤
import java.sql.*;

public class SecondCategoryDAO
{
	private Connection conn;

	public SecondCategoryDAO()
	{
		connect();
	}	
	private void connect()
	{
		try{
			conn=DBConnectionPool.getInstance().getConnection();
			System.out.println("연결이 성공적으로 이루어졌습니다.");
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
	}
	public void disconnect()
	{
		try{
			conn.close();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
	}
	public Connection getConn()
	{
		return conn;
	}
	public void setConn(Connection conn)
	{
		this.conn=conn;
	}

	public int insert(int secondCategoryCode, String secondCategoryName, int firstCategoryCode)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="insert into secondCategory_tb  values(?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, secondCategoryCode);
			pstmt.setString(2, secondCategoryName);
			pstmt.setInt(3, firstCategoryCode);
			rowNum=pstmt.executeUpdate();
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			try{
				if(pstmt!=null)
					pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}	
		return rowNum;	
	}
	public SecondCategoryList selectAll()
	{
		SecondCategoryList list=new SecondCategoryList();
		PreparedStatement pstmt=null;

		try{
			String sql="SELECT * FROM secondCategory_tb";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int secondCategoryCode=rs.getInt("secondCategoryCode");
				String secondCategoryName=rs.getString("secondCategoryName");
				int firstCategoryCode=rs.getInt("firstCategoryCode");
				list.addSecondCategoryList(new SecondCategoryDTO(secondCategoryCode, secondCategoryName, firstCategoryCode));
			}
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			try{
				if(pstmt!=null)
					pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		return list;
	}
	
	public SecondCategoryDTO selectSecondCategoryCode(int secondCategryCode)
	{
		SecondCategoryDTO secondCategoryDTO=null;
		PreparedStatement pstmt=null;

		try{
			String sql="SELECT * FROM secondcategory_tb WHERE secondCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, secondCategryCode);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int secondCategoryCode1=rs.getInt("secondCategoryCode");
				String secondCategoryName=rs.getString("secondCategoryName");
				int firstCategoryCode=rs.getInt("firstCategoryCode");
				secondCategoryDTO=new SecondCategoryDTO(secondCategoryCode1, secondCategoryName, firstCategoryCode);
			}
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			try{
				if(pstmt!=null)
					pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		return secondCategoryDTO;
	}
	public SecondCategoryList selectSecondCategoryName(String secondCategryName)
	{
		SecondCategoryList list=new SecondCategoryList();
		PreparedStatement pstmt=null;

		try{
			String sql="SELECT * FROM secondcategory_tb WHERE secondName LIKE '%?%'";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, secondCategryName);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int secondCategoryCode=rs.getInt("secondCategoryCode");
				String secondCategoryName1=rs.getString("secondCategoryName");
				int firstCategoryCode=rs.getInt("firstCategoryCode");
				list.addSecondCategoryList(new SecondCategoryDTO(secondCategoryCode, secondCategoryName1, firstCategoryCode));
			}
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			try{
				if(pstmt!=null)
					pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		return list;
	}
	public SecondCategoryList selectFirstCategoryCode(int firstCategoryCode)
	{
		SecondCategoryList list=new SecondCategoryList();
		PreparedStatement pstmt=null;

		try{
			String sql="SELECT * FROM secondcategory_tb WHERE firstCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, firstCategoryCode);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int secondCategoryCode=rs.getInt("secondCategoryCode");
				String secondCategoryName=rs.getString("secondCategoryName");
				int firstCategoryCode1=rs.getInt("firstCategoryCode");
				list.addSecondCategoryList(new SecondCategoryDTO(secondCategoryCode, secondCategoryName, firstCategoryCode1));
			}
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			try{
				if(pstmt!=null)
					pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		return list;
	}
	public int updateAll(int secondCategoryCode, String secondCategoryName, int firstCategoryCode)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="update secondcategory_tb set secondCategoryName=?, firstCode=?  where secondcode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, secondCategoryCode);
			pstmt.setString(2, secondCategoryName);
			pstmt.setInt(3, firstCategoryCode);
			rowNum=pstmt.executeUpdate();
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			try{
				if(pstmt!=null)
					pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	public int updateSecondCategoryName(int secondCategoryCode, String secondCategoryName)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="update secondcategory_tb set secondCategoryName=? where secondcode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, secondCategoryName);
			pstmt.setInt(2, secondCategoryCode);
			rowNum=pstmt.executeUpdate();
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			try{
				if(pstmt!=null)
					pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	public int updateFirstCategoryCode(int secondCategoryCode, int firstCategoryCode)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="UPDATE secondcategory_tb SET firstcode=? WHERE secondcode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, firstCategoryCode);
			pstmt.setInt(2, secondCategoryCode);
			rowNum=pstmt.executeUpdate();
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			try{
				if(pstmt!=null)
					pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	public int deleteAll()
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="delete from secondcategory_tb";
			pstmt=conn.prepareStatement(sql);
			rowNum=pstmt.executeUpdate();
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			try{
				if(pstmt!=null)
					pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	public int deleteSecondCategoryCode(int secondCategoryCode)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="DELETE FROM secondcategory_tb WHERE secondcode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, secondCategoryCode);
			rowNum=pstmt.executeUpdate();
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			try{
				if(pstmt!=null)
					pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	public int deleteFirstCategoryCode(int firstCategoryCode)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="DELETE FROM secondcategory_tb WHERE firstCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, firstCategoryCode);
			rowNum=pstmt.executeUpdate();
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			try{
				if(pstmt!=null)
					pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	public int deleteSecondCategoryName(String secondCategoryName)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="DELETE FROM secondcategory_tb WHERE secondname LIKE '%?%'";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, secondCategoryName);
			rowNum=pstmt.executeUpdate();
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			try{
				if(pstmt!=null)
					pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
}

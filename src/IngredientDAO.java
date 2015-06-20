// 김대곤
import java.sql.*;

public class IngredientDAO
{
	private Connection conn;

	public IngredientDAO()
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

	public int insert(int ingredientCode, String ingredientName, String unit)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="insert into ingredient_tb  values(?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ingredientCode);
			pstmt.setString(2, ingredientName);
			pstmt.setString(3, unit);
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
	public IngredientList selectAll()
	{
		IngredientList list=new IngredientList();
		PreparedStatement pstmt=null;

		try{
			String sql="SELECT * FROM ingredient_tb";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int ingredientCode=rs.getInt("ingredientCode");
				String ingredientName=rs.getString("ingredientName");
				String unit=rs.getString("unit");
				list.addIngredientList(new IngredientDTO(ingredientCode, ingredientName, unit));
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
	public IngredientDTO selectMaxIngredientCode()
	{
		IngredientDTO ingredientDTO=null;
		PreparedStatement pstmt=null;

		try{
			String sql="select * from Ingredient_tb where ingredientCode = (select MAX(ingredientCode ) from Ingredient_tb)";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int ingredientCode1=rs.getInt("ingredientCode");
				String ingredientName=rs.getString("ingredientName");
				String unit=rs.getString("unit");
				ingredientDTO=new IngredientDTO(ingredientCode1, ingredientName, unit);
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
		return ingredientDTO;
	}
	public IngredientDTO selectIngredientCode(int ingredientCode)
	{
		IngredientDTO ingredientDTO=null;
		PreparedStatement pstmt=null;

		try{
			String sql="SELECT * FROM ingredient_tb WHERE ingredientCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ingredientCode);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int ingredientCode1=rs.getInt("ingredientCode");
				String ingredientName=rs.getString("ingredientName");
				String unit=rs.getString("unit");
				ingredientDTO=new IngredientDTO(ingredientCode1, ingredientName, unit);
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
		return ingredientDTO;
	}
	public IngredientDTO seleteName(String ingredientName)
	{
		IngredientDTO ingredientDTO=null;
		PreparedStatement pstmt=null;

		try{
			String sql="SELECT * FROM ingredient_tb WHERE ingredientName=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ingredientName);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int ingredientCode1=rs.getInt("ingredientCode");
				String iName = rs.getString("ingredientName");
				String unit=rs.getString("unit");
				ingredientDTO=new IngredientDTO(ingredientCode1, iName, unit);
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
		return ingredientDTO;
	}
	public IngredientList selecteIngredientName(String ingredientName)
	{
		IngredientList list=new IngredientList();
		PreparedStatement pstmt=null;

		try{
			String sql="SELECT * FROM ingredient_tb WHERE ingredientName LIKE '%?%'";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ingredientName);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int ingredientCode=rs.getInt("ingredientCode");
				String ingredientName1=rs.getString("ingredientName");
				String unit=rs.getString("unit");
				list.addIngredientList(new IngredientDTO(ingredientCode, ingredientName1, unit));
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
	public IngredientList seleteUnit(String unit)
	{
		IngredientList list=new IngredientList();
		PreparedStatement pstmt=null;

		try{
			String sql="SELECT * FROM ingredient_tb WHERE unit = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, unit);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int ingredientCode=rs.getInt("ingredientCode");
				String ingredientName=rs.getString("ingredientName");
				String unit1=rs.getString("unit");
				list.addIngredientList(new IngredientDTO(ingredientCode, ingredientName, unit1));
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
	public int updateAll(int ingredientCode, String ingredientName, String unit)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="update ingredient_tb set ingredientName=?, unit=?  where ingredientCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ingredientName);
			pstmt.setString(2, unit);
			pstmt.setInt(3, ingredientCode);
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
	public int updateIngredientName(int ingredientCode, String ingredientName)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="UPDATE ingredient_tb SET ingredientname=? WHERE ingredientcode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ingredientName);
			pstmt.setInt(2, ingredientCode);
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
	public int updateIngredientUnit(int ingredientCode, String ingredientUnit)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="UPDATE ingredient_tb SET ingredientunit=? WHERE ingredientcode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ingredientUnit);
			pstmt.setInt(2, ingredientCode);
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
			String sql="delete from ingredient_tb";
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
	public int deleteIngredientCode(int ingredientCode)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="DELETE FROM ingredient_tb WHERE ingredientcode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ingredientCode);
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
	public int deleteIngredientName(String ingredientName)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="DELETE FROM ingredient_tb WHERE ingredientName LIKE '%?%'";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ingredientName);
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
	public int deleteUnit(String unit)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="DELETE FROM ingredient_tb WHERE unit=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, unit);
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
	public Connection getConn()
	{
		return conn;
	}
	public void setConn(Connection conn)
	{
		this.conn=conn;
	}
}

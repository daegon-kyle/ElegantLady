// 김대곤
import java.sql.*;

public class FoodDAO
{
	private Connection conn;

	public FoodDAO()
	{
		connect();
	}

	public Connection getConn()
	{
		return conn;
	}
	public void setConn(Connection conn)
	{
		this.conn=conn;
	}
	
	private void connect()
	{
		DBConnectionPool obj = DBConnectionPool.getInstance();
		try
		{
			conn =obj.getConnection();
			System.out.println("연결이 성공적으로 이루어졌습니다.");
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void disconnect()
	{
		try{
			if(conn != null)
			{
				conn.close();
				System.out.println("DB와의 접속을 끊었습니다.");
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	public FoodList selectAll()
	{
		FoodList list=new FoodList();
		PreparedStatement pstmt=null;

		try{
			String sql="SELECT * FROM food_Tb";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int foodCode=rs.getInt("foodcode");
				String foodName=rs.getString("foodname");
				String foodIntro=rs.getString("foodintro");
				String foodPhoto=rs.getString("foodphoto");
				int foodCal=rs.getInt("foodcal");
				String id=rs.getString("id");
				list.addFoodList(new FoodDTO(foodCode, foodName, foodIntro, foodPhoto, foodCal, id));
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
	public FoodDTO selectMaxFoodCode()
	{
		FoodDTO foodDTO = null;
		PreparedStatement pstmt=null;
		
		try{
			String sql="select * from food_tb where foodCode = (select MAX(foodCode) from food_tb)";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int foodCode1=rs.getInt("foodcode");
				String foodName=rs.getString("foodname");
				String foodIntro=rs.getString("foodintro");
				String foodPhoto=rs.getString("foodphoto");
				int foodCal=rs.getInt("foodcal");
				String id=rs.getString("id");
				
				foodDTO=new FoodDTO(foodCode1, foodName, foodIntro, foodPhoto, foodCal, id);
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
		return foodDTO;
	}
	public FoodDTO selectFoodCode(int foodCode)
	{
		FoodDTO foodDTO = null;
		PreparedStatement pstmt=null;

		try{
			String sql="SELECT * FROM food_tb WHERE foodcode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, foodCode);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int foodCode1=rs.getInt("foodcode");
				String foodName=rs.getString("foodname");
				String foodIntro=rs.getString("foodintro");
				String foodPhoto=rs.getString("foodphoto");
				int foodCal=rs.getInt("foodcal");
				String id=rs.getString("id");
				foodDTO=new FoodDTO(foodCode1, foodName, foodIntro, foodPhoto, foodCal, id);
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
		return foodDTO;
	}
	public FoodList selectFoodName(String foodName)
	{
		FoodList list=new FoodList();
		PreparedStatement pstmt=null;

		try{
			String sql="SELECT * FROM food_tb WHERE foodName LIKE '%?%'";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, foodName);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int foodCode=rs.getInt("foodcode");
				String foodName1=rs.getString("foodname");
				String foodIntro=rs.getString("foodintro");
				String foodPhoto=rs.getString("foodphoto");
				int foodCal=rs.getInt("foodcal");
				String id=rs.getString("id");
				list.addFoodList(new FoodDTO(foodCode, foodName1, foodIntro, foodPhoto, foodCal, id));
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
	public FoodDTO selectFoodIntro(String foodIntro)
	{
		FoodDTO foodDTO=null;
		PreparedStatement pstmt=null;

		try{
			String sql="SELECT * FROM food_tb WHERE foodintro LIKE '%?%'";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, foodIntro);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int foodCode=rs.getInt("foodcode");
				String foodName=rs.getString("foodname");
				String foodIntro1=rs.getString("foodintro");
				String foodPhoto=rs.getString("foodphoto");
				int foodCal=rs.getInt("foodcal");
				String id=rs.getString("id");
				foodDTO=new FoodDTO(foodCode, foodName, foodIntro1, foodPhoto, foodCal, id);
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
		return foodDTO;
	}
	public FoodDTO selectFoodPhoto(String foodPhoto)
	{
		FoodDTO foodDTO=null;
		PreparedStatement pstmt=null;

		try{
			String sql="SELECT * FROM food_tb WHERE foodPhoto=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, foodPhoto);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int foodCode=rs.getInt("foodcode");
				String foodName=rs.getString("foodname");
				String foodIntro=rs.getString("foodintro");
				String foodPhoto1=rs.getString("foodphoto");
				int foodCal=rs.getInt("foodcal");
				String id=rs.getString("id");
				foodDTO=new FoodDTO(foodCode, foodName, foodIntro, foodPhoto1, foodCal, id);
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
		return foodDTO;
	}
	public FoodList selectFoodCal(int foodCal)
	{
		FoodList list=new FoodList();
		PreparedStatement pstmt=null;

		try{
			String sql="SELECT * FROM food_tb WHERE foodCal = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, foodCal);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int foodCode=rs.getInt("foodcode");
				String foodName=rs.getString("foodname");
				String foodIntro=rs.getString("foodintro");
				String foodPhoto=rs.getString("foodphoto");
				int foodCal1=rs.getInt("foodcal");
				String id=rs.getString("id");
				list.addFoodList(new FoodDTO(foodCode, foodName, foodIntro, foodPhoto, foodCal1, id));
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
	public FoodList selectFoodId(String foodId)
	{
		FoodList list=new FoodList();
		PreparedStatement pstmt=null;

		try{
			String sql="SELECT * FROM food_tb WHERE foodName LIKE '%?%'";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, foodId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int foodCode=rs.getInt("foodcode");
				String foodName1=rs.getString("foodname");
				String foodIntro=rs.getString("foodintro");
				String foodPhoto=rs.getString("foodphoto");
				int foodCal=rs.getInt("foodcal");
				String id=rs.getString("id");
				list.addFoodList(new FoodDTO(foodCode, foodName1, foodIntro, foodPhoto, foodCal, id));
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
	public int insert(int foodCode, String foodName, String foodIntro, String foodPhoto, int foodCal, String id)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="insert into food_tb values (?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, foodCode);
			pstmt.setString(2, foodName);
			pstmt.setString(3, foodIntro);
			pstmt.setString(4, foodPhoto);
			pstmt.setInt(5, foodCal);
			pstmt.setString(6, id);
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
	public int updateFoodName(int foodCode, String foodName)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;
		
		try{
			String sql="update food_tb set foodName=? where foodCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, foodName);
			pstmt.setInt(2, foodCode);
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
	public int updateFoodIntro(int foodCode, String foodIntro)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;
		
		try{
			String sql="update food_tb set foodIntro=? where foodCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, foodIntro);
			pstmt.setInt(2, foodCode);
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
	public int updateFoodPhoto(int foodCode, String foodPhoto)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;
		
		try{
			String sql="update food_tb set foodPhoto=? where foodCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, foodPhoto);
			pstmt.setInt(2, foodCode);
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
	public int updateFoodCal(int foodCode, int foodCal)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;
		
		try{
			String sql="update food_tb set foodCal=? where foodCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, foodCal);
			pstmt.setInt(2, foodCode);
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
	public int updateId(int foodCode, String id)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;
		
		try{
			String sql="update food_tb set id=? where foodCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, foodCode);
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
	public int updateAll(int foodCode, String foodName, String foodIntro, int foodCal, String id)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="update food_tb set foodName=?, foodIntro=? , foodCal=? , id=? where foodCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, foodName);
			pstmt.setString(2, foodIntro);
			pstmt.setInt(3, foodCal);
			pstmt.setString(4, id);
			pstmt.setInt(5, foodCode);
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
	public int deleteFoodCode(int foodCode)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="delete from food_tb where foodCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, foodCode);
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
	public int deleteFoodName(String foodName)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="delete from food_tb where foodName LIKE '%?%'";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, foodName);
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
	public int deleteFoodIntro(String foodIntro)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="delete from food_tb where foodIntro LIKE '%?%'";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, foodIntro);
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
	public int deleteFoodPhoto(String foodPhoto)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="delete from food_tb where foodPhoto=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, foodPhoto);
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
	public int deleteFoodCal(int foodCal)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="delete from food_tb where foodCal=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, foodCal);
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
	public int deleteId(String id)
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="delete from food_tb where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
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
	public int deleteAll()
	{
		int rowNum=0;
		PreparedStatement pstmt=null;

		try{
			String sql="delete from food_tb;";
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
}

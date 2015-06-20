//  @ Date : 2014/4/29
//  @ Author : 김대곤
//로그인 하기
//
public class LoginContorller
{
	private String id;
	private String password;

	public LoginContorller()
	{
		this("","");
	}
	public LoginContorller(String id, String password)
	{
		this.id=id;
		this.password=password;
	}
	
	public MemberInfo acceptLogin()
	{
		MemberInfo tmp=MemberInfoList.searchMemberInfo(id);
		//null인 경우, id존재하지 않으므로 실패, null반환
		if(tmp==null)
			return null;
		//받아온 객체와 비번이 같으면 객체 반환
		if(tmp.getPassword().equals(password))
		{
			LoginInfo.setLoginState(true);
			return tmp;
		}
		//비번 같지 않으면 실패, null반환
		return null;
	}
	
	public String getId()
	{
		return id;
	}
	public String getPassword()
	{
		return password;
	}
	public void setId(String id)
	{
		this.id=id;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
}

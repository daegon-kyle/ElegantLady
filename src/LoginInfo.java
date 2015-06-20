/*
�ۼ��ڸ� : ����
Ŭ������ : �α�������
*/
public class LoginInfo 
{
	private String id;
	private String password;
	private static boolean loginState;

	static{
		LoginInfo.loginState=false;
		//false �α��� �Ǿ� ���� ����
		//true �α��� �Ǿ� ����
	}

	public LoginInfo()
	{
		this("","");
	}
	public LoginInfo(String id, String password)
	{
		this.id=id;
		this.password=password;
	}

	public String getId()
	{
		return id;
	}
	public String getPassword()
	{
		return password;
	}
	public static boolean getLoginState()
	{
		return loginState;
	}
	public void setId(String id)
	{
		this.id=id;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public static void setLoginState(boolean loginState)
	{
		LoginInfo.loginState=loginState;
	}
}

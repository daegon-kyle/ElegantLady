//  @ Date : 2014/4/29
//  @ Author : ����
//�α��� �ϱ�
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
		//null�� ���, id�������� �����Ƿ� ����, null��ȯ
		if(tmp==null)
			return null;
		//�޾ƿ� ��ü�� ����� ������ ��ü ��ȯ
		if(tmp.getPassword().equals(password))
		{
			LoginInfo.setLoginState(true);
			return tmp;
		}
		//��� ���� ������ ����, null��ȯ
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

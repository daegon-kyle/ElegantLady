//  @ Date : 2014/4/29
//  @ Author : 김대곤
// 아이디 유효성검사
//
public class IdCheckController
{
	private String id;
	public IdCheckController()
	{
		this("");
	}
	public IdCheckController(String id)
	{
		this.id=id;
	}

	public boolean verifyId()	//아이디 유효성 검사하는 메소드
	{
		if(MemberInfoList.searchMemberInfo(id)!=null)
		{
			return true;	//존재한다.
		}
		return false;
	}

	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id=id;
	}
}

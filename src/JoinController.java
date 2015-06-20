//  @ Date : 2014/4/29
//  @ Author : 김대곤
//회원가입
//
public class JoinController
{
	private MemberInfo memberInfo;
	public JoinController()
	{
		this(new MemberInfo());
	}
	
	public JoinController(MemberInfo memberInfo)
	{
		this.memberInfo=memberInfo;
	}
	
	public boolean addMember()		//회원목록에 회원을 추가하는 메소드
	{
		if(MemberInfoList.addMemberInfoList(memberInfo)!=null)
		{
			MemberFileSaveController saveCtrl = new MemberFileSaveController("MemberInfoData.txt",memberInfo);
			saveCtrl.writeMemberInfo();
			return true;
		}
		return false;
	}
	
	public MemberInfo getMemberInfo()
	{
		return memberInfo;
	}
	public void setMemberInfo(MemberInfo memberInfo)
	{
		this.memberInfo=memberInfo;
	}
}

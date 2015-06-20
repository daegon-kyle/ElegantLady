//  @ Date : 2014/5/13
//  @ Author : 김대곤
//회원가입
//
public class JoinDBController
{
	private MemberInfo memberInfo;
	public JoinDBController()
	{
		this(new MemberInfo());
	}
	
	public JoinDBController(MemberInfo memberInfo)
	{
		this.memberInfo=memberInfo;
	}
	
	public boolean addMember()		//회원목록에 회원을 추가하는 메소드
	{
		if(MemberInfoList.addMemberInfoList(memberInfo)!=null)
		{
			MemberInfoList.addMemberInfoList(memberInfo);				//static리스트에 회원 추가
			new MemberDAO().insert(memberInfo.getId(), memberInfo.getName(), memberInfo.getPassword(), memberInfo.getAddress(), memberInfo.getPhone(), "448-768");//DB에 회원추가하기
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

//  @ Date : 2014/4/29
//  @ Author : ����
//ȸ������
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
	
	public boolean addMember()		//ȸ����Ͽ� ȸ���� �߰��ϴ� �޼ҵ�
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

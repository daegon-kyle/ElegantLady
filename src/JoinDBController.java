//  @ Date : 2014/5/13
//  @ Author : ����
//ȸ������
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
	
	public boolean addMember()		//ȸ����Ͽ� ȸ���� �߰��ϴ� �޼ҵ�
	{
		if(MemberInfoList.addMemberInfoList(memberInfo)!=null)
		{
			MemberInfoList.addMemberInfoList(memberInfo);				//static����Ʈ�� ȸ�� �߰�
			new MemberDAO().insert(memberInfo.getId(), memberInfo.getName(), memberInfo.getPassword(), memberInfo.getAddress(), memberInfo.getPhone(), "448-768");//DB�� ȸ���߰��ϱ�
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

//  @ Date : 2014/4/29
//  @ Author : ����
// ���̵� ��ȿ���˻�
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

	public boolean verifyId()	//���̵� ��ȿ�� �˻��ϴ� �޼ҵ�
	{
		if(MemberInfoList.searchMemberInfo(id)!=null)
		{
			return true;	//�����Ѵ�.
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

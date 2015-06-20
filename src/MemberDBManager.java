//������
import java.util.*;
public class MemberDBManager
{
	private MemberDAO memberDAO;
	public MemberDBManager()
	{
		this.memberDAO=new MemberDAO();
	}
	public MemberDBManager(MemberDAO memberDAO)
	{
		this.memberDAO=memberDAO;
	}
	public MemberDAO getMemberDAO()
	{
		return memberDAO;
	}
	public void setMemberDAO(MemberDAO memberDAO)
	{
		this.memberDAO=memberDAO;
	}
	public void loadMemberInfoList()
	{
		MemberList tmp = memberDAO.selectAll();
		LinkedList<MemberDTO> memberList=(LinkedList<MemberDTO>)tmp.getMemberList();
		for(MemberDTO temp: memberList)
		{
			MemberInfo memberInfo=new MemberInfo(temp.getName(),temp.getId(),temp.getPassword(),temp.getAddress(),temp.getPhone(),temp.getZipCode());
			MemberInfoList.addMemberInfoList(memberInfo);
		}
		
	}
} 

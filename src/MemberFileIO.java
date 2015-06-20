/*
	�ۼ���  : ��ȫ��
	Class�� : MemberFileIO
*/
import java.io.*;

public class MemberFileIO 
{
	private MemberInfo memberInfo; //ȸ������ ��ü
	
	//------------------------ constructor ------------------
	public MemberFileIO()
	{
		this(new MemberInfo());
	}
	public MemberFileIO(MemberInfo memberInfo)
	{
		this.memberInfo = memberInfo;
	}
	
	//------------------------ get/set ----------------------

	public MemberInfo getMemberInfo()
	{
		return this.memberInfo;
	}
	public void setMemberInfo(MemberInfo memberInfo)
	{
		this.memberInfo = memberInfo;
	}
	
	//------------------------ instance Method --------------

	public void readMember()
	{
		BufferedReader reader; 
		try
		{
			reader = new BufferedReader(new FileReader("MemberInfoData.txt"));

			while(true)
			{
				String name = reader.readLine();
				MemberInfo member = new MemberInfo();
				if(name == null){break;}
				member.setName(name);		//�̸��Է�	
				member.setId(reader.readLine());		//���̵��Է�
				member.setPassword(reader.readLine());  //��й�ȣ�Է�
				member.setAddress(reader.readLine());   //�ּ��Է�
				member.setPhone(reader.readLine());     //����ó�Է�
				member.setZipCode(reader.readLine());   //�����ȣ�Է�
	
				MemberInfoList.addMemberInfoList(member);	//Static Class�� MemberInfoList�� �߰�.
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void writerMember()
	{

	}
	public void load()
	{

	}
}

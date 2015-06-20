/*
	작성자  : 박홍근
	Class명 : MemberFileIO
*/
import java.io.*;

public class MemberFileIO 
{
	private MemberInfo memberInfo; //회원정보 객체
	
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
				member.setName(name);		//이름입력	
				member.setId(reader.readLine());		//아이디입력
				member.setPassword(reader.readLine());  //비밀번호입력
				member.setAddress(reader.readLine());   //주소입력
				member.setPhone(reader.readLine());     //연락처입력
				member.setZipCode(reader.readLine());   //우편번호입력
	
				MemberInfoList.addMemberInfoList(member);	//Static Class인 MemberInfoList에 추가.
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

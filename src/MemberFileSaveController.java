import java.io.*;
class MemberFileSaveController 
{
	private String fileName;
	private MemberInfo memberInfo;

	public MemberFileSaveController()
	{
		this("MemberInfoData.txt",new MemberInfo());
	}
	public MemberFileSaveController(String fileName,MemberInfo memberInfo)
	{
		this.fileName = fileName;
		this.memberInfo = memberInfo;
	}
	public void writeMemberInfo()
	{
		BufferedWriter writer = null;
		try
		{
			writer = new BufferedWriter(new FileWriter(fileName,true));
			writer.write(memberInfo.getName());
			writer.newLine();
			writer.write(memberInfo.getId());
			writer.newLine();
			writer.write(memberInfo.getPassword());
			writer.newLine();
			writer.write(memberInfo.getAddress());
			writer.newLine();
			writer.write(memberInfo.getPhone());
			writer.newLine();
			writer.write("우편번호");
			writer.newLine();
		}
		catch (IOException ioe)
		{
		}
		finally
		{
			try
			{
				writer.close();
			}
			catch (Exception e)
			{
				System.out.println("file close Exception");
			}
		}
	}

}

/*
�ۼ��ڸ� : ����
Ŭ������ : ���̵�
*/
public enum Level
{
	EASY("����"),NORMAL("����"),HARD("�����");
	private final String level;
	private Level(String level)
	{
		this.level=level;
	}
	public String value()
	{
		return this.level;
	}
}
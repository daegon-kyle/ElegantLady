/*
작성자명 : 김대곤
클래스명 : 난이도
*/
public enum Level
{
	EASY("쉬움"),NORMAL("보통"),HARD("어려움");
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
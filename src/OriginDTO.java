//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : OriginDTO.java
//  @ Date : 2014-05-13
//  @ Author : ������
//
//




public class OriginDTO {
	private int originCode;
	private String originName;
	public OriginDTO() {
		this(0,"");
	}
	
	public OriginDTO(int originCode, String originName) {
		this.originCode=originCode;
		this.originName=originName;
	}
	
	public int getOriginCode() {
		return originCode;
	}
	
	public String getOriginName() {
		return originName;
	}
	
	public void setOriginCode(int originCode) {
		this.originCode=originCode;
	}
	
	public void setOriginCode(String originName) {
		this.originName=originName;
	}
	
	public String toString() {
		return originCode+"/"+originName;
	}
}

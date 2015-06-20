
//  @ Project : Untitled
//  @ File Name : MemberDTO.java
//  @ Date : 2014-05-13
//  @ Author : ±è¿µÇÑ
//
//




public class MemberDTO {
	private String id;
	private String name;
	private String password;
	private String address;
	private String phone;
	private String zipCode;
	public MemberDTO() {
		this("","","","","","");
	}
	
	public MemberDTO(String id, String name, String password, String address, String phone, String zipCode) {
		this.id = id; 
		this.name = name;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.zipCode = zipCode;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getZipCode() {
		return zipCode;
	}

	public void setId(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public void setAddress(String address){
		this.address = address;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public void setZipCode(String zipCode){
		this.zipCode = zipCode;
	}
	
	public String toString() {
		return "id : "+id+"name : "+name+"password : "+password+"address : "+address+"phone : "+phone+"zipCode : "+zipCode;
	}
}

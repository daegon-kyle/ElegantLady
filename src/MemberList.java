
//  @ Project : Untitled
//  @ File Name : MemberList.java
//  @ Date : 2014-05-13
//  @ Author : ±è¿µÇÑ
//
//



import java.util.*;
public class MemberList {
	private Collection<MemberDTO> memberList;
	public MemberList() {
		memberList = new LinkedList<MemberDTO>();
	}
	
	public MemberList(Collection<MemberDTO> memberList) {
		this.memberList = memberList;
	}
	
	public MemberDTO addMemberList(MemberDTO memberDTO) {
		memberList.add(memberDTO);
		return memberDTO;
	}
	
	public MemberDTO removeMemberList(MemberDTO memberDTO) {
		memberList.remove(memberDTO);
		return memberDTO;
	}
	
	public MemberDTO reviseMemberList(MemberDTO exMemberDTO, MemberDTO newMemberDTO) {
		int index = ((LinkedList<MemberDTO>)memberList).indexOf(exMemberDTO);
		if(index != -1){
			((LinkedList<MemberDTO>)memberList).set(index,newMemberDTO);
			return newMemberDTO;
		}
		return null;
	}
	
	public MemberDTO searchMemberList(MemberDTO memberDTO) {
		for(MemberDTO dto : memberList)
		{
			if(dto.getId() == memberDTO.getId()){
				return dto;
			}
		}
		return null;
	}
	public Collection<MemberDTO> getMemberList()
	{
		return memberList;
	}
	public void setMemberList(Collection<MemberDTO> memberList)
	{
		this.memberList=memberList;
	}
}

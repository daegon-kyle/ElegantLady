//  @ File Name : MemberInfoList.java
//  @ Date : 2014-04-28
//  @ Author : ±è¿µÇÑ
//
//

import java.util.*;
public class MemberInfoList {
	private static Collection<MemberInfo> memberInfoList;
	static
	{
		memberInfoList = new LinkedList<MemberInfo>();
	}
	public static Collection<MemberInfo> getList() {
		return memberInfoList;
	}
	
	public static void setList(Collection<MemberInfo> list) {
		MemberInfoList.memberInfoList = memberInfoList;
	}
	
	public static MemberInfo addMemberInfoList(MemberInfo memberInfo) {
		memberInfoList.add(memberInfo);
		return memberInfo;
	}

	public static MemberInfo reviseMemberInfoList(String memberCode, MemberInfo memberInfo){
		MemberInfo mem = MemberInfoList.searchMemberInfo(memberCode);
		if(mem != null)
		{
			int index = ((LinkedList<MemberInfo>)memberInfoList).indexOf(memberInfo);
			if(index != -1)
			{
				((LinkedList<MemberInfo>)memberInfoList).set(index,memberInfo);
				return memberInfo;
			}
		}
		return null;
	}
	
	public static MemberInfo reviseMemberInfoList(MemberInfo oldMemberInfo, MemberInfo newMemberInfo) {
		int index = ((LinkedList<MemberInfo>)memberInfoList).indexOf(oldMemberInfo);
		if(index != -1)
		{
			((LinkedList<MemberInfo>)memberInfoList).set(index,newMemberInfo);
			return newMemberInfo;
		}
		return null;
	}

	public static Collection<MemberInfo> searchMemberInfoList(String memberName){
		LinkedList<MemberInfo> list = new LinkedList<MemberInfo>();
		for(MemberInfo memberInfo : memberInfoList)
		{
			if(memberInfo.getName().equals(memberName))
				list.add(memberInfo);
		}
		return list;
	}
	
	public static MemberInfo searchMemberInfo(String memberID) {
		System.out.println(memberID);
		Iterator<MemberInfo> iterator = memberInfoList.iterator();
		while(iterator.hasNext())
		{
			MemberInfo memberInfo = iterator.next();
			if(memberInfo.getId().equals(memberID))
				return memberInfo;
		}
		return null;
	}
	
	public static MemberInfo removeMemberInfoList(String memberID) {
		MemberInfo memberInfo = searchMemberInfo(memberID);
		if(memberInfo != null)
		{
			memberInfoList.remove(memberInfo);
			return memberInfo;
		}
		return null;
	}
}


//  @ Project : Untitled
//  @ File Name : FirstCategoryList.java
//  @ Date : 2014-05-13
//  @ Author : ±è¿µÇÑ
//
//



import java.util.*;
public class FirstCategoryList {
	private Collection<FirstCategoryDTO> firstCategoryList;
	public FirstCategoryList() {
		firstCategoryList = new LinkedList<FirstCategoryDTO>();
	}
	
	public FirstCategoryList(Collection<FirstCategoryDTO> firstCategoryList) {
		this.firstCategoryList = firstCategoryList;
	}
	
	public FirstCategoryDTO addFirstCategoryList(FirstCategoryDTO firstCategoryDTO) {
		firstCategoryList.add(firstCategoryDTO);
		return firstCategoryDTO;
	}
	
	public FirstCategoryDTO removeFirstCategoryList(FirstCategoryDTO firstCategoryDTO) {
		firstCategoryList.remove(firstCategoryDTO);
		return firstCategoryDTO;
	}
	
	public FirstCategoryDTO reviseFirstCategoryList(FirstCategoryDTO exFirstCategoryDTO, FirstCategoryDTO newFirstCategoryDTO) {
		int index = ((LinkedList<FirstCategoryDTO>) firstCategoryList).indexOf(exFirstCategoryDTO);
		if(index != -1){
			((LinkedList<FirstCategoryDTO>)firstCategoryList).set(index,newFirstCategoryDTO);
			return newFirstCategoryDTO;
		}
		return null;
	}
	
	public FirstCategoryDTO searchFirstCategoryList(FirstCategoryDTO firstCategoryDTO) {
		for(FirstCategoryDTO dto : firstCategoryList)
		{
			if(dto.getFirstCategoryCode() == firstCategoryDTO.getFirstCategoryCode()){
				return dto;
			}
		}
		return null;
	}
	public Collection<FirstCategoryDTO> getFirstCategoryList()
	{
		return firstCategoryList;
	}
	public void setFirstCategoryList(Collection<FirstCategoryDTO> firstCategoryList)
	{
		this.firstCategoryList=firstCategoryList;
	}
}

import java.util.*;
class IngredSrchController
{
	private String ingred1;
	private String ingred2;
	private String ingred3;

	public IngredSrchController() {}
	public IngredSrchController(String ingred1, String ingred2, String ingred3)
	{
		this.ingred1 = ingred1;
		this.ingred2 = ingred2;
		this.ingred3 = ingred3;
	}
	public String getIngred1() {
		return ingred1;
	}
	public String getIngred2() {
		return ingred2;
	}
	public String getIngred3() {
		return ingred3;
	}
	public void setIngred1(String ingred1){
		this.ingred1 = ingred1;
	}
	public void setIngred2(String ingred2){
		this.ingred2 = ingred2;
	}
	public void setIngred3(String ingred3){
		this.ingred3 = ingred3;
	}
	public Collection<FoodRecipeInfo> search(){
		Collection<FoodRecipeInfo> list = FoodRecipeInfoList.searchFoodRecipeInfoList(ingred1,ingred2,ingred3);
		if(list != null)
			return list;
		return null;
	//	return FoodRecipeInfo.search(ingred1,ingred2,ingred3);
	}
}

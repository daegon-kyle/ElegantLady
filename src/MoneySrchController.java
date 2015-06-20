import java.util.*;
class MoneySrchController 
{
	private String money1;
	private String money2;
	public MoneySrchController () {
		this("","");
	}
	public MoneySrchController (String money1, String money2){
		this.money1 = money1;
		this.money2 = money2;
	}
	public String getMoney1(){ 
		return this.money1;
	}
	public String getMoney2() {
		return this.money2;
	}
	public void setMoney1(String money1){
		this.money1 = money1;
	}
	public void setMoney2(String money2){
		this.money2 = money2;
	}
	public Collection<FoodRecipeInfo> search()
	{
		LinkedList<FoodRecipeInfo> result = new LinkedList<FoodRecipeInfo>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		ArrayList<String> soldName = new ArrayList<String>();
		ArrayList<Double> soldPrice = new ArrayList<Double>();

		Collection<FoodRecipeInfo> list = FoodRecipeInfoList.getFoodRecipeInfoList();
		System.out.println(list.size());
		for(FoodRecipeInfo foodRecipeInfo : list)
		{
			for(RecipeIngreInfo recipeIngreInfo :foodRecipeInfo.getRecipeInfo().getRecipeIngreInfoList().getRecipeIngreInfoList())
			{
				name.add(recipeIngreInfo.getIngredientName());
				num.add(Integer.valueOf(recipeIngreInfo.getIngredientNum()));
			}
			for(SoldItemInfo soldItemInfo :((LinkedList<StoreItemInfo>)(StoreItemInfoList.getStoreItemInfoList())).get(0).getSoldItemInfoList().getSoldItemInfoList())
			{
				soldName.add(soldItemInfo.getSoldItemName());
				soldPrice.add(Double.valueOf(soldItemInfo.getPrice()));
			}
			double money = calPrice(name,num,soldName,soldPrice);
			if(money>= Double.parseDouble(money1) && money <= Double.parseDouble(money2)){
				result.add(foodRecipeInfo);
				System.out.println(money);
			}
			name.clear();
			num.clear();
			soldName.clear();
			soldPrice.clear();
		}
		return result;
	}

	public double calPrice(ArrayList<String> ingred1, ArrayList<Integer> ingredNum, ArrayList<String> ingred2, ArrayList<Double> price)
	{
		double tempMoney= 0;
		int cnt = ingred1.size();
		for(int i=0 ; i<ingred1.size(); i++)
		{
			for(int j=0; j<ingred2.size(); j++)
			{
				if(ingred1.get(i).equals(ingred2.get(j)))
				{
					tempMoney += ingredNum.get(i).intValue() * price.get(i).doubleValue();
					cnt--;
				}
			}
		}
		if(cnt > 0) { return -1; }
		return tempMoney;
	}

					



}

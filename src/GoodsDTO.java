//양진영
//판매물품
public class GoodsDTO
{
	private int goodsCode;
	private int price;
	private int ingredientCode;
	private int storeCode;
	private int originCode;
	private int goodsNum;

	public GoodsDTO()
	{
		this(0,0,0,0,0,0);
	}
	public GoodsDTO(int goodsCode, int price, int ingredientCode, int storeCode, int originCode, int goodsNum)
	{
		this.ingredientCode=ingredientCode;
		this.goodsNum=goodsNum;
		this.goodsCode=goodsCode;
		this.price=price;
		this.storeCode=storeCode;
		this.originCode=originCode;
	}
	public int getGoodsCode()
	{
		return this.goodsCode;
	}
	public int getPrice()
	{
		return this.price;
	}
	public int getStoreCode()
	{
		return this.storeCode;
	}
	public int getOriginCode()
	{
		return this.originCode;
	}
	public int getIngredientCode()
	{
		return this.ingredientCode;
	}
	public int getGoodsNum()
	{
		return this.goodsNum;
	}
	public void setIngredientCode(int ingredientCode)
	{
		this.ingredientCode=ingredientCode;
	}
	public void setGoodsNum(int goodsNum)
	{
		this.goodsNum=goodsNum;
	}
	public void setGoodsCode(int goodsCode)
	{
		this.goodsCode=goodsCode;
	}
	public void setPrice(int price)
	{
		this.price=price;
	}
	public void setStoreCode(int storeCode)
	{
		this.storeCode=storeCode;
	}
	public void setOriginCode(int originCode)
	{
		this.originCode=originCode;
	}
	public String toString()
	{
		return goodsCode+"/"+price+"/"+ingredientCode+"/"+storeCode+"/"+originCode+"/"+goodsNum;
	}
}

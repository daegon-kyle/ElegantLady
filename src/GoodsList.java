import java.util.*;
public class GoodsList 
{
	private Collection<GoodsDTO> goodsList;

	public GoodsList()
	{
		this(new LinkedList<GoodsDTO>());
	}
	public GoodsList(Collection<GoodsDTO> goodsList)
	{
		this.goodsList=goodsList;
	}
	public GoodsDTO addGoodsList(GoodsDTO goodsDTO)
	{
		if(goodsList.add(goodsDTO))
			return goodsDTO;
		else
			return null;
	}
	public GoodsDTO removeGoodsList(GoodsDTO goodsDTO)
	{
		if(goodsList.remove(goodsDTO))
			return goodsDTO;
		else
			return null;
	}
	public GoodsDTO reviseGoodsList(GoodsDTO exGoodsDTO,GoodsDTO newGoodsDTO)
	{
		int i=0;
		for(GoodsDTO tmp:goodsList)
		{
			if(tmp.getGoodsCode()==exGoodsDTO.getGoodsCode())
			{
				((LinkedList<GoodsDTO>)goodsList).set(i,newGoodsDTO);
				return tmp;
			}
			i++;
		}
		return null;
	}
	public GoodsDTO searchGoodsLIst(GoodsDTO goodsDTO)
	{
		for(GoodsDTO tmp:goodsList)
		{
			if(tmp.getGoodsCode()==goodsDTO.getGoodsCode())
				return tmp;
		}
		return null;
	}
	public Collection<GoodsDTO> getGoodsList()
	{
		return goodsList;
	}
	public void setGoodsList(Collection<GoodsDTO> goodsList)
	{
		this.goodsList=goodsList;
	}
}

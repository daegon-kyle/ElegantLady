
//  @ File Name : 
//  @ Date : 2014-05-13
//  @ Author : ±è¿µÇÑ

import java.util.*;
public class StoreItemDBManager {
	private StoreInfoList storeInfoList;
	public StoreItemDBManager() {
		this(new StoreInfoList());
	}
	
	public StoreItemDBManager(StoreInfoList storeInfoList) {
		this.storeInfoList = storeInfoList;
	}
	
	public void readStoreInfo() {
		StoreDAO dao = new StoreDAO();
		StoreList list = dao.selectAll();
		for(StoreDTO sd : list.getStoreList())
		{
			StoreInfo storeInfo = new StoreInfo();
			storeInfo.setStoreName(sd.getStoreName());
			storeInfo.setStoreCode(Integer.toString(sd.getStoreCode()));
			storeInfo.setStoreAddress(sd.getStoreAddress());
			storeInfo.setStorePhone(sd.getStorePhone());
			storeInfoList.addStoreInfoList(storeInfo);
		}
		dao.disconnect();
	}
	
	public void readStoreItemInfoList() {
		SoldItemInfoList soldItemInfoList = new SoldItemInfoList();

		GoodsDAO goodsDAO = new GoodsDAO();
		GoodsList goodsList = goodsDAO.selectAll();
		IngredientDAO ingredientDAO = new IngredientDAO();
		OriginDAO orginDAO = new OriginDAO();

		for(GoodsDTO gd : goodsList.getGoodsList())
		{
			StoreInfo storeInfo = storeInfoList.searchStoreInfo(Integer.toString(gd.getStoreCode()));
			SoldItemInfo soldItemInfo = new SoldItemInfo();
			soldItemInfo.setSoldItemName(ingredientDAO.selectIngredientCode(gd.getIngredientCode()).getIngredientName());
			soldItemInfo.setSoldItemCode(Integer.toString(gd.getIngredientCode()));
			soldItemInfo.setSoldItemNum(gd.getGoodsNum());
			soldItemInfo.setPlaceOfOrisin(orginDAO.selectOriginCode(gd.getOriginCode()).getOriginName());
			soldItemInfo.setPrice(gd.getPrice());
			
			if(storeInfo != null) { 
				soldItemInfoList.addSoldItemInfoList(soldItemInfo);
				
				StoreItemInfo storeItemInfo = new StoreItemInfo();
				
				storeItemInfo.setStoreInfo(storeInfo);
				storeItemInfo.setSoldItemInfoList(soldItemInfoList);
				StoreItemInfoList.addStoreItemInfoList(storeItemInfo);
			}
		}
		goodsDAO.disconnect();
		orginDAO.disconnect();
	}
}

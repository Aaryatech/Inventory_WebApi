package com.inventory.webapi.model;

import java.io.Serializable;
import java.util.List;


public class ItemList implements Serializable{
	
	List<TallyItem> itemList;

    Info info;

	public List<TallyItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<TallyItem> itemList) {
		this.itemList = itemList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "ItemList [itemList=" + itemList + ", info=" + info + "]";
	}
    
    
	
}

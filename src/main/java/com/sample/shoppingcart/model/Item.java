package com.sample.shoppingcart.model;

public class Item
{
	private String itemName;
	private double itemPrice;
	private int itemQuantity;

	public String getItemName()
	{
		return itemName;
	}

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	public double getItemPrice()
	{
		return itemPrice;
	}

	public void setItemPrice(double itemPrice)
	{
		this.itemPrice = itemPrice;
	}

	public int getItemQuantity()
	{
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity)
	{
		this.itemQuantity = itemQuantity;
	}

	public Item(String itemName, double itemPrice, int itemQuantity)
	{
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
	}

	public Item()
	{
	}

}

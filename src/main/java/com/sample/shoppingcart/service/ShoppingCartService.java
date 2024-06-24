package com.sample.shoppingcart.service;

import com.sample.shoppingcart.model.Item;

import java.util.List;

public interface ShoppingCartService
{
	void addItemToCart(Item item);

	List<Item> getCartItems();

}

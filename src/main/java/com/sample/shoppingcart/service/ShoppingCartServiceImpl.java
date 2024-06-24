package com.sample.shoppingcart.service;

import com.sample.shoppingcart.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService
{
	private final List<Item> cartItems = new ArrayList<>();

	public void addItemToCart(Item item) {
		cartItems.add(item);
	}

	public List<Item> getCartItems() {
		return cartItems;
	}
}

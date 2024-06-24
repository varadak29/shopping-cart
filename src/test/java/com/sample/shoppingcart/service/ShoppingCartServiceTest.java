package com.sample.shoppingcart.service;

import com.sample.shoppingcart.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartServiceTest {

	private ShoppingCartService shoppingCartService;

	@BeforeEach
	public void setUp() {
		shoppingCartService = new ShoppingCartServiceImpl();
	}

	@Test
	public void testAddItemToCart() {
		Item item = new Item();
		item.setItemName("Avacado");
		item.setItemPrice(1.15);
		item.setItemQuantity(4);
		shoppingCartService.addItemToCart(item);

		List<Item> items = shoppingCartService.getCartItems();
		assertEquals(1, items.size());
		assertEquals("Avacado", items.get(0).getItemName());
		assertEquals(1.15, items.get(0).getItemPrice());
		assertEquals(4, items.get(0).getItemQuantity());
	}

	@Test
	public void testGetCartItems() {

		Item item1 = new Item();
		item1.setItemName("Avacado");
		item1.setItemPrice(1.15);
		item1.setItemQuantity(4);

		Item item2 = new Item();
		item2.setItemName("Milk");
		item2.setItemPrice(5.79);
		item2.setItemQuantity(1);

		shoppingCartService.addItemToCart(item1);
		shoppingCartService.addItemToCart(item2);

		List<Item> items = shoppingCartService.getCartItems();
		assertEquals(2, items.size());
		assertTrue(items.stream().anyMatch(item -> item.getItemName().equals("Avacado")));
		assertTrue(items.stream().anyMatch(item -> item.getItemName().equals("Milk")));
	}
}

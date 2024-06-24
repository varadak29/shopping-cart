package com.sample.shoppingcart.controller;

import com.sample.shoppingcart.model.Item;
import com.sample.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@RequestMapping(value = "/api/cart/add", method = { RequestMethod.POST })
	public ResponseEntity<String> addItemToCart(@RequestBody Item item) {
		shoppingCartService.addItemToCart(item);
		return ResponseEntity.ok("Item successfully added to cart");
	}

	@RequestMapping(value = "/api/cart/items", method = { RequestMethod.GET })
	public List<Item> getCartItems() {
		return shoppingCartService.getCartItems();
	}
}

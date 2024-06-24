package com.sample.shoppingcart.controller;

import com.sample.shoppingcart.model.Item;
import com.sample.shoppingcart.service.ShoppingCartServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(ShoppingCartController.class)
@AutoConfigureMockMvc
public class ShoppingCartControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ShoppingCartServiceImpl shoppingCartServiceMock;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testAddItemToCart_Success() throws Exception {

		Item item = new Item();
		item.setItemName("Avacado");
		item.setItemPrice(1.15);
		item.setItemQuantity(4);

		String response = "Item successfully added to cart";

		RequestBuilder request = MockMvcRequestBuilders.post("/api/cart/add")
													   .contentType(MediaType.APPLICATION_JSON)
													   .content(objectMapper.writeValueAsString(item));
		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().string(response)).andReturn();
	}

	@Test
	public void testGetCartItems_Success() throws Exception {

		Item item1 = new Item();
		item1.setItemName("Avacado");
		item1.setItemPrice(1.15);
		item1.setItemQuantity(4);

		Item item2 = new Item();
		item2.setItemName("Milk");
		item2.setItemPrice(5.79);
		item2.setItemQuantity(1);

		List<Item> response = new ArrayList<>();
		response.add(item1);
		response.add(item2);

		when(shoppingCartServiceMock.getCartItems()).thenReturn(response);

		RequestBuilder request = MockMvcRequestBuilders.get("/api/cart/items")
													   .contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(request)
			   .andExpect(status().isOk())
			   .andExpect(content().string(objectMapper.writeValueAsString(response)))
			   .andReturn();

	}
}

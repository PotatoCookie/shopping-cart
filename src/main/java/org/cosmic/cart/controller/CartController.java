/**
 * 
 */
package org.cosmic.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.cosmic.cart.model.Item;
import org.cosmic.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Viknes
 *
 */

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cartService;

	@ResponseBody
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public List<Item> getAllItems() {
		/*List<Item> items = new ArrayList<Item>();
		Item item = new Item();
		item.setName("Watch");
		item.setQty(2);
		item.setPrice(75.99);
		item.setItemId(1);
		item.setDescription("A fossil watch!");
		items.add(item);
		item = new Item();
		item.setName("Gear");
		item.setQty(1);
		item.setPrice(299.99);
		item.setItemId(2);
		item.setDescription("Samsung Galaxy Gear!");
		items.add(item);*/
		return cartService.getAllItems();
	}
	
	@ResponseBody
	@RequestMapping(value="/get/{itemId}", method = RequestMethod.GET)
	public Item getItem(@PathVariable(value="itemId") final String itemId) {
		return cartService.getItem(Integer.parseInt(itemId));
	}
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addItem(@RequestBody Item item, HttpServletResponse response) {
		cartService.addItem(item);
		response.setStatus(HttpStatus.OK.value());
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateItem(@RequestBody Item item, HttpServletResponse response) {
		cartService.updateItem(item);
		response.setStatus(HttpStatus.OK.value());
	}
	
	@ResponseBody
	@RequestMapping(value="/remove/{itemId}", method = RequestMethod.DELETE)
	public void removeItem(@PathVariable(value="itemId") final String itemId,
			HttpServletResponse response) {
		cartService.deleteItem(Integer.parseInt(itemId));
		response.setStatus(HttpStatus.OK.value());
	}
	
}

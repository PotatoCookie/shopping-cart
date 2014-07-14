/**
 * 
 */
package org.cosmic.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.cosmic.cart.model.Item;
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

	@ResponseBody
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public List<Item> getAllItems() {
		return new ArrayList<Item>();
	}
	
	@ResponseBody
	@RequestMapping(value="/get/{itemId}", method = RequestMethod.GET)
	public Item getItem(@PathVariable(value="itemId") final String itemId) {
		Item item = new Item();
		item.setName("Watch");
		item.setQty(2);
		item.setPrice(75.99);
		item.setItemId(1);
		item.setDescription("A fossil watch!");
		return item;
	}
	
	@ResponseBody
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public void addItem(@RequestBody Item item, HttpServletResponse response) {
		response.setStatus(HttpStatus.OK.value());
	}
	
}

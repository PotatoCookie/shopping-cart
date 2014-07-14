/**
 * 
 */
package org.cosmic.cart.service;

import java.util.List;

import org.cosmic.cart.dao.CartDAOImpl;
import org.cosmic.cart.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Viknes
 *
 */
@Service(value="cartService")
public class CartService {

	@Autowired
	CartDAOImpl itemsDB;
	
	public List<Item> getAllItems() {
		return itemsDB.getAll();
	}
	
	public Item getItem(int id) {
		return itemsDB.getById(id);
	}
	
	public void addItem(Item item) {
		itemsDB.save(item);
	}
	
	public void updateItem(Item item) {
		itemsDB.update(item);
	}
	
	public void deleteItem(int id) {
		itemsDB.deleteById(id);
	}
}

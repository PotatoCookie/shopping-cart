/**
 * 
 */
package org.cosmic.cart.dao;

import java.util.List;

import org.cosmic.cart.model.Item;

/**
 * @author Viknes
 *
 */
public interface CartDAO {

	public void save(Item item);
    public Item getById(int id);
    public void update(Item item);
    public void deleteById(int id);
    public List<Item> getAll();

}

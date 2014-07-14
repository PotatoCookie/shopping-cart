/**
 * 
 */
package org.cosmic.cart.model;

import java.io.Serializable;

/**
 * @author Viknes
 *
 */
public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4937774456590812080L;
	
	private int itemId;
	private String name;
	private int qty;
	private double price;
	private String description;
	
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}

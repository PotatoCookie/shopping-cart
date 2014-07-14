/**
 * 
 */
package org.cosmic.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.cosmic.cart.model.Item;

/**
 * @author Viknes
 * 
 */
public class CartDAOImpl implements CartDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Item item) {
		String query = "insert into Item (id, name, qty, price, description) values (?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, item.getItemId());
			ps.setString(2, item.getName());
			ps.setInt(3, item.getQty());
			ps.setDouble(4, item.getPrice());
			ps.setString(5, item.getDescription());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Item getById(int id) {
		String query = "select * from Item where id = ?";
		Item item = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				item = new Item();
				item.setItemId(id);
				item.setName(rs.getString("name"));
				item.setQty(Integer.parseInt(rs.getString("qty")));
				item.setPrice(Double.parseDouble(rs.getString("price")));
				item.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return item;
	}

	@Override
	public void update(Item item) {
		String query = "update Item set name=?, qty=?, price=?, description=? where id=?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, item.getName());
			ps.setInt(2, item.getQty());
			ps.setDouble(3, item.getPrice());
			ps.setString(4, item.getDescription());
			ps.setInt(5, item.getItemId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteById(int id) {
		String query = "delete from Item where id=?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Item> getAll() {
		String query = "select * from Item";
		List<Item> items = new ArrayList<Item>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Item item = new Item();
				item.setItemId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setQty(Integer.parseInt(rs.getString("qty")));
				item.setPrice(Double.parseDouble(rs.getString("price")));
				item.setDescription(rs.getString("description"));
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}

}

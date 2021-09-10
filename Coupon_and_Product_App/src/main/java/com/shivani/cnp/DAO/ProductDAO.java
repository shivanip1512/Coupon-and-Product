package com.shivani.cnp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shivani.cnp.Model.Product;
import com.shivani.cnp.Util.ConnectionUtil;

public class ProductDAO {
	public void save(Product product) {
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("insert into product (name, description, price) values (?,?,?)");
			prepareStatement.setString(1, product.getName());
			prepareStatement.setString(2, product.getDescription());
			prepareStatement.setBigDecimal(3, product.getPrice());
			int update = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

package com.shivani.cnp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shivani.cnp.Model.Coupon;
import com.shivani.cnp.Util.ConnectionUtil;

public class CouponDAO {
	public void save(Coupon coupon) {
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = connection
					.prepareStatement("insert into coupon (code, discount, exp_date) values (?,?,?)");
			statement.setString(1, coupon.getCode());
			statement.setBigDecimal(2, coupon.getDiscount());
			statement.setString(3, coupon.getExpDate());

			int update = statement.executeUpdate();

			if (update > 0) {

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Coupon findByCouponCode(String code) {
		Coupon coupon = new Coupon();
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from coupon where code=?");
			statement.setString(1, code);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				coupon.setId(rs.getInt(1));
				coupon.setCode(code);
				coupon.setDiscount(rs.getBigDecimal(3));
				coupon.setExpDate(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coupon;
	}
}

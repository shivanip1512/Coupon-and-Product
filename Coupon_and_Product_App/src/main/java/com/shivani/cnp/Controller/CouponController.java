package com.shivani.cnp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shivani.cnp.DAO.CouponDAO;
import com.shivani.cnp.Model.Coupon;

/**
 * Servlet implementation class CouponController
 */
@WebServlet("/COUPONS")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CouponDAO couponDAO = new CouponDAO();

	public CouponController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String couponCode = request.getParameter("couponCode");
		String discount = request.getParameter("discount");
		String expiryDate = request.getParameter("expiryDate");

		Coupon coupon = new Coupon();
		coupon.setCode(couponCode);
		coupon.setExpDate(expiryDate);
		coupon.setDiscount(new BigDecimal(discount));

		couponDAO.save(coupon);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Coupon Created!</b>");
		out.print("<br><a href='/Coupon_and_Product_App'>Home</a>");

	}

}

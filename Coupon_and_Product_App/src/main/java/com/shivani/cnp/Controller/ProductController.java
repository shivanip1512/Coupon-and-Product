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
import com.shivani.cnp.DAO.ProductDAO;
import com.shivani.cnp.Model.Coupon;
import com.shivani.cnp.Model.Product;

/**
 * Servlet implementation class CouponController
 */
@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();
	private CouponDAO couponDAO = new CouponDAO();

	public ProductController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String couponCode = request.getParameter("couponCode");
		
		Coupon coupon = couponDAO.findByCouponCode(couponCode);
		BigDecimal discount = coupon.getDiscount();
		BigDecimal finalPrice = (new BigDecimal(price)).subtract(discount);

		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(finalPrice);

		productDAO.save(product);
		PrintWriter out = response.getWriter();
		out.println("<b>Product Created !!!</b>");
		out.println("<a href='/Coupon_and_Product_App'>Home</a>");
	}

}

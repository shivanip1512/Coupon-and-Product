<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Product</title>
</head>
<body>
	<h1>Create Product</h1>
	<form action="product" method="post">
		<pre>
Product Name : <input type="text" name="name"><br>
Description : <input type="text" name="description"><br>
Coupon Code : <input type="text" name="couponCode"><br>
Price : <input type="text" name="price"><br>
<input type="submit" value="Save">
</pre>
	</form>
</body>
</html>
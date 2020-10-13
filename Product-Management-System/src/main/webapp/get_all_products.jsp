
<%@page import="com.zensar.models.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Product[] list = (Product[]) request.getAttribute("allProducts");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Products</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="jumbotron jumbotron-fluid p-5 mt-5">
			<div>
				<table class=" table table-dark">
					<thead class="">
						<tr class="">
							<th scope="col">Product Id</th>
							<th scope="col">Product Name</th>
							<th scope="col">Product Price</th>
							<th scope="col">Delete</th>
							<th scope="col">Update</th>
						</tr>
						<tr class="bg-danger">

							<!-- -----------------------For loop to iterate over Product array------------------ -->
							<%
								for (int i = 0; (i < list.length && list[i] != null); i++) {
							%>
						
						<tr class="bg-info">
							<th scope="col"><%=list[i].getProductId()%></th>
							<th scope="col"><%=list[i].getProductName()%></th>
							<th scope="col">Rs. <%=list[i].getProductCost()%></th>
							<form action="delete" method="post">
								<input type="hidden" name="product-id" id="delete-item"
									value="<%=list[i].getProductId()%>" />
								<th scope="col">
									<button class="btn btn-danger" type="submit">Delete</button>
								</th>
							</form>
							<form action="update" method="get">
								<input type="hidden" name="product-id" id="orderid"
									value="<%=list[i].getProductId()%>" /> <input type="hidden"
									name="product-name" id="orderprice"
									value="<%=list[i].getProductName()%>" /> <input type="hidden"
									name="product-price" id="orderquantity"
									value="<%=list[i].getProductCost()%>" />
								<th scope="col">
									<button class="btn btn-danger" type="submit">Update</button>
								</th>
							</form>
						</tr>
						<%
							}
						%>
						</tr>
					</thead>
				</table>
			</div>
			<div class="add">
            	<a href="logout" class="back">Logout</a>
            </div>
            <br>
			<div class="add">
				<a href="menu.jsp" class="back">please click here to go back</a>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>
<%@page import="com.zensar.models.Product"%>
<%
	Product list = (Product) request.getAttribute("product");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Update Product</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>

    <div class="container">
        <div class="row mt-5 ">
            <div class="col-xl-4"></div>
            <div class="col-xl-4 jumbotron jumbotron-fluid p-4">
                <h2 class="text-center">Update Product</h2>
                <form  action="update" method="post" >
                    <div class="form-group">
                        <input type="hidden" id="orderid"class="form-control"  placeholder="Enter product id"
                            name="product-id" required="required"  value="<%=list.getProductId()%>">
                        <p id="username-msg"></p>
                    </div>
                    <div class="form-group">
                        <label for="orderid">Product id</label>
                        <input type="number" id="orderid"class="form-control"  placeholder="Enter product id"
                            name="productid" required="required"  value="<%=list.getProductId()%>" disabled="disabled">
                        <p id="username-msg"></p>
                    </div>
                    <div class="form-group">
                        <label for="orderprice">Product Name</label>
                        <input type="text" class="form-control" id="orderprice" placeholder="Enter product name"
                            name="product-name"  required="required" value="<%=list.getProductName()%> ">
                        <p id="password-msg"></p>
                    </div>
                    <div class="form-group">
                        <label for="orderquantity">Product Price</label>
                        <input type="number" class="form-control" id="orderquantity" placeholder="Enter product cost"
                            name="product-cost" required="required"  value="<%=list.getProductCost()%>">
                        <p id="password-msg"></p>
                    </div>
                    <div class="add">
                        <a href="menu.jsp" class="back">Don't want to update product, please click here to go back</a>
                    </div>
                    <br>
					<div class="add">
						<a href="logout" class="back">Logout</a>
					</div>
					<br>
					<button class="btn btn-primary" type="submit" >Update Product</button>
                </form>
            </div>
            <div class="col-xl-4"></div>
        </div>
    </div>
	<!-- <script type="text/javascript" src="javascripts/default-values.js"></script> -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
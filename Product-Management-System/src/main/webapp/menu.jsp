<!DOCTYPE html>
<html lang="en">

<head>
    <title>Product Management System</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>

    <div class="container">
        <div class="row mt-5 ">
			<div class="col-xl-2"></div>
			<div class="col-xl-8">
				<div class=" jumbotron jumbotron-fluid text-center">
                <h2 class="text-center">Welcome to Product Management System</h2>
				<div class="mt-4"
					style="display: inline-flex;">
					<input class="mb-2 form-group ml-3 bg-primary text-light"
						type="button" onclick="location.href='add_product.html';"
						value="Add Product" style="float: right;" /> 
						<input class="mb-2 form-group ml-3 bg-primary text-light"
						type="button" onclick="location.href='delete_product.html';" value="Delete Product"
						style="float: right;" />
						<input class="mb-2 form-group ml-3 bg-primary text-light"
						type="button" onclick="location.href='allproducts';" value="Get All Products"
						style="float: right;" />
						<input class="mb-2 form-group ml-3 bg-primary text-light"
						type="button" onclick="location.href='get_product.html';" value="Get Product"
						style="float: right;" />
						<input class="mb-2 form-group ml-3 bg-primary text-light"
						type="button" onclick="location.href='logout';" value="Logout"
						style="float: right;" />
				</div>
			</div>
				
			</div>
			<div class="col-xl-2"></div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
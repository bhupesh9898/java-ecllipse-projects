<!DOCTYPE html>
<html lang="en">

<head>
    <title>User Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>

    <div class="container">
        <div class="row mt-5 ">
            <div class="col-xl-4"></div>
            <div class="col-xl-4 jumbotron jumbotron-fluid p-4">
                <h2 class="text-center">User Login</h2>
                <form  action="login" method="post" >
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="username" id="username"class="form-control"  placeholder="Enter mail id as a username"
                            name="username" required="required" oninput="">
                        <p id="username-msg"></p>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" placeholder="Enter password"
                            name="password" required="required" oninput="">
                        <p id="password-msg"></p>
                    </div>
                    <div class="register">
                        <a href="register.html" class="register">Not a registered user, please register here</a>
                    </div>
                    <br>
                    <button class="btn btn-primary" type="submit" >Login</button>
                </form>
            </div>
            <div class="col-xl-4"></div>
        </div>
    </div>
	<!-- <script type="text/javascript" src="javascripts/index.js"></script> -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
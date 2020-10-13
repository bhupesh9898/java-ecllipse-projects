
// Method to validate password
function validatePassword() {
	var x = document.getElementById("password").value;
	if (x.length < 6) {
		document.getElementById("password-msg").style.color = "red";
		document.getElementById("password-msg").innerHTML = "Password must be atleast 6 characters long";
		return false;
	} else {
		document.getElementById("password-msg").innerHTML = "";
		return true;
	}
}


// Method to validate confirm password
function validateConfirmPassword() {
	var x = document.getElementById("confirm-password").value;
	if (x.length < 6) {
		document.getElementById("confirm-password-msg").style.color = "red";
		document.getElementById("confirm-password-msg").innerHTML = "Confirm Password must be atleast 6 characters long";
		return false;
	} else {
		var pass1 = document.getElementById("password").value;
		var pass2 = document.getElementById("confirm-password").value;
		if (pass1 != pass2) {
			document.getElementById("confirm-password-msg").style.color = "red";
			document.getElementById("confirm-password-msg").innerHTML = "Confirm Password must be same as password";
			return false;
		} else {
			document.getElementById("confirm-password-msg").innerHTML = "";
			return true;
		}

	}
}

// Method to validate all form fields
function validateBothPassword() {
	console.log("----------")
	if (validateConfirmPassword() && validatePassword()) {
		console.log("true---");
		return true;
	} else {
		console.log("false---");
		return false;
	}
}
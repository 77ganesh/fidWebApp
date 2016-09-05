<html>
<body>
<h2>FidWebApp</h2>
User ID : <input id="id" type="text" name="id" /> <br>
Password: <input id="pass" type="password" name="pass" /> <br>
<input id="login" type="button" value="Login"/>
<input id="signup" type="button" value="Sign Up" onclick="alert('Yet to implement')" /> <br>
<p id="UserMessage"> </p>
</body>

<script>
document.body.onload = init;

function loginSuccess() {
	window.location="./dash";
}

function init() {
	var loginButton = document.getElementById("login");
	var idInput = document.getElementById("id");
	var passInput = document.getElementById("pass");
	var xhttp = new XMLHttpRequest();
	var messageBox = document.getElementById("UserMessage");
	
	xhttp.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200) {
			var x = this.responseText;
			if (x.trim() == '')
				messageBox.innerHTML = "Login Failed";
			else {
				messageBox.innerHTML = "Login Success. Redirecting";
				loginSuccess();
			}
		}
	}

	loginButton.onclick = function() {
		var object = {id: idInput.value, pass: passInput.value};
		console.log(JSON.stringify(object));
		xhttp.open("POST", "./auth", true);
		xhttp.setRequestHeader("Content-Type", "application/json");
		xhttp.send(JSON.stringify(object));
	}
}
</script>

</html>

<html>
<body>
<h2>FidWebApp - as</h2>
User ID : <input id="id" type="text" name="id" /> <br>
Password: <input id="pass" type="password" name="pass" /> <br>
<input id="login" type="button" value="Login"/>
<input id="signup" type="button" value="Sign Up" /> <br>
DEBUG: Your JSessionID: <%= session.getId() %>
</body>

<script>
document.body.onload = init;

function init() {
	var loginButton = document.getElementById("login");
	var idInput = document.getElementById("id");
	var passInput = document.getElementById("pass");
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200) {
			var x = this.responseText;
			if (x.trim() == '')
				alert("Nothing Found");
			else
				alert(x);
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

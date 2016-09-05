<html>
<body>
<h2>FidWebApp</h2>
User ID : ${myUser.id} <br>
City: <input id="cityIn" type="text" value="${myUser.city}"/> <input id="cityBtn" type="button" value="Update City"/> <br>
Password: <input id="passIn" type="password" value="" /> <input id="passBtn" type="button" value="Update Password"/> <br>
<input id="logout" type="button" value="logout" /> <br>
<p id="UserMessage"> </p>
</body>

<script>
document.body.onload = init;

function init() {
	var cityInput = document.getElementById("cityIn");
	var passInput = document.getElementById("passIn");
	var cityButton = document.getElementById("cityBtn");
	var passButton = document.getElementById("passBtn");
	var logoutButton = document.getElementById("logout");
	var messageBox = document.getElementById("UserMessage");
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200) {
			var x = this.responseText;
			if (x.trim() == '')
				messageBox.innerHTML = "Update Failed";
			else  {
				console.log(x);
				x = JSON.parse(x);
				cityInput.value = x.city;
				passInput.value = "";
				messageBox.innerHTML = "Update Sucess";
			}
			setTimeout( function() {
				messageBox.innerHTML = "";
			}, 3000);
		}
	}

	cityButton.onclick = function() {
		var object = {"id": "${myUser.id}", "city": cityInput.value};
		console.log(JSON.stringify(object));
		xhttp.open("POST", "./updateCity", true);
		xhttp.setRequestHeader("Content-Type", "application/json");
		xhttp.send(JSON.stringify(object));
	}

	passButton.onclick = function() {
		var object = {"id": "${myUser.id}", "pass": passInput.value};
		console.log(JSON.stringify(object));
		xhttp.open("POST", "./updatePass", true);
		xhttp.setRequestHeader("Content-Type", "application/json");
		xhttp.send(JSON.stringify(object));
	}

	logoutButton.onclick = function() {
		xhttp.open("GET", "./logout", false);
		messageBox.innerHTML = "Logged Out. Redirecting..";
		window.location="./";
	}
}
</script>

</html>

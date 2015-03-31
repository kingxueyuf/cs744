function DoSubmit() {
	var username = $("#username").val();
	var role = $("#role").val();
	username = username + ':' + role;
	$("#username").val(username);
	console.log(username);
	document.loginForm.j_username.value = username;
	return true;
}
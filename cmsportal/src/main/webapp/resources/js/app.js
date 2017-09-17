function login(){
	var loginRequestUrl = "/cmsportal/login";
	var userName = $('#userid').val();
	var secret = $('#password').val();
	
	if(userName.length == 0){
		username = "null";
	}
	if(secret.length == 0){
		secret = "null";
	}
	
	var requestBody = {"loginCreds":encryptAndReturn(userName+":"+secret)};
	
	fetch(loginRequestUrl,
			{method: "POST",
			body: JSON.stringify(requestBody),
			headers: {'Content-Type': "application/json"}
	}).then(loginRequestCb).catch(loginErrorCb)
}

function encryptAndReturn(userIDSecret){
	return btoa(userIDSecret);
}

function loginRequestCb(response){
	if (response.status !== 200) {  
		console.log('Looks like there was a problem. Status Code: ' +  
				response.status);  
		return;  
	}
	response.json().then(function(data) {  
		console.log(data);  
		var responseContent = JSON.parse(data.responseContent);
		if(responseContent.authStatus == "success"){
			localStorage.setItem("isLoggedIn",true);
			localStorage.setItem("hashedCode",responseContent.hashedCode);
			redirectLoggedInUser();
		}
	});  
}

function loginErrorCb(){
	console.log('Fetch Error::', err);
}

function addEventHandlers(){
	$("#login").click(function() {
		login();
	});
}

function redirectLoggedInUser(){
	window.location = "/cmsportal/home?who="+localStorage.getItem("hashedCode");
}

function init(){
	addEventHandlers();
	if(localStorage.getItem("isLoggedIn") == "true"){
		redirectLoggedInUser();
	}
}
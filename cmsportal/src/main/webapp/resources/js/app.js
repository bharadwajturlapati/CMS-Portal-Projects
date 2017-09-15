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

function disableBrowserBack(){
	 window.history.forward();
}

function init(){
	disableBrowserBack();
	addEventHandlers();
}
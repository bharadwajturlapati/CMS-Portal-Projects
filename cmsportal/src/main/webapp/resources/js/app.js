disableBrowserBack();
addEventHandlers();
function login(){
	var loginRequestUrl = "/cmsportal/login";
	var userName = $('#userid').val();
	var secret = $('#password').val();
	var formData = new FormData();
	formData.set("logincreds",encryptAndReturn(userName+":"+secret));
	fetch(loginRequestUrl,{method: "POST", body: formData}).then(loginRequestCb).catch(loginErrorCb)
}

function encryptAndReturn(userIDSecret){
	return CryptoJS.SHA256(userIDSecret);
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
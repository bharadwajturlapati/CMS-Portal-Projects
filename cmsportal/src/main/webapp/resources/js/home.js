function logout() {
	localStorage.clear("hashedCode");
	window.location = "/cmsportal/";
}

function addEventHandlers() {
	$("#logout").click(function() {
		logout();
	});
}

function sendLoggedInfoToBackend(){
	
}

function init() {
	addEventHandlers();
	// call various rest controllers to fetch the data and permission.
	// log the activity.
	
}
function logout() {
	localStorage.clear("hashedCode");
	window.location = "/cmsportal/home";
}

function addEventHandlers() {
	$("#logout").click(function() {
		logout();
	});
}
function init() {
	addEventHandlers();
	// call various rest controllers to fetch the data and permission.
}
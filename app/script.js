
	var configs = {
		url: "http://localhost:8080/CXFSample",
		appName: "Teste APP",
		appVersion: "1.0.0-beta",
		serviceVersion: "v1"
	};
	
	var callAppName = function(){
		alert(configs.appName);
	}
	
	var loadResult = function() {
		$.get(configs.url + "/rest/services/v1/test2", function( data ) {
			$("#result").html(data[0].name);
		})
		.done(function() {
			alert( "second success" );
		})
		.fail(function(e) {
			alert( "error" + e);
		})
		.always(function() {
			callAppName();
		});
	}

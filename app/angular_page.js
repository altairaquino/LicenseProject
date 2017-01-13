
var app = angular.module('eu', []);

app.controller('euControlo', function ($scope, $http) {
	$scope.texto = 'Bom dia...';
	$scope.lista = [];
	
	$scope.fetch = function() {
		
		$http({method: 'GET', url: Configs.url + "/rest/services/v1/forecasts/1", headers: {'keyAcess' : Configs.keyAcess}}).
			success(function(data, status) {
				$scope.lista = data;
			}).
			error(function(data, status) {
				alert('Error: '+status);
			});
	};
	
	$scope.fetch();
	
});
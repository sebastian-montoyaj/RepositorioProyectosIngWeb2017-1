/**
 * 
 */

var appCliente = angular.module('clientes', ['ngRoute']);

appCliente.service('clientes', function($http){
	this.listaClientes = function(){
		return $http({
			url: 'http://localhost:8080/EjemploJersey/jersey/Cliente',
			method: 'GET'
		})
	}
});

appCliente.controller('listaClientes', function($scope, clientes){
	clientes.listaClientes().then(
		function success(res){
			console.log(res);
			$scope.listaClientes = res.data.clienteJersey;
		}	
	)
});

appCliente.config(['$routeProvider', function($routeProvider){
	$routeProvider.when('/', {
		templateUrl: 'listaClientes.html',
		controller: 'listaClientes'
	});
}]);
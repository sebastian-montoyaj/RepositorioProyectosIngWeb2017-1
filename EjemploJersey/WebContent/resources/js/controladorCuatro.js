/**
 * 
 */
var appCliente = angular.module('clientes', ['ngRoute', 'ngCookies']);

appCliente.service('usuarios', function($http, $cookies, $location){
	
    this.autenticar = function(usuario, passwd){
        return $http({
            url: 'http://localhost:8080/EjemploJersey/jersey/Usuario',
            method: 'GET',
            params: {login: usuario, pws: passwd}
        })
    }
    
    this.validarEstado = function(){
		if(typeof($cookies.nombreUsuario) == 'undefined' || $cookies.nombreUsuario == ""){
			$location.url("/");
			return false;
		}
		
		if($location.url() == '/'){
			
		}
	};
});

appCliente.service('clientes', function($http){
	this.listaClientes = function(){
		return $http({
			url: 'http://localhost:8080/EjemploJersey/jersey/Cliente',
			method: 'GET'
		})
	}
	
	this.guardar = function(cliente){
        return $http({
            url: 'http://localhost:8080/EjemploJersey/jersey/Cliente',
            method: 'POST',
            params: {
                cedula: cliente.cedula,
                nombres: cliente.nombre,
                apellidos: cliente.apellidos,
                email: cliente.email,
                usuarioCrea: 'elver'
            }
        })
    }
});

appCliente.controller('listaClientes', function($scope, $location, clientes, usuarios){
	if (usuarios.validarEstado())
	{
		clientes.listaClientes().then(
				function success(res){
					console.log(res);
					$scope.listaClientes = res.data.clienteJersey;
				}	
			)
			
			$scope.agregar = function(){
				$location.url('/nuevo');
			}
	}
});

// http://localhost:8080/EjemploJersey/#!/

appCliente.controller('Login', function($scope, $location, $cookies, usuarios){
    $scope.nombreUsuario = '';
    $scope.passwd = '';
   
    $scope.login = function(){
        usuarios.autenticar($scope.nombreUsuario, $scope.passwd).then(
        		function success(data){
					
					if(data.data != ""){
						alert(data.data);
						$scope.nombreUsuario = '';
						$scope.passwd = '';
						return;
					}
					
					$cookies.nombreUsuario = $scope.nombreUsuario;
					
					$location.url('/listaClientes');
				},
				
				function failure(data){
					alert(data.data);
				}
            );
    }
});

// http://localhost:8080/EjemploJersey//index.html#!/

appCliente.controller('cliente', function($scope, $location, clientes){
    $scope.cliente = {
        nombre: '',
        apellidos: '',
        cedula: '',
        email: ''
    };
   
    $scope.guardar = function(){
        clientes.guardar($scope.cliente).then(
                function success(data){
                    alert('Cliente creado');
                    $location.url('/listaClientes');
                }
            );
    };
});

// http://localhost:8080/EjemploJersey//index.html#!/nuevo

appCliente.config(['$routeProvider', function($routeProvider){
    $routeProvider.when('/listaClientes', {
        templateUrl: 'listaClientes.html',
        controller: 'listaClientes'
    });
   
    $routeProvider.when('/', {
        templateUrl: 'login.html',
        controller: 'Login'
    });
   
    $routeProvider.when('/nuevo', {
        templateUrl: 'cliente.html',
        controller: 'cliente'
    });
}]);

appCliente.run($rootScope, usuarios)
{
    $rootScope.$on('$routeChangeStart', function(){
        usuarios.validarEstado();
    })
};
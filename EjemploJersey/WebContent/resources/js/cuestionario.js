/**
 * 
 */

var cuestionario  =  angular.module('modCuestionario', []);

cuestionario.controller('contCuestionario', function($scope){
	$scope.preguntas = [{
		id: 1,
		texto: 'Pregunta 1',
		respuestaValida: 1,
		respuestaUsuario: null,
		estado: '',
		listaRespuestas: [{id: 1, texto: 'Respuestas 1.1'},
						  {id: 2, texto: 'Respuestas 1.2'},
						  {id: 3, texto: 'Respuestas 1.3'}]
	}, {
		id: 2,
		texto: 'Pregunta 2',
		respuestaValida: 3,
		respuestaUsuario: null,
		estado: '',
		listaRespuestas: [{id: 1, texto: 'Respuestas 2.1'},
						  {id: 2, texto: 'Respuestas 2.2'},
						  {id: 3, texto: 'Respuestas 2.3'}]
	}, {
		id: 3,
		texto: 'Pregunta 3',
		respuestaValida: 2,
		respuestaUsuario: null,
		estado: '',
		listaRespuestas: [{id: 1, texto: 'Respuestas 3.1'},
						  {id: 2, texto: 'Respuestas 3.2'},
						  {id: 3, texto: 'Respuestas 3.3'}]
	}];
	
	$scope.respuestasCorrectas = 0;
	$scope.estadoUsuario = '';
	
	$scope.validar = function(pregunta) {
		if(pregunta.respuestaValida == pregunta.respuestaUsuario){
			$scope.respuestasCorrectas++;
			pregunta.estado = 'ok';
		}
		else{
			if(pregunta.estado == 'ok' && $scope.respuestasCorrectas > 0)
				$scope.respuestasCorrectas--;
			
			pregunta.estado = 'error';
		}
		
		estadoUsuario();
	};
	
	$scope.obtenerCalificacion = function() {
		$scope.respuestasCorrectas = 0;
		for (i=0; i < $scope.preguntas.length; i++){
			$scope.validar($scope.preguntas[i]);
		}
	};
	
	function estadoUsuario(){
		var total = $scope.respuestasCorrectas / $scope.preguntas.length;
		if(total == 0){
			$scope.estadoUsuario = 'looser';
		}
		else if (total == 1){
			$scope.estadoUsuario = 'guru';
		}
		else{
			$scope.estadoUsuario = 'poor';
		}
	}
});
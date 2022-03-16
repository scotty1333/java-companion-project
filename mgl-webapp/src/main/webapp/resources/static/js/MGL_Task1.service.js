'use strict';

angular.module('MGL_Task1_app').factory('MGL_Task1_Service', ['$http','$log', function($http, $log) {

		var REST_SERVICE_URI = 'game/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			deleteGame : deleteGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI).then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI, game).then(function(response) {
					return response.data;
				}
			);
		}
		
		function deleteGame(gameId) {
			return $http.delete(REST_SERVICE_URI + gameId).then(function(response) {
					if (response.data) {
						$log.debug("Successfully delete game with id: " + gameId);
					} else {
						$log.debug("No game deleted with id: " + gameId);
					}
					return response.data;
				}	
			);
		}

}]);

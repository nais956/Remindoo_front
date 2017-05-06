'use strict';

var app = angular.module('Remindoo', [
	'ngRoute','RemindooControllers'   ]);

app.config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
			when('/gestionTaches', {
				templateUrl: 'partials/menu.html'
			}).
			when('/gestionTaches/listerNotes', {
				templateUrl: 'partials/listerNotes.html',
				controller: 'listeNotesController'
			}).
			when('/gestionTaches/ajoutNote', {
				templateUrl: 'partials/ajoutNote.html',
				controller: 'ajoutNoteController'
			}).
			otherwise({
				redirectTo: '/gestionTaches'
			});
}]);
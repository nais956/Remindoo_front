'use strict';

var app = angular.module('Remindoo', [
	'ngRoute','RemindooControllers'   ]);

app.config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
			when('/gestionTaches', {
				templateUrl: 'partials/index.html'
			}).
			when('/gestionTaches/listerListes', {
				templateUrl: 'partials/listerListes.html',
				controller: 'listeListesController'
			}).
			when('/gestionTaches/ajoutListe', {
				templateUrl: 'partials/ajoutListe.html',
				controller: 'ajoutListeController'
			}).
			when('/gestionTaches/modifierListe/:id', {
				templateUrl: 'partials/modifierListe.html',
				controller: 'modifierListeController'
			}).
			when('/gestionTaches/listerNotes', {
				templateUrl: 'partials/listerNotes.html',
				controller: 'listeNotesController'
			}).
			when('/gestionTaches/ajoutNote', {
				templateUrl: 'partials/ajoutNote.html',
				controller: 'ajoutNoteController'
			}).
			when('/gestionTaches/getAllNotes/:id', {
				templateUrl: 'partials/listerNotes.html',
				controller: 'NotesbyListeController'
			}).
			when('/gestionTaches/modifierNote/:id', {
				templateUrl: 'partials/modifierNote.html',
				controller: 'modifierNoteController'
			}).
			when('/gestionTaches/login', {
                templateUrl: 'partials/login.html',
                controller: 'LoginController'
			}).
			otherwise({
				redirectTo: '/gestionTaches'
			});
}]);


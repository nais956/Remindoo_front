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
			when('/gestionTaches/getAllNotes/:id/ajoutNote', {
				templateUrl: 'partials/ajoutNote.html',
				controller: 'ajoutNoteController'
			}).
			when('/gestionTaches/getAllNotes/:id', {
				templateUrl: 'partials/listerNotes.html',
				controller: 'NotesbyListeController'
			}).
			when('/gestionTaches/getAllNotes/:id/voirNote/:idNote', {
				templateUrl: 'partials/voirNote.html',
				controller: 'voirNoteController'
			}).
			when('/gestionTaches/getAllNotes/:idListe/modifierNote/:id', {
				templateUrl: 'partials/modifierNote.html',
				controller: 'modifierNoteController'
			}).
			when('/gestionTaches/getAllTaches/:id/ajoutTache', {
				templateUrl: 'partials/ajoutTache.html',
				controller: 'ajoutTacheController'
			}).
			when('/gestionTaches/getAllTaches/:id', {
				templateUrl: 'partials/listerTaches.html',
				controller: 'TachesbyListeController'
			}).
			when('/gestionTaches/getAllTaches/:idListe/modifierTache/:id', {
				templateUrl: 'partials/modifierTache.html',
				controller: 'modifierTacheController'
			}).
			when('/gestionTaches/listerTypesTache', {
				templateUrl: 'partials/listerTypesTache.html',
				controller: 'listeTypesTacheController'
			}).
			when('/gestionTaches/ajoutTypeTache', {
				templateUrl: 'partials/ajoutTypeTache.html',
				controller: 'ajoutTypeTacheController'
			}).
			when('/gestionTaches/modifierTypeTache/:id', {
				templateUrl: 'partials/modifierTypeTache.html',
				controller: 'modifierTypeTacheController'
			}).
			when('/gestionTaches/login', {
                templateUrl: 'partials/login.html',
                controller: 'LoginController'
			}).
			otherwise({
				redirectTo: '/gestionTaches'
			});
}]);


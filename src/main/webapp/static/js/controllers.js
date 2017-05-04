'use strict';

var RemindooControllers = angular.module('RemindooControllers', []);

RemindooControllers.controller("listeNotesController", function($scope,$http,$routeParams) {

	$http.get('http://localhost:8080/notes').
	  success(function(data, status, headers, config) {
	  	$scope.listeNotes = data;
	  	$scope.noteChoisie = data[0];
	  }).
	  error(function(data, status, headers, config) {
	  });

        
});

RemindooControllers.controller("ajoutNoteController", function($scope,$http,$routeParams) {

	
	$scope.ajouterNote = function(note) {
		
		$http.post('http://localhost:8080/note', note).
		  success(function(data, status, headers, config) {
			  alert('!');
		  }).
		  error(function(data, status, headers, config) {
		  });
		
	};


        
});
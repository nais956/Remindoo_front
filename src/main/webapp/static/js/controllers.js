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
			  alert('Note ajoutee!');
		  }).
		  error(function(data, status, headers, config) {
		  });
		
	};
});	

RemindooControllers.controller("modifierNoteController", function($scope,$http,$routeParams) {

	var id = $routeParams.id;
	
	$scope.modifierNote = function(note) {
		
		$http.post('http://localhost:8080/note/'+ id, note).
		  success(function(data, status, headers, config) {
			  alert('Note Modifiee!');
		  }).
		  error(function(data, status, headers, config) {
		  });
		
	};
});
	
RemindooControllers.controller("listeListesController", function($scope,$http,$routeParams) {
	
	listerListe();
	
	function listerListe() {
	$http.get('http://localhost:8080/listes').
	  success(function(data, status, headers, config) {
	  	$scope.listeListes = data;
	  	$scope.listeChoisie = data[0];
	  }).
	  error(function(data, status, headers, config) {
	  });
	}
       
	   var id = $routeParams.id;
	   
	   
		$scope.supprimerListe = function(id) {

		$http.delete('http://localhost:8080/deleteListe/'+ id).
		  success(function(data, status, headers, config) {
				alert('Liste supprimee');
		  }).
		  error(function(data, status, headers, config) {
		  });

		}; 
});
RemindooControllers.controller("modifierListeController", function($scope,$http,$routeParams) {

	var id = $routeParams.id;
	
	$scope.modifierListe = function(liste) {
		
		$http.post('http://localhost:8080/liste/'+ id, liste).
		  success(function(data, status, headers, config) {
			  alert('Liste Modifiee!');
		  }).
		  error(function(data, status, headers, config) {
		  });
		
	};
});


RemindooControllers.controller("ajoutListeController", function($scope,$http,$routeParams) {

	
	$scope.ajouterListe = function(liste) {
		
		$http.post('http://localhost:8080/liste', liste).
		  success(function(data, status, headers, config) {
			  alert('Liste Ajoutee!');
		  }).
		  error(function(data, status, headers, config) {
		  });
		
	};
});
RemindooControllers.controller("listeTachesController", function($scope,$http,$routeParams) {

	$http.get('http://localhost:8080/taches').
	  success(function(data, status, headers, config) {
	  	$scope.listeTaches = data;
	  	$scope.tacheChoisie = data[0];
	  }).
	  error(function(data, status, headers, config) {
	  });

        
});


RemindooControllers.controller("NotesbyListeController", function($scope,$http,$routeParams) {

	var id = $routeParams.id;

	listerNote(id);
	
	
	
	function listerNote(id) {
	
		$http.get('http://localhost:8080/getAllNotes/'+ id).
		  success(function(data, status, headers, config) {
			$scope.listeNotes = data;
			$scope.noteChoisie = data[0];
		  }).
		  error(function(data, status, headers, config) {
		  });
		  
		
	} 
	   
		$scope.supprimerNote = function(id) {

		$http.delete('http://localhost:8080/deleteNote/'+ id).
		  success(function(data, status, headers, config) {
				alert('Note supprimee');
		  }).
		  error(function(data, status, headers, config) {
		  });

		}; 
		
});


RemindooControllers.controller("ajoutTacheController", function($scope,$http,$routeParams) {

	
	$scope.ajouterTache = function(tache) {
		
		$http.post('http://localhost:8080/tache', tache).
		  success(function(data, status, headers, config) {
			  alert('!');
		  }).
		  error(function(data, status, headers, config) {
		  });
		
	};
        
});
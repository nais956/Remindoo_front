'use strict';

var RemindooControllers = angular.module('RemindooControllers', []);

// Controllers des Listes

RemindooControllers.controller("ajoutListeController", function($scope,$location,$http,$routeParams) {

	
	$scope.ajouterListe = function(liste) {
		
		$http.post('http://localhost:8080/liste', liste).
		  success(function(data, status, headers, config) {
			  alert('Liste Ajoutee!');
			   $location.path('/gestionTaches/listerListes');
		  }).
		  error(function(data, status, headers, config) {
		  });
		
	};
});

RemindooControllers.controller("modifierListeController", function($scope,$location,$http,$routeParams) {

	var id = $routeParams.id;
	
	$scope.modifierListe = function(liste) {
		
		$http.post('http://localhost:8080/liste/'+ id, liste).
		  success(function(data, status, headers, config) {
			  alert('Liste Modifiee!');
			  $location.path('/gestionTaches/listerListes');
		  }).
		  error(function(data, status, headers, config) {
		  });
		
	};
});

RemindooControllers.controller("listeListesController", function($scope,$location,$http,$routeParams) {
	
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
				$location.path('/gestionTaches/listerListes');
		  }).
		  error(function(data, status, headers, config) {
		  });

		}; 
});



// Controllers des Notes

RemindooControllers.controller("ajoutNoteController", function($scope,$location,$http,$routeParams) {

	var idListe = $routeParams.id;
	
	$scope.ajouterNote = function(note) {
		
		$http.post('http://localhost:8080/'+ idListe + '/note', note).
		  success(function(data, status, headers, config) {
			  alert('Note ajoutee!');
			  $location.path('/gestionTaches/getAllNotes/'+ idListe);
		  }).
		  error(function(data, status, headers, config) {
		  });
		
	};
});	

RemindooControllers.controller("modifierNoteController", function($scope,$location,$http,$routeParams) {

	var id = $routeParams.id;
	var idListe = $routeParams.idListe;
	
	$scope.modifierNote = function(note) {
		
		$http.post('http://localhost:8080/note/'+ id, note).
		  success(function(data, status, headers, config) {
			  alert('Note Modifiee!');
			  $location.path('/gestionTaches/getAllNotes/'+ idListe);
			  
		  }).
		  error(function(data, status, headers, config) {
		  });
		
	};
});

RemindooControllers.controller("NotesbyListeController", function($scope,$location,$http,$routeParams) {

	var idListe = $routeParams.id;

	listerNote(idListe);
	
	
	
	function listerNote(idListe) {
	
		$http.get('http://localhost:8080/getAllNotes/'+ idListe).
		  success(function(data, status, headers, config) {
			$scope.listeNotes = data;
			$scope.noteChoisie = data[0];
			$scope.id = $routeParams.id;
		  }).
		  error(function(data, status, headers, config) {
		  });
		  
		
	} 
	   
		$scope.supprimerNote = function(id) {

		$http.delete('http://localhost:8080/deleteNote/'+ id).
		  success(function(data, status, headers, config) {
			$location.path('/gestionTaches/getAllNotes/'+ idListe);
		  }).
		  error(function(data, status, headers, config) {
		  });

		}; 
	

});

RemindooControllers.controller("voirNoteController", function($scope,$location,$http,$routeParams) {
	
	var idNote = $routeParams.idNote;

	
	voirNote(idNote);
	
	function voirNote(idNote) { 

		$http.get('http://localhost:8080/voirNote/'+ idNote).
		  success(function(data, status, headers, config) {
			$scope.noteAffiche = data;
			$scope.idListe = $routeParams.id;
		  }).
		  error(function(data, status, headers, config) {
		  });

		}; 
});


	
// Controllers des Tâches


RemindooControllers.controller("ajoutTacheController", function($scope,$location,$http,$routeParams) {

	var idListe = $routeParams.id;
	
	listerTypesTache();
	
	function listerTypesTache() {
	$http.get('http://localhost:8080/typesTache').
	  success(function(data, status, headers, config) {
	  	$scope.listeTypesTache = data;
	  	$scope.typeTacheChoisie = data[0];
	  }).
	  error(function(data, status, headers, config) {
	  });
	}
	
	$scope.ajouterTache = function(tache) {
		
		
		$http.post('http://localhost:8080/' + idListe + '/tache', tache).
		  success(function(data, status, headers, config) {
			  alert('Tache ajoutee!');
			  $location.path('/gestionTaches/getAllTaches/'+ idListe);
		  }).
		  error(function(data, status, headers, config) {
		  });
		
	};
        
});

RemindooControllers.controller("modifierTacheController", function($scope,$location,$http,$routeParams) {

	var id = $routeParams.id;
	var idListe = $routeParams.idListe;
	
	listerTypesTache();
	
	function listerTypesTache() {
	$http.get('http://localhost:8080/typesTache').
	  success(function(data, status, headers, config) {
	  	$scope.listeTypesTache = data;
	  	$scope.typeTacheChoisie = data[0];
	  }).
	  error(function(data, status, headers, config) {
	  });
	}
	
	$scope.modifierTache = function(tache) {
		
		$http.post('http://localhost:8080/tache/'+ id, tache).
		  success(function(data, status, headers, config) {
			$location.path('/gestionTaches/getAllTaches/'+ idListe);
		  }).
		  error(function(data, status, headers, config) {
		  });
		
	};
});

RemindooControllers.controller("TachesbyListeController", function($scope,$location,$http,$routeParams) {

	var idListe = $routeParams.id;

	listerTache(idListe);
	
	function listerTache(idListe) {
	
		$http.get('http://localhost:8080/getAllTaches/'+ idListe).
		  success(function(data, status, headers, config) {
			$scope.listeTaches = data;
			$scope.tacheChoisie = data[0];
			$scope.id = $routeParams.id;
		  }).
		  error(function(data, status, headers, config) {
		  });	
	} 
	   
		$scope.supprimerTache = function(id) {
		$http.delete('http://localhost:8080/deleteTache/'+ id).
		  success(function(data, status, headers, config) {
			$location.path('/gestionTaches/getAllTaches/'+ idListe);
		  }).
		  error(function(data, status, headers, config) {
		  });

		}; 
		
});

// Controllers des Types de tâches


RemindooControllers.controller("ajoutTypeTacheController", function($scope,$location,$http,$routeParams) {


	listerCategorie();
	
	function listerCategorie() {
	$http.get('http://localhost:8080/categorie').
	  success(function(data, status, headers, config) {
	  	$scope.listeCategories = data;
	  	$scope.categorieChoisie = data[0];
	  }).
	  error(function(data, status, headers, config) {
	  });
	}
	
	$scope.ajouterTypeTache = function(typetache) {
		
		$http.post('http://localhost:8080/typeTache', typetache).
		  success(function(data, status, headers, config) {
			  alert('Type de tache ajoute!');
			  $location.path('/gestionTaches/listerTypesTache');
		  }).
		  error(function(data, status, headers, config) {
		  });
		
	};
        
});

RemindooControllers.controller("modifierTypeTacheController", function($scope,$location,$http,$routeParams) {

	var id = $routeParams.id;
	
	$scope.modifierTypeTache = function(typetache) {
		
		$http.post('http://localhost:8080/typeTache/'+ id, typetache).
		  success(function(data, status, headers, config) {
			  alert('Type de tache modifie!');
			  $location.path('/gestionTaches/listerTypesTache');
		  }).
		  error(function(data, status, headers, config) {
		  });
		
	};
});

RemindooControllers.controller("listeTypesTacheController", function($scope,$location,$http,$routeParams) {
	
	listerTypesTache();
	
	function listerTypesTache() {
	$http.get('http://localhost:8080/typesTache').
	  success(function(data, status, headers, config) {
	  	$scope.listeTypesTache = data;
	  	$scope.typeTacheChoisie = data[0];
	  }).
	  error(function(data, status, headers, config) {
	  });
	}
       
	   var id = $routeParams.id;
	   
	   
		$scope.supprimerTypeTache = function(id) {

		$http.delete('http://localhost:8080/deleteTypeTache/'+ id).
		  success(function(data, status, headers, config) {
				$location.path('/gestionTaches/listerTypesTache');
		  }).
		  error(function(data, status, headers, config) {
			  alert('Vous ne pouvez pas supprimer ce type de tache car il est associe a une tache');
			  $location.path('/gestionTaches/listerTypesTache');
		  });

		}; 
});



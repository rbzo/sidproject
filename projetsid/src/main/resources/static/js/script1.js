/**
 * 
 */
var app = angular.module('compte', ['ngRoute','angular-growl']);

/**
 * configuration du module principal
 */

app.config(['$routeProvider',
            function($routeProvider){
			//systeme de routage
				$routeProvider
				.when('/addCompte',{
					templateUrl:'partials/ajout_compte.html',
					controller: 'compteController'
				})
				.when('/allComptes',{
					templateUrl:'partials/liste_comptes.html',
					controller: 'compteController'
				})
				.when('/getcompte', {
					templateUrl:'partials/details_compte.html',
					controller: 'compteController'
				})
				/*.otherwise({
					redirectTo:'/allComptes'
				})*/;
}
]);



/**
 * Contrôleur de l'application app
 */
app.controller('compteController', function($scope, $http, $routeParams, growl, $location){
	$scope.comptes=[];
	$scope.compte={};
	$scope.url = 'http://localhost:1212/banque/comptes/';
	$scope.pageCourante=0;
	
	$scope.detail_compte=function(refCompte){
		var id= $routeParams.refCompte;
		$http.get($scope.url.concat(refcompte))
		.success(function(data){
			$scope.compte=data;
		});
	};
	/*$scope.gotoPage=function(p){
		$scope.pageCourante=p;
		$scope.lister()
	};*/
	
	
	$scope.ajouterCompte = function () {
		var cpte={"numCompte":$scope.compte.num , "dateCreation": $scope.compte.datecreation ,"solde":$scope.compte.solde }
		$http.post("http://localhost:1212/banque/comptes", cpte)
		.success(function(response){
		        growl.success('Compte ajouté avec succes.');
			console.log ("compte ajouté");
		});

	    };
	    
	
	  
	
})
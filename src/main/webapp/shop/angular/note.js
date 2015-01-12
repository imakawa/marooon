var productApp = angular.module('noteApp', []);

productApp.controller('headerController', function Execute($scope,$http) {
	$http.get('chanelJson.action').success(function(datas) {  
		$scope.menus = datas;
	}).error(function(datas) { 
		alert("note.js.chanelJson.action:Error! Please Contact Later!");
	})
});

productApp.controller('noteController', function Execute($http,$scope,$location){
	
});
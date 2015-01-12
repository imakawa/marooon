var productApp = angular.module('contactApp', []);

productApp.controller('headerController', function Execute($scope,$http) {
	$http.get('chanelJson.action').success(function(datas) {  
		$scope.menus = datas;
	}).error(function(datas) { 
		alert("contact.js.chanelJson.action:Error! Please Contact Later!");
	})
});

productApp.controller('contactController', function Execute($http,$scope,$location){
	
});
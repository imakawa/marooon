var spartanApp = angular.module('spartanApp',[]);

spartanApp.controller('containerCtrl', function Execute($scope,$http,$location) {
	$http.get('getAllProducts.action').success(function(datas) {  
		$scope.products = datas;
	}).error(function(datas) {  
		alert("index.js.chanelJson.action:Error! Please Contact Later!");
	})
});
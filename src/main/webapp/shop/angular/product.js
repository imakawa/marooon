var productApp = angular.module('productApp', []);

productApp.controller('headerController', function Execute($scope,$http) {
	$http.get('chanelJson.action').success(function(datas) {  
		$scope.menus = datas;
	}).error(function(datas) { 
		alert("channel.js.chanelJson.action:Error! Please Contact Later!");
	})
});

productApp.controller('productController', function Execute($http,$scope,$location){
	
	var url = window.location.search;
    var i = url.substring(url.lastIndexOf('=')+1, url.length);
    $scope.updateMessage = "详情加载中...请稍后.."+i;
	/*$http.get('readChannelProudcts.action?chanelId='+i).success(function(datas) {  
		$scope.updateMessage = "";
		$scope.products = datas;
	}).error(function(datas) { 
		//alert("channel.js.chanelJson.action:Error! Please Contact Later!");
	})*/
});
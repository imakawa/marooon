var spartanApp = angular.module('spartanApp',[]);

spartanApp.controller('containerCtrl', function Execute($scope,$http,$location,$window) {
	$http.get('IsHaveUserLogin.action').success(function(datas) {  
		if(datas[0].status == "SUCCESS"){
			$http.get('getAllProducts.action').success(function(datas) {  
				$scope.products = datas;
			}).error(function(datas) {  
				alert("index.js.chanelJson.action:Error! Please Contact Later!");
			})
		}else{
			alert('请重新登陆系统');
			$window.location.href="login.html";
		}
	}).error(function(datas) {  
		alert("index.js.chanelJson.action:Error! Please Contact Later!");
	})
	
});
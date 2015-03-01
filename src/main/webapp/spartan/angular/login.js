var loginApp = angular.module('loginApp',[]);
loginApp.controller('containerCtrl', function Execute($scope,$http,$location,$window) {

	$scope.formData = {};
	$scope.isShow = false;
	
	$http.get('clearSession.action').success(function(datas) {
		alert("sdfdfdsdfsdfsfds");
	}).error(function(datas) {  
		alert("index.js.chanelJson.action:Error! Please Contact Later!");
	})
	
	$scope.processForm = function() {
	    $http({
	        method  : 'POST',
	        url    : 'userLoginAuth.action',
	        data    : $.param($scope.formData),
	        headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
	    }).success(function(datas) {
	            if (datas[0].status=="SUCCESS") {
	            	$scope.isShow = false;
	            	$window.location.href="home.html";
	            } else {
	            	$scope.isShow = true;
	            }
	    });
	};
	
});
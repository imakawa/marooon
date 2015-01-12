var productApp = angular.module('productApp', []);
productApp.directive('onFinishRenderFilters', function ($timeout) {
    return {
        restrict: 'A',
        link: function(scope, element, attr) {
            if (scope.$last === true) {
                $timeout(function() {
                    scope.$emit('ngRepeatFinished');
                });
            }
        }
    };
});

productApp.controller('headerController', function Execute($scope,$http) {
	$http.get('chanelJson.action').success(function(datas) {  
		$scope.menus = datas;
	}).error(function(datas) { 
		alert("product.js.chanelJson.action:Error! Please Contact Later!");
	})
});

productApp.controller('productController', function Execute($http,$scope,$location){
	var url = window.location.search;
    var i = url.substring(url.lastIndexOf('=')+1, url.length);
    $scope.updateMessage = "详情加载中...请稍后..";
	$http.get('readProductJson.action?productId='+i).success(function(datas) {  
		$scope.updateMessage = "";
		$scope.product = datas;
	}).error(function(datas) { 
		alert("product.js.readProductJson.action:Error! Please Contact Later!");
	});
	
	$scope.$on('ngRepeatFinished', function (ngRepeatFinishedEvent) {
		  var galleries = $('.ad-gallery').adGallery();
	});	
});
var indexApp = angular.module('indexApp', []);
indexApp.directive('onFinishRenderFilters', function ($timeout) {
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

indexApp.controller('headerController', function Execute($scope,$http,$location) {
	$http.get('chanelJson.action').success(function(datas) {  
		$scope.menus = datas;
	}).error(function(datas) {  
		alert("index.js.chanelJson.action:Error! Please Contact Later!");
	})
});


indexApp.controller('sliderController', function Execute($scope,$http) {
	$http.get('readIndexProducts.action').success(function(datas) {
		$scope.indexProducts = datas;
	}).error(function(datas) {  
		//alert("index.js.readIndexProducts.action:Error! Please Contact Later!");
	})
});

indexApp.controller('productListController', function Execute($scope,$http) {
	$scope.loadMessage = "----正在加载..马上呈现..";
	$http.get('readHotProducts.action').success(function(datas) {
		$scope.hotProducts = datas;
		$scope.loadMessage = "";
	}).error(function(datas) {
		//alert("index.js.readHotProducts.action:Error! Please Contact Later!");
	})
	
	$scope.$on('ngRepeatFinished', function (ngRepeatFinishedEvent) {
		var winWidth = $(window).width();
		var conWidth;
		if(winWidth < 600) {
			conWidth = 300;
			col = 1
		} else if(winWidth < 900) {
			conWidth = 600;
			col = 2
		} else if(winWidth < 1200) {
			conWidth = 900;
			col = 3;
		} else {
			conWidth = 1200;
			col = 4;
		}
		
		$('#container').width(conWidth);
		$('#container').BlocksIt({
			numOfCol: col,
			offsetX: 10,
			offsetY: 10
		});
});
});

jQuery(document).ready(function($) {
	$(window).resize(function() {
		var winWidth = $(window).width();
		var conWidth;
		if(winWidth < 600) {
			conWidth = 300;
			col = 1
		} else if(winWidth < 900) {
			conWidth = 600;
			col = 2
		} else if(winWidth < 1200) {
			conWidth = 900;
			col = 3;
		} else {
			conWidth = 1200;
			col = 4;
		}
		
		$('#container').width(conWidth);
		$('#container').BlocksIt({
			numOfCol: col,
			offsetX: 10,
			offsetY: 10
		});
	});
	
});
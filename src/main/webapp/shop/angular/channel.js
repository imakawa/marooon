var channelApp = angular.module('channelApp', []);
channelApp.directive('onFinishRenderFilters', function ($timeout) {
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

channelApp.controller('headerController', function Execute($scope,$http) {
	$http.get('chanelJson.action').success(function(datas) {  
		$scope.menus = datas;
	}).error(function(datas) { 
		alert("channel.js.chanelJson.action:Error! Please Contact Later!");
	})
});

channelApp.controller('channelController', function Execute($http,$scope,$location){
	$scope.updateMessage = "商品加载中...请稍后..";
	var url = window.location.search;
    var i = url.substring(url.lastIndexOf('=')+1, url.length);
	$http.get('readChannelProudcts.action?chanelId='+i).success(function(datas) {  
		$scope.updateMessage = "";
		$scope.products = datas;
	}).error(function(datas) { 
		//alert("channel.js.chanelJson.action:Error! Please Contact Later!");
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
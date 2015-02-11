//页面中加载的图片数量
//图片全部加载完成后，进行瀑布流显示的设置
var loadedImgCount = 0;

var channelApp = angular.module('channelApp', []);
channelApp.controller('headerController', function Execute($scope,$http) {
	$http.get('chanelJson.action').success(function(datas) {  
		$scope.menus = datas;
	}).error(function(datas) { 
		alert("channel.js.chanelJson.action:Error! Please Contact Later!");
	})
});
channelApp.controller('channelController', function Execute($http,$scope,$location){
	$scope.updateMessage = "商品加载中...请稍后..";

//	获取访问该页面的参数
//	TODO:  基盤化必要です
	var url = window.location.search;
    var i = url.substring(url.lastIndexOf('=')+1, url.length);
	$http.get('readChannelProudcts.action?chanelId='+i).success(function(datas) {  
		$scope.updateMessage = "";
		$scope.products = datas;
		loadedImgCount = datas.length;
	}).error(function(datas) { 
		//alert("channel.js.chanelJson.action:Error! Please Contact Later!");
	})
});

var imageCount = 0
function imageLoad(){
	imageCount += 1;
	if(imageCount == loadedImgCount){
		var msnry = new Masonry( '#container', {
			"gutter": 15,
			  itemSelector: '.grid1_of_3'
			});	
	}
}


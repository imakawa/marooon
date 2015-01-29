var exchangeApp = angular.module('exchangeApp', []);

exchangeApp.controller('exchangeController', function Exchange($scope,$http) {
	/*
	 * 获取全部汇率数据，并求的当前汇率。
	 */
	$http.get('exchangeJson.action').success(function(datas) {  
		$scope.exchanges = datas;
		for (var index in datas) {
			$scope.currentRate = datas[index].rate;
		}
	}).error(function(datas) {  
		alert("Error! Please Contact Later!");
	})
	
	$scope.submitForm = function(){
		$.post('createExchange.action',{inputRate:$scope.inputRate})
		.success(function(){
			$http.get('exchangeJson.action').success(function(datas) {  
				$scope.exchanges = datas;
				for (var index in datas) {
					$scope.currentRate = datas[index].rate;
				}
			}).error(function(datas) {  
				alert("Error! Please Contact Later!");
			})
		})
		.error(function(){
			alert("456");
			$scope.updateState="danger";
			$scope.updateMessage="更新失败";
		});
	}
	
});  


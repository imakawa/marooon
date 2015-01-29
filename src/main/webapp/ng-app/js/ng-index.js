var indexApp = angular.module('indexApp', ['ngGrid']);
indexApp.controller('gridCtrl', function($scope,$http) {
	$scope.loadMessage=new Date();
	$http.get('getAllProducts.action').success(function(datas) {
		$scope.productList = new Array();
		for(var pIndex in datas){
			var product = marooon.model.Product.New();
			product.id=datas[pIndex].id;
			product.name=datas[pIndex].name;
			product.price1=datas[pIndex].price.price1;
			product.price2=datas[pIndex].price.price2;
			$scope.productList.push(product);
		}
		$scope.loadMessage=new Date() -$scope.loadMessage;
	}).error(function(datas) {
		alert("index.js.chanelJson.action:Error! Please Contact Later!");
	});

	$scope.gridOptions = { 
			data: 'productList',
			columnDefs: [{field:'name', displayName:'商品名称'}, 
			             {field:'price1', displayName:'原价'},
			             {field:'price2', displayName:'实价'}]};
});

var marooon = {};
marooon.model={
		Product:{
			New:function(){
				var product = {};
				product.id='';
				product.name='';
				product.price1='';
				product.price2='';
				product.getJson= function(){
					return '{name:"'+product.name+'",price1:"'+product.price1+'",price2:"'+product.price2+'"}';
				}
				return product;
			}
		}

};

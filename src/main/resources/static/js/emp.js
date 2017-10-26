/// <reference path="angular.min.js"/>
//var app = angular.module('app', ["ngRoute"]);
var app = angular.module('app', []);
//app.config(function($routeProvider) {
//    $routeProvider
////    .when("/", {
////        templateUrl : "emplogin.html"
////    })
//    .when("/leave", {
//        templateUrl : "leave.html"
//    });
    
//});

/*app.service('myservice', function() {
	
	var name=this;
   // var getUserName = this;
   // getUserName.userName = "";
})*/
app.service('myService', function() { 
    this.name = "";
   
    this.setData = function(name){
    	this.name=name;
    	console.log("inservice"+" "+this.name);
    	}
    this.getData = function(){
    	console.log("in get of myservice"+this.name);
    	return this.name;
    	};
    
    });

/*app.controller('MyController',['myService',function(myService){
	this.setData = function(name){
	myService.name=name;
	}
	this.getData = function(){
	return myService.name;
	};
	}]);*/


/*app.controller('logincontroller', ['$interpolate', function($scope,$rootScope,$interpolate,myservice, $http, $location) {*/
/*app.controller('logincontroller', ['$cacheFactory', function($scope,$rootScope,$cacheFactory, $http, $location) {*/
app.controller('logincontroller', function($scope,myService,$rootScope,$interpolate, $http, $location) {
		
	//console.log($scope.name);
	// $scope.username = myservice.userName;
	//$scope.name=myservice.name;
	/*var emp={
			name:$scope.name,
			pwd:$scope.pwd,
			fromdate:$scope.fromdate,
			todate:$scope.todate
	}*/
	/* $scope.cache = $cacheFactory("cache");  
	 $scope.cache.put("name",$scope.name); 
	  $scope.cache.get(name);*/
	  
	   //put data into cache  
	 //  $scope.cache.put(key,value);    

	   //get data from cache  
	 //  $scope.cache.get(key);  

	   //get cache info  
	  // $scope.cache.info();
	$scope.login=function(){
		
		//console.log($rootScope.usrName);
		// myservice.userName = this.username;
		//myservice.name=this.name;
		
        // console.log("click" + myservice.userName);
		//  $scope.cache.put("name",$scope.name); 
		//  $scope.cache.get(name);
		alert("hi");
		var url = $location.absUrl() + "/getemp";
		
		
        //$rootScope.name=$scope.name;
        //$rootScope.pwd=$scope.pwd;
		
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
		var data = {
            name: $scope.name,
            pwd: $scope.pwd
        };
		myService.setData($scope.name);
		console.log(myService.getData());
		$http.post(url, data, config).then(function (response) {
			console.log(url);
			console.log(data);
			console.log(config);
			console.log(response);
			var resp=response.data.resp;
			console.log(resp);
			alert(resp);
			
			
			if(resp == 'success' ){
//	               $location.href('/leave.html');
				console.log("welcome");
				var url=$interpolate('/app/{{name}}')($scope);
				console.log(url);
				//$location.path(url);
				
				//$window.location.href($location.absUrl()+"/app");
				window.location.assign($location.absUrl()+"/app?name="+$scope.name);
				//window.location.assign($location.absUrl()+"/app/{{name}}");
				
				//$window.location.href = landingUrl;
	            }
			
			//$scope.staus = "Sucessful!";
		});
		
		//$scope.name = "";
		$scope.pwd = "";
		
		
	}
	
	/*$rootScope.usrName=$scope.name;
	console.log("my");
	console.log($rootScope.usrName);*/
	
	
	$scope.leave=function(){
		//$scope.username="";
		//debugger;
		//console.log($rootScope.usrName);
		/*console.log("in leave fun");
		var userurl =  "http://localhost:8082/getusername";
		
		console.log(userurl);
		var configuser = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
		$http.post(userurl, configuser).then(function (response) {
			
			console.log("data is "+response.data);
			$scope.username = response.data;
			console.log($scope.username);
		}, function (response) {
			//$scope.getResultMessage = "Fail!";
			console.log("fail");
		});*/
		//console.log($scope.username);
		var url = "http://localhost:8082/save";
		//alert(myService.name);
		//console.log($scope.name);
     // console.log(myService.getData()+" "+$scope.name +" "+$scope.fromdate);
		
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
		var data = {
           // name: $scope.username,
           // pwd: $scope.pwd,
            fromdate:$scope.fromdate,
            todate:$scope.todate
        };
		$http.post(url, data, config).then(function (response) {
			console.log(url);
			console.log(data);
			//console.log(config);
			console.log(response);
			var resp=response.data;
			console.log(resp);
			alert(resp);
		});
	}
	
	
});


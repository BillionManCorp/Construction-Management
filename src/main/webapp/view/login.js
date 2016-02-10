var app = angular.module('LoginDemo', [ "angularfaces" ]).controller(
        'LoginController', function($scope) {
  // This initializes the Angular Model with the values of the JSF bean attributes
  initJSFScope($scope);
 
  $scope.$watch('loginModel.userName', function(newValue, oldValue) {
      $scope.user = "@example.com";
  });});
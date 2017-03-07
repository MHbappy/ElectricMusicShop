/**
 * Created by bappy on 3/7/17.
 */

var cartApp = angular.module('cartApp',[]);

cartApp.controller('cartCtrl',function ($scope, $http) {

    $scope.refreshCart = function (cartId) {
        $http.get('/emusic/rest/cart/'+$scope.cartId).success(function (data) {
            $scope.cart = data;

            console.log(data);
        });
    };


    $scope.clearCart = function () {
        $http.delete('/emusic/rest/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId));
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function (productId) {
        $http.put('/emusic/rest/cart/add/'+productId).success(function (data) {
            $scope.refreshCart($http.get('/emusic/rest/cart/cartId'));
            console.log($scope.refreshChart);
            alert("Product successfully added to cart");
        });
    };


    $scope.removeFromCart = function (productId) {
        $http.put('/emusic/rest/cart/remove/'+productId).success(function (data) {
            $scope.refreshCart($http.get('/emusic/rest/cart/cartId'));
            alert("Product successfully added to cart");
        });
    };


});

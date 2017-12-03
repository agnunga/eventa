/**
 * Created by agufed on 11/30/17.
 */
angular.module('ngBoilerPlate.account', ['ui.router', 'ngResource'])
    .config(function ($stateProvider) {
        $stateProvider.state('login', {
            url:'/login',
            views:{
                'main':{
                    templateUrl:'account/login.tpl.html',
                    controller : 'LoginCtrl'
                }
            },
            data : {pageTitle : 'Login Here'}
        }).state('register', {
            url:'/register',
            views:{
                'main':{
                    templateUrl:'account/register.tpl.html',
                    controller : 'RegisterCtrl'
                }
            },
            data : {pageTitle : 'Register'}
        });
    })

    .factory('sessionService', function () {
        var session = {};
        session.login = function (data) {
            localStorage.setItem('session', data);
            alert('User log in with ' + data.phone + ' and ' + data.password);
        };
        session.register = function (data) {
            localStorage.setItem('session', data);
            alert('User Registered with ' +
                data.firstName + ', ' +
                data.lastName + ', ' +
                data.phone + ', ' +
                data.email + ', ' +
                data.gender + ' and ' +
                data.password);
        };
        session.logout = function (data) {
            localStorage.removeItem('session');
        };
        session.isLoggedIn = function (data) {
            return localStorage.getItem('session') !== null;
        };
        return session;
    })
    .factory('accountService', function ($resource) {
        var service  = {};
        service.register = function (account, success, failure){
            var Account = $resource("/eventa/users/add");
            alert(Account + " account");
            Account.save({}, account, success, failure);
        };
        service.login = function (account, success, failure){
            var Account = $resource("/eventa/users/login");
            alert(Account + " account");
            var data = Account.get({phone:account.phone, password:account.password},
                function(){success();
                }, failure);
        };
        return service;
    })
    .controller('LoginCtrl', function ($scope, sessionService, $state, accountService) {
        $scope.login = function () {
            accountService.login($scope.account, function (returnedData) {
                sessionService.login(returnedData);
                $state.go('home');
            }, function () {
                alert("adding user failed");

            });
            // sessionService.login($scope.account);
        };
    })
    .controller('RegisterCtrl', function ($scope, sessionService, $state, accountService) {
        $scope.register = function () {
            accountService.register($scope.account, function (returnedData) {
                sessionService.login(returnedData);
                $state.go('home');
            }, function () {
                alert("adding user failed");

            });
            // sessionService.register($scope.account);
        };
    });


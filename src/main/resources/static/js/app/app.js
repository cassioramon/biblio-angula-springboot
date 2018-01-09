var app = angular.module('LibraryTechne', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/listadelivros',{
            templateUrl: 'books.html',
            controller: 'BookController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});
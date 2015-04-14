var emr = angular.module('emr', []);

emr.controller('questionCtrl', function($scope, $http, $sce) {
	$scope.submit = function() {
		var question1 = $scope.question1;
		var question2 = $scope.question2;
		var question3 = $scope.question3;
		var answer1 = $scope.answer1;
		var answer2 = $scope.answer2;
		var answer3 = $scope.answer3;
		$http.get(
				"/question/add?question1=" + question1 + "&question2="
						+ question2 + "&question3=" + question3 + "&answer1="
						+ answer1 + "&answer2=" + answer2 + "&answer3="
						+ answer3).success(function(data) {
			if (data == 'success') {
				window.location.replace('/pages/index.html');
			}
		});
	};
});
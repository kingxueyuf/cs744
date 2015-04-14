var emr = angular.module('emr', []);

emr.controller('securityCtrl', function($scope, $http, $sce) {
	var correctAnswer1;
	var correctAnswer2;
	var correctAnswer3;
	$http.get("/question/check").success(function(data) {
		if (data.hasQuestion == 'no') {
			window.location.replace('/pages/create_question.html');
		} else {
			$scope.question1 = data.question1;
			$scope.question2 = data.question2;
			$scope.question3 = data.question3;
			correctAnswer1 = data.answer1;
			correctAnswer2 = data.answer2;
			correctAnswer3 = data.answer3;
		}
	});
	$scope.submit = function() {
		var answer1 = $scope.answer1;
		var answer2 = $scope.answer2;
		var answer3 = $scope.answer3;
		if (correctAnswer1 == answer1 && correctAnswer2 == answer2
				&& correctAnswer3 == answer3) {
			window.location.replace('/pages/index.html');
		} else {
			$scope.info = "your answer is wrong";
		}
	};
});
var emr = angular.module('emr', []);

emr.controller('questionCtrl', function($scope, $http, $sce) {

	$http.get("/question/questions").success(function(data) {
		var questionOneArr = [];
		var questionTwoArr = [];
		var questionThreeArr = [];
		for ( var i in data) {
			var item = {};
			item['label'] = data[i].sq_name;
			item['value'] = data[i].sq_name;
			if (data[i].sq_step == 1) {
				questionOneArr.push(item);
			}
			if (data[i].sq_step == 2) {
				questionTwoArr.push(item);
			}
			if (data[i].sq_step == 3) {
				questionThreeArr.push(item);
			}
		}
		console.log(questionOneArr);
		$scope.question1 = questionOneArr;
		$scope.question2 = questionTwoArr;
		$scope.question3 = questionThreeArr;
	});

	$scope.submit = function() {
		var question1 = $scope.selectquestion1.value;
		var question2 = $scope.selectquestion2.value;
		var question3 = $scope.selectquestion3.value;
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
var id;
var age;
var birthday;
var gender;
var name;
$(document).ready(function() {
	getPatientID();
	bindSubmitAction();

})

function getPatientID() {
	id = getUrlParameter("id");
	name = getUrlParameter("name");
	age = getUrlParameter("age");
	birthday = getUrlParameter("birthday");
	gender = getUrlParameter("gender");
	
	$('#name').val(name);
	$('#age').val(age);
	$('#birth').val(birthday);
	$('#gender').val(gender);
}

function getUrlParameter(sParam) {

	var sPageURL = window.location.search.substring(1);

	var sURLVariables = sPageURL.split('&');

	for (var i = 0; i < sURLVariables.length; i++) {

		var sParameterName = sURLVariables[i].split('=');

		if (sParameterName[0] == sParam) {

			return sParameterName[1];

		}

	}

}

function bindSubmitAction() {
	$('#createEMRSubmit').click(
			function() {

				var race = $(this).attr("race");
				var occupation = $(this).attr("occupation");
				var address = $(this).attr("address");
				var height = $(this).attr("height");
				var weight = $(this).attr("weight");
				var blood_group = $(this).attr("blood_group");
				var vaccinations = $(this).attr("vaccinations");
				var diabetes = $(this).attr("diabetes");
				var allergies = $(this).attr("allergies");

				$.ajax({
					type : "GET",
					url : "/emr/create_emr",
					data : "race=" + race + "&occupation=" + occupation
							+ "&address=" + address + "&height=" + height
							+ "&weight=" + weight + "&blood_group="
							+ blood_group + "&vaccinations=" + vaccinations
							+ "&diabetes" + diabetes + "&allergies="
							+ allergies + "&patientId=" + id,
					success : function(data) {
						var responseData = eval(data);
						alert(data);
						// if (data['hasEmr'] == 'true') {
						// $button.attr("href", "emr.html?patient_id=" +
						// patient_id);
						// } else if (data['hasEmr'] == "false") {
						// $button.attr('class', 'btn btn-danger btn-xs');
						// }
					},
					dataType : "text",
				});
			});
}
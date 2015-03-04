var id;
var emr_id;
var age;
var birthday;
var gender;
var name;
var race;
var occupation;
var address;
var height;
var weight;
var blood_group;
var vaccinations;
var diabetes;
var allergies;
$(document).ready(function() {
	getPatientID();
	getPatientBasicInfo();
	getEmrBasicInfo();
	getTranscriptionList();
	getPysicianList();
})

function getPatientID() {
	id = getUrlParameter("patient_id");
}
function getPatientBasicInfo() {
	$.ajax({
		type : "GET",
		url : "/emr/view",
		data : "patientId=" + id,
		success : function(data) {
			age = data["patient_age"];
			gender = data["patient_gender"];
			name = data["patient_name"];
			birthday = data["patient_birthday"];
			$('#name').val(name);
			$('#birth').val(birthday);
			$('#age').val(age);
			$('#gender').val(gender);
		},
		dataType : "json",
	});

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
function getEmrBasicInfo(){
	$.ajax({
		type : "GET",
		url : "/emr/view",
		data : "patientId=" + id,
		success : function(data) {
			emr_id = data["emr_id"];
			race = data["race"];
			occupation = data["occupation"];
			address = data["address"];
			height = data["height"];
			weight = data["weight"];
			blood_group = data["blood_group"];
			vaccinations = data["vaccinations"];
			diabetes = data["diabetes"];
			allergies = data["allergies"];
			$('#race').val(race);
			$('#occupation').val(occupation);
			$('#address').val(address);
			$('#height').val(height);
			$('#weight').val(weight);
			$('#blood_group').val(blood_group);
			$('#vaccinations').val(vaccinations);
			$('#diabetes').val(diabetes);
			$('#allergies').val(allergies);
		},
		dataType : "json",
	});
}
function getTranscriptionList(){
	$.ajax({
		type : "GET",
		url : "/emr/view",
		data : "emr_id=" + id,
		success : function(data) {
			race = data["race"];
			occupation = data["occupation"];
			address = data["address"];
			height = data["height"];
			weight = data["weight"];
			blood_group = data["blood_group"];
			vaccinations = data["vaccinations"];
			diabetes = data["diabetes"];
			allergies = data["allergies"];
			$('#race').val(race);
			$('#occupation').val(occupation);
			$('#address').val(address);
			$('#height').val(height);
			$('#weight').val(weight);
			$('#blood_group').val(blood_group);
			$('#vaccinations').val(vaccinations);
			$('#diabetes').val(diabetes);
			$('#allergies').val(allergies);
		},
		dataType : "json",
	});
}
function getPysicianList(){
	
}

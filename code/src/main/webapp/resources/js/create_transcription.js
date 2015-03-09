var patientId;
var emrId;
var transcriptionId;
$(document).ready(function() {
	patientId = getUrlParameter("patientId");
	emrId = getUrlParameter("emrId");
	createNewTranscription();
	$("#addNewDrug").click(addNewDrug());

});
function createNewTranscription() {
	var query = "emrId=" + emrId + "&patientId=" + patientId;
	$.ajax({
		type : "GET",
		url : "/transcription/create",
		data : query,
		success : function(data) {
			transcriptionId = data.id;
			getTranscriptionBasicContent(transcriptionId); // for 1st panel
			registerSurgeryInput();
			registerDiagnosticTestInput();
		},
		dataType : "json",
	});
}
function registerSurgeryInput() {
	
}
function registerDiagnosticTestInput() {
	
}
function getTranscriptionBasicContent(transcriptionId) {
	$.ajax({
		type : "GET",
		url : "/transcription/getTranscription",
		data : "transcription_id=" + transcriptionId,
		success : function(data) {
			var patient_name = data.patient_name;
			var content = data.content;
			var physician_name = data.physician_name;
			var create_date = data.create_date;
			console.log(patient_name);
			$("#patient_name").text(patient_name);
			$("#physician_name").text(physician_name);
			$("#comment").text(content);
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
function addNewDrug() {
	var row = "<tr>"
			+ "<td><a href=\"#\" name=\"prescription\" id=\"prescription\" data-type=\"checklist\" data-title=\"Select options\"></a></td>"
			+ "<td><textarea type=\"text\" class=\"form-control\" id=\"inputSuccess\"></textarea></td>"
			+ "<td><textarea type=\"text\" class=\"form-control\" id=\"inputSuccess\"></textarea></td>"
			+ "<td><textarea type=\"text\" class=\"form-control\" id=\"inputSuccess\"></textarea></td>"
			+ "</tr>";
	$("#prescription-body").append(row);
	$('a[name=\'prescription\']').editable({
		placement : 'bottom',
		value : [],
		source : [ {
			value : 1,
			text : 'Famotidine'
		}, {
			value : 2,
			text : 'Amlodipine'
		}, {
			value : 3,
			text : 'Paracetamol'
		}, {
			value : 4,
			text : 'Jakafi '
		}, {
			value : 5,
			text : 'Valacyclovir '
		}, {
			value : 6,
			text : 'Kazano'
		} ]
	});
}

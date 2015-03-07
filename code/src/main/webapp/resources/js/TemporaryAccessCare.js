var id;
var relation_id;
$(document).ready(function() {
	getPatientID();
	loadTemporaryAccessCare();
	loadAutocomplete();

});

function loadAutocomplete() {
	var availableTags = [ "ActionScript", "AppleScript", "Asp", "BASIC", "C",
			"C++", "Clojure", "COBOL", "ColdFusion", "Erlang", "Fortran",
			"Groovy", "Haskell", "Java", "JavaScript", "Lisp", "Perl", "PHP",
			"Python", "Ruby", "Scala", "Scheme" ];
	$("#physician_input").autocomplete({
		source : availableTags
	});
}

function loadTemporaryAccessCare() {
	$.ajax({
		type : "GET",
		url : "/relation/temporaryCare",
		data : "patient_id=" + id,
		success : function(data) {
			loadTemporaryAccessCareData(data);
		},
		dataType : "json",
	});
}

function getPatientID() {
	id = getUrlParameter("patient_id");
}

function loadTemporaryAccessCareData(temporary) {
	var dataSet = [];
	for ( var i in temporary) {
		var access = [];
		access.push(temporary[i].physician_name);
		access.push(temporary[i].access_right);
		access.push(temporary[i].end_date);
		var button = "<button name=\"temporary_access\" id=\""
				+ temporary[i].relation_id
				+ "\" class=\"btn btn-danger btn-xs\"><i class=\"fa fa-trash-o fa-lg\"></i> Delete</button>";
		access.push(button);
		dataSet.push(access);
	}
	console.log(dataSet);
	$('#dataTables-temporary-physician').DataTable({
		"responsive" : true,
		"data" : dataSet,
		"columns" : [ {
			"title" : "Physician Name",
			"class" : "center"
		}, {
			"title" : "Access Right",
			"class" : "center"
		}, {
			"title" : "Expired Date",
			"class" : "center"
		}, {
			"title" : "Action",
			"class" : "center"
		} ]
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
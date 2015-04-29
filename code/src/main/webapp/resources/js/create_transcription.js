var patientId;
var emrId;
var transcriptionId;
var operator_title;
$(document).ready(function() {
	patientId = getUrlParameter("patientId");
	emrId = getUrlParameter("emrId");
	createNewTranscription();
});
function registerUpdateTranscriptionButton() {
	$('#updateTranscription').click(
			function() {
				var content = $('#comment').val();
				var abstraction = $('#abstraction').val();
				$.ajax({
					type : "POST",
					url : "/transcription/update",
					data : 'content=' + content + '&abstraction=' + abstraction
							+ '&transcriptionId=' + transcriptionId,
					success : function(data) {
						window.location.href = "/pages/emr.html?patient_id="
								+ patientId + '#orange';
					},
					dataType : "text",
				});
			});
}
function createNewTranscription() {
	var query = "emrId=" + emrId + "&patientId=" + patientId;
	$.ajax({
		type : "GET",
		url : "/transcription/create",
		data : query,
		success : function(data) {
			transcriptionId = data;
			getTranscriptionBasicContent(transcriptionId); // for 1st panel

			$("#createPrescription").on('click', function() {
				createPrescription();
			});
			registerUpdateTranscriptionButton();
		},
		dataType : "text",
	});
}
function registerTreatment() {
	$("#treatment").empty();
	$.ajax({
		type : "GET",
		url : "/treatment",
		success : function(data) {
			for ( var i in data) {
				var treatment_name = data[i].treatment_name;
				var treatment_id = data[i].treatment_id;
				var treatment_dom = "<option value=\"" + treatment_id + "\">"
						+ treatment_name + "</option>";
				$("#treatment").append(treatment_dom);
			}
			registerTreatmentAddButton();
		},
		dataType : "json",
	});
}
function registerTreatmentAddButton() {
	$('#addTreatment').on(
			'click',
			function() {
				var treatment_name = $("#treatment option:selected").text();
				var treatment_id = $("#treatment option:selected").val();
				$.ajax({
					type : "GET",
					url : "/treatment/add",
					data : 'treatmentName=' + treatment_name
							+ '&transcriptionId=' + transcriptionId
							+ '&treatmentId=' + treatment_id,
					success : function(data) {
						$('#treatment_list').append('<br>' + treatment_name);
					},
					dataType : "text",
				});
			});
}
function registerSurgeryInput() {
	console.log(operator_title);
	if (operator_title == "MEDICAL_STAFF") {
		$("#surgeryInput").prop('disabled', true);
		console.log("surgery input disabled");
	} else if (operator_title == "PHYSICIAN") {
		$("#surgeryInput").on(
				"keyup",
				function() {
					console.log("here");
					var input = $('#surgeryInput').val();
					$.ajax({
						type : "GET",
						url : "/surgery/autocomplete",
						data : 'input=' + input,
						success : function(data) {
							var suggestion = [];
							for ( var i in data) {
								suggestion.push(data[i].surgery_id + "_"
										+ data[i].surgery_name);
							}
							$("#surgeryInput").autocomplete({
								source : suggestion
							});
						},
						dataType : "json",
					});
				});
		registerSurgeryAddButton();
	}
}
function registerSurgeryAddButton() {
	$('#addSurgery').on(
			'click',
			function() {
				var id_surgery = $('#surgeryInput').val();
				var surgeryId = id_surgery.split('_')[0];
				var surgeryName = id_surgery.split('_')[1];
				$.ajax({
					type : "GET",
					url : "/surgery/add",
					data : 'surgeryName=' + surgeryName + '&transcriptionId='
							+ transcriptionId + '&surgeryId=' + surgeryId,
					success : function(data) {
						$('#surgery').append('<br>' + id_surgery);
					},
					dataType : "text",
				});
			});
}
function registerDiagnosticTestInput() {
	console.log("here");
	$("#diagnosticTestInput").on(
			"keyup",
			function() {
				console.log("here");
				var input = $('#diagnosticTestInput').val();
				$.ajax({
					type : "GET",
					url : "/diagnostictest/autocomplete",
					data : 'input=' + input,
					success : function(data) {

						var suggestion = [];
						for ( var i in data) {
							suggestion.push(data[i].diagnostic_test_id + "_"
									+ data[i].diagnostic_test_name);
						}
						$("#diagnosticTestInput").autocomplete({
							source : suggestion
						});
					},
					dataType : "json",
				});
			});
	registerDiagnostictestAddButton();
}
function registerDiagnostictestAddButton() {
	$('#addTest').on(
			'click',
			function() {
				var id_test = $('#diagnosticTestInput').val();
				var testId = id_test.split('_')[0];
				var testName = id_test.split('_')[1];
				$.ajax({
					type : "GET",
					url : "/diagnostictest/add",
					data : 'testName=' + testName + '&transcriptionId='
							+ transcriptionId + '&testId=' + testId,
					success : function(data) {
						$('#diagnostictest').append('<br>' + id_test);
					},
					dataType : "text",
				});
			});
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
			var operator_name = data.writer_name;
			operator_title = data.writer_type;
			console.log(patient_name);
			$("#patient_name").val(patient_name);
			$("#physician_name").val(physician_name);
			$("#comment").val(content);
			$("#operator_name").val(operator_name);
			$("#operator_title").val(operator_title);
			registerSurgeryInput();
			registerDiagnosticTestInput();
			registerTreatment();
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
function createPrescription() {
	if (!$("#panelcontent").is(':visible')) {
		$.ajax({
			type : "GET",
			url : "/prescription/add",
			data : "transcriptionId=" + transcriptionId + "&patientId="
					+ patientId,
			success : function(data) {
				$("#panelcontent").show("slow");
				var prescriptionId = data;
				registerAddDrug(prescriptionId);
			},
			dataType : "text",
		});
	}
}
function registerAddDrug(prescriptionId) {
	$("#drugInput").on(
			"keyup",
			function() {
				console.log("here");
				var input = $('#drugInput').val();
				var nameType = $("#nameType").val();
				$.ajax({
					type : "GET",
					url : "/drug/search",
					data : 'drugInput=' + input + "&drugNameType=" + nameType,
					success : function(data) {
						var suggestion = [];
						for ( var i in data) {
							suggestion.push(data[i].drug_type + "_"
									+ data[i].drug_name_medical + "_"
									+ data[i].drug_name_commercial + "_"
									+ data[i].drug_dose + "_"
									+ data[i].drug_usage + "_"
									+ data[i].drug_refill_times + "_"
									+ data[i].drug_price);
						}
						$("#drugInput").autocomplete({
							source : suggestion
						});
					},
					dataType : "json",
				});
			});
	registerDrugAddButton(prescriptionId);
}
function registerDrugAddButton(prescriptionId) {
	$('#addDrug').on(
			'click',
			function() {
				var complexDrugNameInput = $('#drugInput').val();
				var drugId = 1;
				var drug_name_medical = complexDrugNameInput.split('_')[1];
				var drug_name_commercial = complexDrugNameInput.split('_')[2];
				var drug_dose = complexDrugNameInput.split('_')[3];
				var drug_usage = complexDrugNameInput.split('_')[4];
				var drug_refill_times = complexDrugNameInput.split('_')[5];
				var drug_price = complexDrugNameInput.split('_')[6];
				var amount = $('#amount').val();
				var refill = $('#refill').val();
				$.ajax({
					type : "GET",
					url : "/drug/add",
					data : 'medicalName=' + drug_name_medical
							+ "&commercialName=" + drug_name_commercial
							+ "&dose=" + drug_dose
							+ "&price=" + drug_price + '&prescriptionId='
							+ prescriptionId + '&drugId=' + drugId + '&amount='
							+ amount + "&refill=" + refill,
					success : function(data) {
						var row = '<tr>';
						row += '<td>' + drug_name_medical + '</td>';
						row += '<td>' + drug_name_commercial + '</td>';
						row += '<td>' + drug_dose + '</td>';
						row += '<td>' + drug_usage + '</td>';
						row += '<td>' + drug_refill_times + '</td>';
						row += '<td>' + drug_price + '</td>';
						row += '<td>' + amount + '</td>';
						row += '<td>' + refill + '</td>';
						row += '</tr>';
						var $rowDom = $.parseHTML(row);
						$('#drugTableContent').append($rowDom);
						$rowDom.show('slow');
					},
					dataType : "text",
				});
			});
}
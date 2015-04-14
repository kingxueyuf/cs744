$(document).ready(function() {
	loadCooperationData();
})
function loadCooperationData() {
	$.ajax({
		type : "GET",
		url : "/relation/physicianAndMedicalStaff",
		success : function(data) {
			loadTable(data);
		},
		dataType : "json",
	});
}
function loadTable(data) {
	var dataSet = [];
	for ( var i in data) {
		var cooperationItem = [];
		cooperationItem.push(data[i].physician_id);
		cooperationItem.push(data[i].physician_name);
		cooperationItem.push(data[i].msid);
		cooperationItem.push(data[i].ms_name);
		dataSet.push(cooperationItem);
	}
	$('#trans-table').DataTable({
		"responsive" : true,
		"data" : dataSet,
		"columns" : [ {
			"title" : "Physician Id"
		}, {
			"title" : "Physician Name"
		}, {
			"title" : "Medical Staff Name Id"
		}, {
			"title" : "Medical Staff Name"
		} ],
	});
}
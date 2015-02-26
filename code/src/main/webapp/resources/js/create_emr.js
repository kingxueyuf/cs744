$(document).ready(function() {
	bindSubmitAction();
	
})

function bindSubmitAction(){
	$('#createEMRSubmit').click( function(){
// var patient_id = $(this).attr("patient_id");
// var name = $(this).attr("name");
// var
		var id = 1;
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
			data : "race=" + race + "&occupation=" + occupation + "&address=" + address + "&height="+ height + "&weight=" 
			+ weight + "&boold_group=" + boold_group + "&vaccinations="+ vaccinations + "&diabetes" 
			+ diabetes + "&allergies=" + allergies + "&patient_id=" + id,
			success : function(data) {

//				if (data['hasEmr'] == 'true') {
//					$button.attr("href", "emr.html?patient_id=" + patient_id);
//				} else if (data['hasEmr'] == "false") {
//					$button.attr('class', 'btn btn-danger btn-xs');
//				}
			},
			dataType : "json",
		});
	});
}
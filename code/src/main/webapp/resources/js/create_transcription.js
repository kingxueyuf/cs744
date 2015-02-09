$(document)
		.ready(
				function() {
					$("#addNewDrug")
							.click(
									function() {
										var row = "<tr>"
												+ "<td><a href=\"#\" name=\"prescription\" id=\"prescription\" data-type=\"checklist\" data-title=\"Select options\"></a></td>"
												+ "<td><textarea type=\"text\" class=\"form-control\" id=\"inputSuccess\"></textarea></td>"
												+ "<td><textarea type=\"text\" class=\"form-control\" id=\"inputSuccess\"></textarea></td>"
												+ "<td><textarea type=\"text\" class=\"form-control\" id=\"inputSuccess\"></textarea></td>"
												+ "</tr>";
										$("#prescription-body").append(row);
										$('a[name=\'prescription\']').editable(
												{
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
									});
				});

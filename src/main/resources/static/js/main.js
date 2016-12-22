$(document).ready(function() {

	$("#grid").jqGrid({
	    datatype: "local",
	    height: 250,
	    colNames: ['id','Name', 'Location'],
	    colModel: [{
	        name: 'id',
	        index: 'id',
	        width: 60,
	        sorttype: "int"},
	    {
	        name: 'name',
	        index: 'name',
	        width: 120,
	        sorttype: "string"},
	    {
	        name: 'location',
	        index: 'location',
	        width: 120,
	        sorttype: "string"
	        }
	    ],
	    caption: "Search Result"
	    });
	    
	
	$('#searchDealer').click(function(){
		var self=this;
		function renderHtml(mydata){
			if(mydata.length>0){
				$('#grid').jqGrid('clearGridData');
			for (var i = 0; i <= mydata.length; i++) {
			    $("#grid").jqGrid('addRowData', i + 1, mydata[i]);
			}
			}
			else{
				alert("No Data Found");
			}
	    }
		var searchUrl="search?"
			var append="";
		$.each($('#myform :input'), function(index,node){
			searchUrl+=append;
			searchUrl+=node.id
			if(node.value){
				searchUrl+="=";
				searchUrl+=node.value;
			}
			append="&";
		});
		console.log(searchUrl);
		
		$.get(searchUrl,renderHtml).done(function(){
			console.log('done')
		}).fail(function(e){
			console.log('error '+e);
		});
	});	
	

	
});
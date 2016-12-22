$(document).ready(function() {
	$('#searchDealer').click(function(){
		var self=this;
		function renderHtml(data){
			console.log(jQuery.parseJSON(data));
	        $("#result").html(data);
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
		
		$.ajax({url: searchUrl, dataType:"json" ,
		success: function (data){
			self.renderHtml(data)}
		 });
	
	});	
	
});
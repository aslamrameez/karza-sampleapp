$(document).ready(function() {

	$('#saveDealer').click(function(){
		var sendInfo={tinNo: $('#tin').val(), location: $('#location').val(), name:  $('#name').val() };
		console.log(sendInfo);
		$.ajax({
            type: 'post',
            url: '/create',
            data: JSON.stringify(sendInfo),
            contentType: "application/json; charset=utf-8",
            traditional: true,
            success: function (data) {
              console.log(data)
              alert('Success');
              location.href="/index.html"
            }
        });
	});
	
});
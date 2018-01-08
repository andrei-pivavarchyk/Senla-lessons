




$(window).load(function() {

	$(".loader_inner").fadeOut();
	$(".loader").delay(400).fadeOut("slow");


    $(document).ready(function(){
        $("#button").click(function(){

            text = $("#json").val();
            var userJson = JSON.stringify(text);
            //
            $.ajax
            ({
                type: "POST",//Метод передачи
                data: text,//Передаваемые данные в JSON - формате
                url: 'simple',//Название сервлета
                contentType: "application/json",
                error: function(message) {
                    $("#response").html(message);
                    console.log(message);

                },
                success: function(data) {
                    $("#response").html(data);
                    console.log(data);

                }
            });
        });
    });

});

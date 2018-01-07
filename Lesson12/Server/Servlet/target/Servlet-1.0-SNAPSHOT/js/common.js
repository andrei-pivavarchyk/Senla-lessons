$(function() {

	//SVG Fallback
	if(!Modernizr.svg) {
		$("img[src*='svg']").attr("src", function() {
			return $(this).attr("src").replace(".svg", ".png");
		});
	};

	//E-mail Ajax Send
	//Documentation & Example: https://github.com/agragregra/uniMail
	$("form").submit(function() { //Change
		var th = $(this);
		$.ajax({
			type: "POST",
			url: "mail.php", //Change
			data: th.serialize()
		}).done(function() {
			alert("Thank you!");
			setTimeout(function() {
				// Done Functions
				th.trigger("reset");
			}, 1000);
		});
		return false;
	});

	//Chrome Smooth Scroll
	try {
		$.browserSelector();
		if($("html").hasClass("chrome")) {
			$.smoothScroll();
		}
	} catch(err) {

	};

	$("img, a").on("dragstart", function(event) { event.preventDefault(); });

});

$(window).load(function() {

	$(".loader_inner").fadeOut();
	$(".loader").delay(400).fadeOut("slow");


    $(document).ready(function(){
        $("#button").click(function(){
            var data = {};
            data = $("#json").val();
            //
            $.ajax
            ({
                type: "POST",//Метод передачи
                data: data,//Передаваемые данные в JSON - формате
                url: 'simple',//Название сервлета
                success:function(serverData)//Если запрос удачен
                {
                    $("#auth-info").css({"background-color":serverData.backgroundColor, "height": "50px", "color":"white"});
                    $("#auth-info").html(serverData.serverInfo);
                },
                error: function(e)//Если запрос не удачен
                {
                    $("#auth-info").css({"background-color":"#CC6666", "height": "50px", "color":"white"});
                    $("#auth-info").html("Запрос не удался!");
                }
            });
        });
    });



});

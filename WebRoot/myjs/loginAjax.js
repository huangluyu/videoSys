$(function() {
    $.ajax({  
    	type: "POST",   
        url: "loginAjax.action",  
        data: "username=zhangsan",  
        dataType:'json',  
        success: function(data){ 
        	if(data.username == "游客" || data.username == "null")
        	{
        		$("#loginText").show();
   			}
     		else
     		{
       			$("#myUserInfo").show();
     			$("#realName").text("欢迎:" + data.username + "!");
     			$("#money").text("积分:" + data.money);
     		}
       		if(data.authority == 2)
       		{
       			$("#videoManage").show();
   			} else if(data.authority == 3)
			{
       			$("#adminManage").show();
			}
        },  
        error: function(XMLHttpRequest, textStatus, errorThrown){
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
		}
	}); 
});

;(function($, window, undefined) {
    // outside the scope of the jQuery plugin to
    // keep track of all dropdowns
    var $allDropdowns = $();

    // if instantlyCloseOthers is true, then it will instantly
    // shut other nav items when a new one is hovered over
    $.fn.dropdownHover = function(options) {

        // the element we really care about
        // is the dropdown-toggle's parent
        $allDropdowns = $allDropdowns.add(this.parent());

        return this.each(function() {
            var $this = $(this).parent(),
                defaults = {
                    delay: 50,
                    instantlyCloseOthers: true
                },
                data = {
                    delay: $(this).data('delay'),
                    instantlyCloseOthers: $(this).data('close-others')
                },
                options = $.extend(true, {}, defaults, options, data),
                timeout;

            $this.hover(function() {
                if(options.instantlyCloseOthers === true)
                    $allDropdowns.removeClass('open');

                window.clearTimeout(timeout);
                $(this).addClass('open');
            }, function() {
                timeout = window.setTimeout(function() {
                    $this.removeClass('open');
                }, options.delay);
            });
        });
    };

    $('[data-hover="dropdown"]').dropdownHover();
})(jQuery, this);
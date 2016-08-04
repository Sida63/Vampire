$(function() {

    setupCheckout();
});



function setupCheckout() {
	// frame setup
    $(".checkout_form").accordion({
        heightStyle: "content",
        active : 0,
        activate: function( event, ui ) {
        	$('html, body').animate({
              scrollTop: ui.newHeader.offset().top
          }, 500);
        }
    });

    $(".tostep1").click(function() {
    	$(".checkout_form").accordion("option", "active", 0);
    });

    $(".tostep2").click(function() {
    	$(".checkout_form").accordion("option", "active", 1);
    });    

    $(".tostep3").click(function() {
    	$(".checkout_form").accordion("option", "active", 2);
    });    

    $(".tostep4").click(function() {
    	$(".checkout_form").accordion("option", "active", 3);
    });

    setupDelivery();
}

function setupDelivery() {
    // we can not hide a block, which is impossible.
    // so hide a nested div instead.
    $(".template-line div").hide();

    $(".new-delivery-radio").click(function(){
        $(".new-delivery-form").slideDown();
    });

    // new delivery form
    $(".whereform a").click(function () {
        var delivery = [
        {
            name: "delivery.name",
            value: $(".whereform input[name='delivery.name']").val()
        },
        {
            name: "delivery.tel",
            value: $(".whereform input[name='delivery.tel']").val()
        },
        {
            name: "delivery.code",
            value: $(".town_switcher option:selected").attr("value")
        },
        {
            name: "delivery.addr",
            value: $(".whereform input[name='delivery.addr']").val()
        }
        ];
        $.ajax({
            type: "post",
            dataType: "json",
            url: "user/deliveries",//要访问的后台地址, 注意！！！改这里
            data: delivery,
            complete :function(){
                loadDelivery();
            }
        });
        return false;
    });

    // area select
    $(".whereform select").css("width", "100px");
    $(".province_switcher").change(function (){
        loadCity($(".province_switcher option:selected").attr("value"));
        loadTown($(".city_switcher option:selected").attr("value"));
    });
    $(".city_switcher").change(function (){
        loadTown($(".city_switcher option:selected").attr("value"));
    });

    loadProv();
    loadDelivery();
}

function loadDelivery() {
    $.ajax({
        type: "get",
        dataType: "json",
        url: "user/deliveries",//要访问的后台地址, 注意！！！改这里

        // complete :function(){remove_loader(block);},
        
        /*
         * msg 是JSON对象
         * 表示一个order实体的数组
         */
         success: function(msg) {
            // clear the table, but leave the template line.
            $(".delivery-lines").find(".delivery-line:not(.template-line)").remove();

            var hasDef = false;
            $.each(msg.deliveries, function(idx, item){
                var row = $(".delivery-line.template-line").clone();
                $(row).removeClass("template-line");

                // bind data
                row.find("input[type=radio]").attr("value", item.id);
                row.find(".who").text(item.receiver);
                row.find(".where").text(item.detailAddr);
                row.find(".tel").text(item.tel);

                // add event handler
                $(row).click(function(){
                    $(".new-delivery-form").slideUp();
                })

                // add to dom tree
                row.prependTo(".delivery-lines");
                $(row).find('div').show();

                if(msg.defDelivery == item.id) {
                    row.find("input[type=radio]").attr("checked", "checked");
                    row.click();
                    hasDef = true;
                }
            });

            if(!hasDef) {
                $(".new-delivery-radio").attr("checked", "checked");
                $(".new-delivery-radio").slideUp();
            }
        }
    });
}

function loadProv() {
    $.ajax({
        type: "get",
        dataType: "json",
        url: "area/list",//要访问的后台地址, 注意！！！改这里
        
        /*
         * msg 是JSON对象
         * 表示一个order实体的数组
         */
         success: function(msg) {
            // clear the table, but leave the template line.
            $(".province_switcher option").remove();

            $.each(msg.provinces, function(idx, item){
                var row = $("<option></option>");

                row.text(item.area);
                row.attr("value", item.id);

                row.appendTo(".province_switcher");
            });
        }
    });
}

function loadCity(provinceCode) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: "area/" + provinceCode + "/list",//要访问的后台地址, 注意！！！改这里
        
        /*
         * msg 是JSON对象
         * 表示一个order实体的数组
         */
         success: function(msg) {
            // clear the table, but leave the template line.
            $(".city_switcher option").remove();

            $.each(msg.cities, function(idx, item){
                var row = $("<option></option>");

                row.text(item.area);
                row.attr("value", item.id);

                row.appendTo(".city_switcher");
            });
        }
    });
}

function loadTown(cityCode) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: "area/" + cityCode + "/list",//要访问的后台地址, 注意！！！改这里
        
        /*
         * msg 是JSON对象
         * 表示一个order实体的数组
         */
         success: function(msg) {
            // clear the table, but leave the template line.
            $(".town_switcher option").remove();

            $.each(msg.towns, function(idx, item){
                var row = $("<option></option>");

                row.text(item.area);
                row.attr("value", item.id);

                row.appendTo(".town_switcher");
            });
        }
    });
}
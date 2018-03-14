function barClick() {
    var pathname = basePath + window.location.pathname;

    $(".nav-list li a").each(function() {

        var href = $(this).attr("href");

        if(pathname ==  href){

            $(this).parents("ul").parent("li").addClass("active open");

            $(this).parent("li").addClass("active");

        }

    });
}
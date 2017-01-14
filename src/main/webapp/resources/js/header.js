// http://stackoverflow.com/questions/19091206/403-forbidden-error-with-ajax-get-request-spring
$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});

function index() {
    window.location = "/electronsun/index"
}
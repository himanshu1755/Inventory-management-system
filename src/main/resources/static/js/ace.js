(function($) {
  'use strict';
  var editor = ace.edit("aceExample");
  editor.setTheme("ace/theme/chaos");
  editor.getSession().setMode("ace/mode/javascript");
  document.getElementById('aceExample').style.fontSize = '1rem';
})(jQuery);

$(function () {
    $('#addProductForm').submit(function (event) {
        event.preventDefault();
        var formData = $('#addProductForm').serializeFormJSON();
        var base_path = $('#base-path').val();
        var base_path = "http://localhost:8080";
        formData = JSON.stringify(formData);
        console.log(formData);
        //fetch method
        var formType = $("#addServerform").attr("method");
        getServerResponse(formData, base_path + '/addProduct', formType).then((response) => {
//            if (response.hasOwnProperty("success")) {
//                alert(response.success, true);
//            } else if (response.hasOwnProperty("error")) {
//                alert(response.error);
//            }
        }).catch(e => {
            console.error(e);
//            if (e.hasOwnProperty("error") && e.hasOwnProperty("responseJSON")) {
//                alert(e.responseJSON);
//            } else {
//                console.error(e);
//            }
        });
    });
});
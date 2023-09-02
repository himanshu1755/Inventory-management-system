/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


async function getServerResponse(data, url, method) {
        console.log('===========');
        console.log(data);

    let result;
//    loadingAjax();
    result = await $.ajax({
        url: url,
        type: method,
        contentType: "application/json",
        data: data,
        dataType: 'json',
        timeout: 20000
    });
    console.log(result);
    return result;
}

(function ($) {
    $.fn.serializeFormJSON = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value.trim() || '');
            } else {
                o[this.name] = this.value.trim() || '';
            }
        });
        return o;
    };
})(jQuery);


function getAllProductToLed(optionId, selectId) {
    var option = $('#' + optionId + '0').val();
    if (option != undefined) return;
    $.ajax({
        url: '/electronsun/product/loadproducts',
        type: 'POST'
    }).done(function (json) {
        var i;
        var product;
        for (i=0; i<json.length; i++){
            product = json[i];
            if (product.maxLed > 0) {
                $('#' + selectId).append('<option id="' + optionId + i + '" value="' + product.id + '">' + product.name + '</option>');
            }
        }
    }).fail(function (xhr, status, errorThrown) {
        errorConsole(xhr, status, errorThrown);
    });

}
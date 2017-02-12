var lightShow;

jQuery("document").ready(function() {
    if (lightShow == undefined){
        $.ajax({
            url: '/electronsun/lightshow/getLightShowToSession',
            dataType: "json",
            type: "POST",
            success: function (json) {
                lightShow = json;
                body_right_value();
            }
        });
    }
});

function opendeviceLightShow() {
    $('#deviceLightShowModal').modal();
}

function loadUserDevices(optionId, selectId) {
    if ($('#' + optionId + '0').val() != undefined){
        return;
    }
    $.ajax({
        url: '/electronsun/device/loaduserdevices',
        dataType: "json",
        type: "POST",
        success: function (json) {
            var i;
            var product;
            var device;
            for (i=0; i<json.length; i++){
                device = json[i];
                product = json[i].product;
                $('#' + selectId).append('<option id="' + optionId + i + '" value="' + device.id + '">' + product.name + '</option>');
            }

        },
        error: function (xhr, status, errorThrown) {
            errorMessageBottom('Ошибка при загрузке данных');
            errorConsole(xhr, status, errorThrown);
        }
    });
}

function createShow() {
    var nameShow = $('#nameCreateShow').val();
    var deviceId = $('#create-select').val();
    if (deviceId == 0 || nameShow == ""){
        warningMessageBotton('обязательные поля не заполнены');
        return;
    }
    $.ajax({
        url: '/electronsun/lightshow/createlightshowto',
        dataType: "json",
        type: "POST",
        data:{
            nameShow:nameShow,
            deviceId:deviceId
        },
        success: function (json) {
            lightShow = json;
            $.modal.close();
            body_right_value();
        },
        error: function (xhr, status, errorThrown) {
            errorMessageBottom('Возникла ошибка при создании шоу');
            errorConsole(xhr, status, errorThrown);
        }
    });
}

// заполняем поля show-container1
function body_right_value() {
    $('#nameShow').html(lightShow.name);
    $('#nameDevice').html(lightShow.devices[0].product.name);

}
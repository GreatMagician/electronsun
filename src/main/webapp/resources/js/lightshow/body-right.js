var effect;

function addListEffectMy() {
    if (lightShow == undefined) return;
    $.ajax({
        url: '/electronsun/effect/loadlightshoweffect',
        dataType: "json",
        type: "POST",
        success: function (json) {
            var i;
            for (i=0; i<json.length; i++){
                $('#select-my-effects').append('<option ondblclick="selectMyEffectDblClick(' + json[i].id + ')" id="select-my-effects-' + json[i].id + '">' + json[i].name + '</option>');
            }
        }
    });

}

function addListEffectAll() {
    if (lightShow == undefined) return;
    $.ajax({
        url: '/electronsun/effect/loadusereffect',
        dataType: "json",
        type: "POST",
        success: function (json) {
            var i;
            for (i=0; i<json.length; i++){
                $('#select-all-effects').append('<option id="select-all-effects-' + json[i].id + '">' + json[i].name + '</option>');
            }
        }
    });

}

function addListEffectRemix() {
    if (lightShow == undefined) return;
}

function openCreateEffectsModal() {
   if (lightShow == undefined){
       warningMessageBotton('сначала откройте световое шоу');
   }else{
       $('#createEffectsModal').css({'max-width': '250px'});
       $('#createEffectsModal').modal();
   }
}

function createEffect() {
    $.modal.close();
    var nameEffect = $('#createEffectsModalName').val();
    $.ajax({
        url: '/electronsun/effect/createeffect',
        dataType: "json",
        type: "POST",
        data:{
            nameEffect: nameEffect
        },
        success: function (json) {
            effect = json;
            $('#select-my-effects').append('<option ondblclick="selectMyEffectDblClick(' + effect.id + ')" id="select-my-effects-' + effect.id + '">' + effect.name + '</option>');
        },
        error: function (xhr, status, errorThrown) {
            errorMessageBottom('Возникла ошибка при создании эффекта');
            errorConsole(xhr, status, errorThrown);
        }
    });
}

function addEvent() {
    if (lightShow == undefined) return;
    if(effect == undefined){
        warningMessageBotton('выберите эффект');
    }
}

function selectMyEffectDblClick(id) {
    var myEffectName = $('#select-my-effects-' + id).val();
    $('#nameEffectLabel').html(myEffectName);
    $.ajax({
        url: '/electronsun/effect/geteffect',
        dataType: "json",
        type: "POST",
        data:{
            id: id
        },
        success: function (json) {
            effect = json;
            var i;
            for (i=0; i<effect.eventEffectMap.size(); i++){
                $('#leds-select-event').append('<option id="leds-select-event-">'+i+'</option>');
            }
        },
        error: function (xhr, status, errorThrown) {
            errorMessageBottom('Возникла ошибка при загрузке данных');
            errorConsole(xhr, status, errorThrown);
        }
    });

}
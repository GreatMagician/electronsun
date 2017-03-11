var effect;
var eventEffects = [];
var eventNumber;
// добавить эффекты этого шоу в список
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
// добавить все эфекты юзера в список
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

// добавить эффекты ремикса в список
function addListEffectRemix() {
    if (lightShow == undefined) return;
}

// модальное окно создать эффект
function openCreateEffectsModal() {
   if (lightShow == undefined){
       warningMessageBotton('сначала откройте световое шоу');
   }else{
       $('#createEffectsModal').css({'max-width': '250px'});
       $('#createEffectsModal').modal();
   }
}

// создать эффект
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
            $('#select-my-effects').append('<option ondblclick="selectMyEffectDblClick(' + json.id + ')" id="select-my-effects-' + json.id + '">' + json.name + '</option>');
            effect = json;
            selectMyEffect();
        },
        error: function (xhr, status, errorThrown) {
            errorMessageBottom('Возникла ошибка при создании эффекта');
            errorConsole(xhr, status, errorThrown);
        }
    });
}

// добавить событие
function addEvent() {
    if (lightShow == undefined) return;
    if(effect == undefined){
        warningMessageBotton('выберите эффект');
        return;
    }
    $.ajax({
        url: '/electronsun/eventeffect/addeventeffect',
        dataType: "json",
        type: "POST",
        data:{
            effectId: effect.id
        },
        success: function (json) {
            eventEffects.push(json);
            effect.countEventEffect = eventEffects.length;
            $('#leds-select-event').append('<option  class="leds-select-event-remove" selected id="leds-select-event-'+ eventEffects.length +'"> '+ eventEffects.length +' </option>');
            selectEvent();
        },
        error: function (xhr, status, errorThrown) {
            errorMessageBottom('Возникла ошибка при загрузке данных');
            errorConsole(xhr, status, errorThrown);
        }
    });

}

// выбор эффекта этого шоу при двойном клике
function selectMyEffectDblClick(id) {
    $.ajax({
        url: '/electronsun/effect/geteffect',
        dataType: "json",
        type: "POST",
        data:{
            id: id
        },
        success: function (json) {
            effect = json;
            selectMyEffect();
        },
        error: function (xhr, status, errorThrown) {
            errorMessageBottom('Возникла ошибка при загрузке данных');
            errorConsole(xhr, status, errorThrown);
        }
    });

}

function selectMyEffect() {
    clearEventEffectOption();
    loadEventEffectList();
    var myEffectName = $('#select-my-effects-' + effect.id).val();
    if (myEffectName.length > 20){
        myEffectName = myEffectName.substring(0,22) + '..';
    }
    defaultColorNameEffectLabel();
    $('#nameEffectLabel').html(myEffectName);
    var i;
    for (i=1; i<=effect.countEventEffect; i++){
        $('#leds-select-event').append('<option class="leds-select-event-remove" id="leds-select-event-' + i + '"> ' + i + '</option>');
    }
}
var defaultColorNumber;
function defaultColorNameEffectLabel() {
    var color1 = $('#nameEffect-color-text').val();
    var color2 = $('#nameEffect-color-background').val();
    if (color1 == '#ffffff' && color2 == '#ffffff') {
        if  (defaultColorNumber == undefined) {
            color1 = '#2aff12';
            color2 = '#FF1F31';
            defaultColorNumber = 1;
        } else if (defaultColorNumber == 1) {
            color1 = '#9C09FA';
            color2 = '#FFCD1E';
            defaultColorNumber++;
        } else if (defaultColorNumber == 2) {
            color1 = '#0A13E2';
            color2 = '#FFFC16';
            defaultColorNumber++;
        } else if (defaultColorNumber == 3) {
            color1 = '#FF1ACB';
            color2 = '#21FF13';
            defaultColorNumber++;
        }  else if (defaultColorNumber == 4) {
            color1 = '#ff267b';
            color2 = '#19fdff';
            defaultColorNumber = undefined;
        }
    }
    $('#nameEffectLabel').css('color', color1);
    $('#nameEffectLabel').css('background-color', color2);
}

function loadEventEffectList() {
    if (effect == undefined){
        warningMessageBotton("Эффект не выбран");
        return;
    }
    $.ajax({
        url: '/electronsun/eventeffect/loadeventeffects',
        dataType: "json",
        type: "POST",
        data:{
            effectId: effect.id
        },
        success: function (json) {
            var i;
            eventEffects = [];
            for (i=0; i < json.length; i++){
                eventEffects.push(json[i]);
            }
            selectEvent();
        },
        error: function (xhr, status, errorThrown) {
            errorMessageBottom('Возникла ошибка при загрузке данных');
            errorConsole(xhr, status, errorThrown);
        }
    });

}

function clearEventEffectOption() {
    $('.leds-select-event-remove').remove();
}

function deleteEvent() {
    if (lightShow == undefined || effect == undefined) return;
    if (eventNumber == undefined) return;
    noty({
        text: 'Удалить событие №' + eventNumber,
        modal: true,
        type: 'alert',
        layout: 'center',
        buttons: [
            {addClass: 'btn btn-primary', text: 'Да', onClick: function($noty) {
                $noty.close();
                $.ajax({
                    url: '/electronsun/eventeffect/deleteeventeffect',
                    type: 'POST',
                    dataType: 'JSON',
                    data: {
                        eventNumber: eventNumber,
                        effectId: effect.id
                    }
                }).done(function (json) {
                    if (json == true){
                        removeEventEffect();
                        $('#leds-select-event-' + effect.countEventEffect).remove();
                        effect.countEventEffect--;
                        if (effect.countEventEffect > 0) {
                            $("#leds-select-event-1").prop("selected", true);
                            selectEvent(1);
                        }
                        sussesMessageBottom('Событие удалено');
                    }
                }).fail(function (xhr, status, errorThrown) {
                    errorMessageBottom(xhr.responseText);
                    errorConsole(xhr, status, errorThrown);
                });
            }
            },
            {addClass: 'btn btn-danger', text: 'Отмена', onClick: function($noty) {
                $noty.close();
            }
            }
        ]
    });
}
function selectEvent(number) {
    if (eventEffects == undefined || eventEffects.length == 0) return;
    if (number != undefined){
        eventNumber = number;
    }else{
        eventNumber = parseInt($('#leds-select-event').val());
    }
    if (eventNumber == undefined || eventEffects[eventNumber - 1] == undefined || eventEffects[eventNumber - 1].color == null) return;
    ($('#leds-color1'))[0].value = eventEffects[eventNumber - 1].color;
    $('#leds-number-appearance').val(eventEffects[eventNumber - 1].appearance);
    $('#leds-number-emission').val(eventEffects[eventNumber - 1].glow);
    $('#leds-number-brightness1').val(eventEffects[eventNumber - 1].brightness);
    if (eventEffects[eventNumber - 1].newColor == true){
        $('#leds-transition').prop( "checked", true );
    }else{
        $('#leds-transition').prop( "checked", false );
    }
    if (eventEffects[eventNumber - 1].newColorLed == '' || eventEffects[eventNumber - 1].newColorLed == null){
        ($('#leds-color2'))[0].value = eventEffects[eventNumber - 1].color;
    }else{
        ($('#leds-color2'))[0].value = eventEffects[eventNumber - 1].newColorLed;
    }
    $('#leds-number-lentransition').val(eventEffects[eventNumber - 1].transition);
    $('#leds-number-attenuation').val(eventEffects[eventNumber - 1].attenuation);
    $('#leds-number-pause').val(eventEffects[eventNumber - 1].pause);
    loadLeds();
}


function checkboxColor() {
    if (eventEffects == undefined) return;
    if (eventNumber != null){
        eventEffects[eventNumber - 1].newColor = ($('#leds-transition'))[0].checked;
    }
}

function getEvent() {
    eventEffects[eventNumber - 1].color = ($('#leds-color1'))[0].value;
    eventEffects[eventNumber - 1].appearance = $('#leds-number-appearance').val();
    eventEffects[eventNumber - 1].glow = $('#leds-number-emission').val();
    eventEffects[eventNumber - 1].brightness = $('#leds-number-brightness1').val();
    eventEffects[eventNumber - 1].newColorLed = ($('#leds-color2'))[0].value;
    eventEffects[eventNumber - 1].transition = $('#leds-number-lentransition').val();
    eventEffects[eventNumber - 1].attenuation = $('#leds-number-attenuation').val();
    eventEffects[eventNumber - 1].pause = $('#leds-number-pause').val();
}

function saveEvent() {
    if (eventEffects == undefined) return;
    if (eventNumber == undefined) return;
    getEvent();
    $.ajax({
        url: '/electronsun/eventeffect/saveeventeffect',
        dataType: "json",
        type: "POST",
        data:{
            id:             eventEffects[eventNumber - 1].id,
            numberOfEffect: eventEffects[eventNumber - 1].numberOfEffect,
            countLed:       eventEffects[eventNumber - 1].countLed,
            color:          eventEffects[eventNumber - 1].color,
            appearance:     eventEffects[eventNumber - 1].appearance,
            glow:           eventEffects[eventNumber - 1].glow,
            brightness:     eventEffects[eventNumber - 1].brightness,
            newColor:       eventEffects[eventNumber - 1].newColor,
            newColorLed:    eventEffects[eventNumber - 1].newColorLed,
            transition:     eventEffects[eventNumber - 1].transition,
            attenuation:    eventEffects[eventNumber - 1].attenuation,
            pause:          eventEffects[eventNumber - 1].pause,
            effectId:       effect.id
        },
        success: function (json) {
            sussesMessageBottom('Событие сохранено')
        },
        error: function (xhr, status, errorThrown) {
            errorMessageBottom('Возникла ошибка при сохранении события');
            errorConsole(xhr, status, errorThrown);
        }
    });
    saveLeds();
}

function removeEventEffect() {
    if (eventNumber != undefined) {
        delete eventLeds[eventNumber];
        delete eventEffects[eventNumber - 1];
        var arr = eventLeds;
        arr.forEach(function (item, i, arr) {
            if (i > eventNumber) {
                eventLeds[i-1] = item;
            }
        });
        delete eventLeds[eventLeds.length - 1];
        arr = eventEffects;
        arr.forEach(function (item, i, arr) {
            if (i > (eventNumber - 1)) {
                eventEffects[i-1] = item;
            }
        });
        delete eventLeds[eventLeds.length - 1];
    }
}

// отобразить светодиоды события
function changeColor() {
    ledColorFalseAll();
    if (eventEffects[eventNumber - 1] != undefined){
        $('#selected-leds').html(eventEffects[eventNumber - 1].countLed);
    }else{
        $('#selected-leds').html(0);
    }
    if (eventLeds[eventNumber] == undefined) return;
    var eventEffectId = eventEffects[eventNumber - 1].id;
    eventLeds[eventNumber].leds.forEach(function (item, i, leds) {
        if (item.eventEffectId == eventEffectId) {
            ledColorTrue(i);
        }
    });
}

function loadLeds() {
    if (eventLeds.length == 0 || eventLeds[eventNumber] == undefined || eventLeds[eventNumber].leds == undefined) {
        $.ajax({
            url: '/electronsun/leds/loadleds',
            dataType: "json",
            type: "POST",
            data: {
                eventEffectId: eventEffects[eventNumber - 1].id
            },
            success: function (json) {
                var arr = json;
                var jsonLeds = [];
                arr.forEach(function (item, i, arr) {
                    jsonLeds[item.number] = item;
                });
                eventLeds[eventNumber] = {
                    leds : []
                };
                eventLeds[eventNumber].leds = jsonLeds;
                changeColor();
            }
        });
    }else{
        changeColor();
    }
}

function saveLeds() {
    var json_text = JSON.stringify(eventLeds[eventNumber].leds, null, eventLeds[eventNumber].leds.length);
    $.ajax({
        url: '/electronsun/leds/saveleds',
        dataType: "json",
        type: "POST",
        data: {
            json_text : json_text
        },
        success: function (json) {
            var jsonLeds = [];
            json.forEach(function (item, i, json) {
                jsonLeds[item.number] = item;
            });
            eventLeds[eventNumber].leds = jsonLeds;
            sussesMessageBottom('Светодиоды сохранены')
        },
        error: function (xhr, status, errorThrown) {
            errorMessageBottom('Возникла ошибка при сохранении светодиодов');
            errorConsole(xhr, status, errorThrown);
        }
    });

}

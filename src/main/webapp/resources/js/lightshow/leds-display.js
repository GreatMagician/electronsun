var eventLeds = []; // списки светодиодов событий
// выбор прибора для запуска метода прорисовки
function commandCircle() {
    if (lightShow != null){
        if (lightShow.devices[0].product.name.indexOf('8') > 0){
            clearCircle();
            createCircle8();
        } else if (lightShow.devices[0].product.name.indexOf('32') > 0){
            clearCircle();
            createCircle32();
        }
    }
}

function clearCircle() {
    $('.circle, .circle-right-block').remove();
}

function createCircle8() {
    var i, k, count = 0;
    for (k=0; k<8; k++){
        for (i=0; i<8; i++){
            $('#led-display').append('<div id="circle-'+ count +'" class="circle" onclick="circleClick('+count+')"></div>');
            count++;
        }
        $('#led-display').append('<div class="circle-right-block"></div>');
    }
}

function createCircle32() {
    $('#led-display').append('<div class="circle"></div>');
}

function circleClick(numberCircle) {
    var numberEvent = $('#leds-select-event').val();
    if (numberEvent == undefined || eventEffects[numberEvent - 1] == undefined) return;
    var eventEffectId = eventEffects[numberEvent - 1].id;
    if (eventLeds[numberEvent] == undefined){
        eventLeds[numberEvent] = {
            leds : []
        };
        eventLeds[numberEvent].leds[numberCircle] = {
            number              : numberCircle,
            eventEffectId       : eventEffectId
        };
        $('#selected-leds').html(++eventEffects[numberEvent - 1].countLed);
        ledColorTrue(numberCircle);
    }else if (eventLeds[numberEvent].leds[numberCircle] == undefined){
        eventLeds[numberEvent].leds[numberCircle] = {
            number              : numberCircle,
            eventEffectId       : eventEffectId
        };
        $('#selected-leds').html(++eventEffects[numberEvent - 1].countLed);
        ledColorTrue(numberCircle);
    }else{
        delete eventLeds[numberEvent].leds[numberCircle];
        ledColorFalse(numberCircle);
        if (eventEffects[numberEvent - 1].countLed > 0){
            eventEffects[numberEvent - 1].countLed--;
        }
        $('#selected-leds').html(eventEffects[numberEvent - 1].countLed);
    }
}


function ledColorTrue(number) {
    $('#circle-' + number).css('background-color', ($('#leds-color1'))[0].value);
    $('#circle-' + number).css('border-color', ($('#leds-color1'))[0].value);
}
function ledColorFalse(number) {
    $('#circle-' + number).css('background-color', 'black');
    $('#circle-' + number).css('border-color', '#fffc2e');
}
function ledColorFalseAll() {
    $('.circle').css('background-color', 'black');
    $('.circle').css('border-color', '#fffc2e');
}
// Drag and Drop
var countTrack = 0; // кол-во созданных дорожек
var autoScroll = false;

jQuery("document").ready(function() {
    $('.show-content').mousemove(function(e){
        if (countTrack < 6 || autoScroll == false) return;
        if(e.target.closest('.show-content')){
            var target = e.target.closest('.show-content'); // Здесь что-то уникальное, что может указать на род. блок
            var height = target.offsetHeight;
            var targetCoords = target.getBoundingClientRect();
            var xCoord = e.clientX - targetCoords.left;
            var yCoord = e.clientY - targetCoords.top;
            if (yCoord <= (height * 10 / 100)){ // до 10%
                target.scrollTop = (target.scrollTop-2)<0?0:target.scrollTop - 2;
            }else if (yCoord > (height * 10 / 100) && yCoord <= (height * 30 / 100)){ // от 10% до 30%
                target.scrollTop = (target.scrollTop-1)<0?0:target.scrollTop - 1;
            }else if (yCoord > (height * 70 / 100) && yCoord <= (height * 90 / 100)){ // от 70% до 90%
                target.scrollTop = (target.scrollTop+1)>target.scrollHeight?target.scrollHeight:
                    target.scrollTop + 1;
            }else if (yCoord > (height * 90 / 100) ){ // от 90%
                target.scrollTop = (target.scrollTop+2)>target.scrollHeight?target.scrollHeight:
                    target.scrollTop + 2;
            }
        }

    });
});

function dragAndDrop(trackNumber) {
    var drop = '#show-track-' + trackNumber;
    $('#nameEffectLabel').draggable({
        containment: "body",
        helper: "clone",
        snap: drop,
        snapMode: "inner" // привязка к внутренним краям
    });
    $(drop).droppable({
        drop: function(event, ui) { // перетащено
            var bodyWidth = $('body').offset().left + $('body').width();
            var width = ui.helper["0"].offsetLeft + $('#nameEffectLabel').width();
            if (width + 50 < bodyWidth){
                addEffectToTrack(trackNumber, parseInt(ui.helper["0"].offsetLeft));
            }
        },
        activate: function() {
            $('.show-track-effect-' + effect.id).css({
                border: "medium double green"
            });
        },
        deactivate: function() {
            $('.show-track-effect-' + effect.id).css({
                border: "1px solid #fffc16"
            });
        }
    });
}



// создание дорожки
function createTrack() {
    countTrack++;
    $('.show-content').append(
        $('<div/>', {
            id: 'show-track-' + countTrack // Присваиваем блоку  id
        })
            .css({
                float: 'none',
                width: 99.8 + '%',
                height: 20 + 'px',
                //display: 'block',
                border: 1 + 'px solid #fffc16'
            })
            .append('<label class="show-track-number" title="Номер дорожки">'+ countTrack +'</label>')
    );
    addClassToTrack(countTrack);
    dragAndDrop(countTrack);
}

// проверка, подготовка и подключение к дорожке  Effect
function checkTrackEffect() {
    if (effect.track == 0){
        var track = getEmptyTrack();
        if (track == 0){
            createTrack();
            return;
        }
    }
    track = deleteClassToTrackFromIsEmpty();
    if (track > 0) {
        addClassToTrack(track);
        dragAndDrop(track);
    }else{
        dragAndDrop(effect.track);
    }
}

// удалить класс идентификатор эффекта если дорожка пустая и вернуть номер дорожки если удалён
function deleteClassToTrackFromIsEmpty() {
    for (var i=1; i<= countTrack; i++){
            var children = $('#show-track-' + i + ' label');
            if (children.length <= 1){
                var effectId = getEffectIdToTrack(i);
                if (checkClassToTrack(i, effectId)) {
                    $('#show-track-' + i).removeClass('show-track-effect-' + effectId);
                    return i;
                }
            }
    }
    return 0;
}
// добавить класс идентификатор для дорожки
function addClassToTrack(numberTrack) {
    var trackId = '#show-track-' + numberTrack;
    var classTrack = 'show-track-effect-' + effect.id;
    if (!checkClassToTrack(numberTrack)){
        $(trackId).addClass(classTrack);
    }
}
// проверить был ли добавлен класс идентификатор
function checkClassToTrack(numberTrack, effectId) {
    if (effectId == undefined) effectId = effect.id;
    return $('#show-track-' + numberTrack).hasClass('show-track-effect-' + effectId);
}

// получить id эффекта из дорожки
function getEffectIdToTrack(numberTrack) {
    var theClass = $('#show-track-' + numberTrack).attr('class');
    if (theClass != undefined){
        var arr = theClass.split(' ');
        return parseInt(arr[0].substring(18));
    }
    return undefined;
}
// возвращает номер пустой дорожки или 0 если нет пустой
function getEmptyTrack() {
    var i;
    for (i=1; i<=countTrack; i++){
        // Получить список меток в div с id
        var children = $('#show-track-' + countTrack + ' label');
        if (children.length <= 1){
            return i;
        }
    }
    return 0;
}
// загрузка  дорожек эффекта
function loadTrack(effectList) {
    clearTrackAll();
    countTrack = 0;
    effectList.forEach(function (item, i, effectList) {
        if (item.track > 0){
            createTrack();
            effect = item;
            addEffectToTrack(countTrack);
        }
    });
}
// удалить дорожки
function clearTrackAll() {
    $(".show-content *").remove();
}

// добавляет эффект в указанную дорожку
function addEffectToTrack(numberTrack, posX) {
    var color = [];
    color[1] = effect.colorText;
    color[2] = effect.colorBackground;
    if (effect.track > 0 ){
        if (posX != undefined){
                var element = '#element-' + numberTrack + '-' + effectList[effect.id].timeStart[0];
                var width = $(element).width();
                if (width != undefined) {
                    var crossing = checkCrossing(-1, posX, width, numberTrack);
                    if (crossing.transfer) {
                        if (crossing.leftNew != undefined){
                            posX = crossing.leftNew;
                        }
                        effectList[effect.id].timeStart.push(posX);
                        addElementTrack(numberTrack, posX, color);
                    }
                }
        }else { // загрузка из бд
            effect.timeStart.forEach(function (item, i) {
                var element = '#element-' + numberTrack + '-' + item;
                if ($(element).val() == undefined) {
                    addElementTrack(numberTrack, item, color);
                }
            });

        }
    }else{
        effect.track = numberTrack;
        if (effectList[effect.id].timeStart == undefined){
            effectList[effect.id].timeStart = [];
        }
        effectList[effect.id].timeStart.push(posX);
        addElementTrack(numberTrack, posX, color);
    }
}

// создание элемента дорожки
function addElementTrack(numberTrack, posX, color) {
    var parent = '#show-track-' + numberTrack;
    var element = '#element-' + numberTrack + '-' + posX;
    $(parent).append('<label class="ui-widget ui-corner-all ui-state-error" id="element-' + numberTrack +'-' + posX + '">'+ effect.name +'</label>');
    $(element)
        .css('color', color[1]).css('background-color', color[2])
    var pos = $(element).offset();
    pos.top -=20;
    pos.left = posX;
    $(element).offset(pos);
    dragAndDropElement(element, parent);
}

// перемещение самого элемента на дорожке
function dragAndDropElement(drag, drop) {
    $(drag).draggable({
        snap: drop,
        axis: "x",
        containment: "parent",
        create: function(event, ui) { // перетащено
        }
    });
    $(drop).droppable({
        drop: function(event, ui) { // перетащено
            var numberTrack = parseInt(drop.substring(12));
            if (ui.draggable["0"].id == 'nameEffectLabel'){ // создание
                if (checkClassToTrack(numberTrack)) {
                    addEffectToTrack(numberTrack, ui.helper["0"].offsetLeft);
                }
            }else { // перенос
                drag = '#' + ui.draggable["0"].id;
                var pos = $(drag).offset();
                pos.top -= 2;
                var oldPosX = parseInt(drag.substring(drag.lastIndexOf('-') + 1));
                var elementId = 'element-' + numberTrack + '-' + ui.helper["0"].offsetLeft;
                var width = $(drag).width();
                var leftNew = ui.helper["0"].offsetLeft;
                var crossing = checkCrossing(oldPosX, leftNew, width, numberTrack);
                if (!crossing.transfer){
                    pos.left = oldPosX;
                    $(drag).offset(pos);
                }else{
                    if (crossing.leftNew != undefined){
                        elementId = 'element-' + numberTrack + '-' + crossing.leftNew;
                        pos.left = crossing.leftNew;
                        leftNew = crossing.leftNew;
                    }
                    $(drag).offset(pos);
                    $(drag).attr("id", elementId);
                    effectList[crossing.effectId].timeStart[crossing.index] = leftNew;
                }
            }
        },
        activate: function(event, ui) {
            autoScroll = true;
            if (ui.draggable["0"].id == 'nameEffectLabel') {
                $('.show-track-effect-' + effect.id).css({
                    border: "medium double green"
                });
            }
        },
        deactivate: function(event, ui) {
            autoScroll = false;
            if (ui.draggable["0"].id == 'nameEffectLabel') {
                $('.show-track-effect-' + effect.id).css({
                    border: "1px solid #fffc16"
                });
            }
        }
    });
}

// проверка на пересечение элементов при переносе
function checkCrossing(oldPosX, leftNew, width, numberTrack) {
    var index, transfer = true;
    var bodyWidth = $('body').offset().left + $('body').width();
    var leftTransfer; // координата элемента при пересечении левой границы
    var widthTransfer; // координата элемента при пересечении левой границы + ширина элемента
    var effectId = getEffectIdToTrack(numberTrack);
    if (effectId == undefined) effectId = effect.id;
    for(var i=0; i<effectList[effectId].timeStart.length; i++){
        var item = effectList[effectId].timeStart[i];
        if (item == oldPosX) {
            index = i; continue;
        }
        if ((leftNew + width) >= item && (leftNew + width) <= (item + width)){
            widthTransfer = item - width - 1;
            if (widthTransfer < $('body').offset().left)  transfer = false;
        }else if (leftNew >= item && leftNew <= (item + width)){
            leftTransfer = item + width + 1;
            if (leftTransfer + width > bodyWidth) transfer = false;
        }
        if ((leftNew + width) > bodyWidth) {
            transfer = false;
            if (index != undefined) break;
        }
    }
    if (widthTransfer != undefined && leftTransfer != undefined){
        transfer = false;
    }else if (widthTransfer != undefined){
        leftNew = parseInt(widthTransfer);
    }else if (leftTransfer != undefined){
        leftNew = parseInt(leftTransfer);
    }else{
        leftNew = undefined;
    }
    var crossing = {
        index: index,// индекс массива время старта перенносимого элемента
        transfer: transfer, // флаг разрешения перенесения элемента
        leftNew: leftNew, // новое значение left иначе undefined
        effectId: effectId
    };
    return crossing;
}

// удалить дорожку эффекта
function deleteTrack(effectId) {
    $('.show-track-effect-' + effectId).remove();
    if (countTrack > 0) countTrack--;
}

// изменить цвет элементов дорожки
function changeColorTrack() {
    var children = $('.show-track-effect-' + effect.id + ' label');
    for (var i=1; i< children.length; i++){
        $(children[i]).css('color', effect.colorText).css('background-color', effect.colorBackground);
    }
}


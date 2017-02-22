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
            $('#led-display').append('<div id="circle-"'+ count +' class="circle" onclick="circleClick('+count+')"></div>');
            count++;
        }
        $('#led-display').append('<div class="circle-right-block"></div>');
    }
}

function createCircle32() {
    $('#led-display').append('<div class="circle"></div>');
}

function circleClick(id) {
    console.log(id);
}
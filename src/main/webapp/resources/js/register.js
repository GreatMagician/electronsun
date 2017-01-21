$(document).ready(function() {
    $('#repPass').change(function() {
        var pass = $("#pass").val();
        var pass_rep = $("#repPass").val();

        if (pass != pass_rep) {
            borderRed('#repPass');
            textColor("#errorPass");
            message('Пароли не совпадают');
        }else if (pass == pass_rep && pass.length >=5 && pass.length <= 200){
            borderGreen('#repPass');
        }
    });

    $('#nick').change(function() {
        var nick = $("#nick").val();
        if (nick.length < 3 || nick.length > 50) {
            borderRed('#nick');
            textColor('#errorNick');
            message('Ник должен быть от 3 до 50 символов');
        }else {
            borderGreen('#nick');
        }
    });
    $('#name').change(function() {
        var name = $("#name").val();
        if (name.length < 3 || name.length > 50) {
            borderRed('#name');
            textColor('#errorName');
            message('Имя должно быть от 3 до 50 символов');
        }else {
            borderGreen('#name');
        }
    });
    $('#lastName').change(function() {
        var lastName = $("#lastName").val();
        if (lastName.length < 3 || lastName.length > 50) {
            borderRed('#lastName');
            textColor('#errorLastName');
            message('Фамилия должна быть от 3 до 50 символов');
        }else {
            borderGreen('#lastName');
        }
    });
    $('#pass').change(function() {
        var pass = $("#pass").val();
        if (pass.length < 5 || pass.length > 200) {
            borderRed('#pass');
            textColor('#errorPassword');
            message('Пароль должн быть от 5 до 200 символов');
        }else {
            borderGreen('#pass');
        }
    });
});

function checkParams() { // проверка заполненности формы
    var nick = $('#nick').val();
    var pass = $('#pass').val();
    var repPass = $('#repPass').val();

    if( nick.length != 0 && pass.length != 0 && pass == repPass && pass.length >=5 && pass.length <= 200) {
        $('#submit').removeAttr('disabled');
    } else {
        $('#submit').attr('disabled', 'disabled');
    }
}
function borderRed(id) {
    $(id).css('border', 'red 1px solid');
}
function borderGreen(id) {
    $(id).css('border', '#6ae295 1px solid');
}
function textColor(color) {
    $(color).css('color', 'red');
}
function message(message) {
    //$(id).html(message);
    noty({
        text: message,
        type: 'error',
        layout: 'centerRight',
        timeout: 10000
    });
}

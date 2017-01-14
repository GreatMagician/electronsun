$(document).ready(function() {
    $('#repPass').keyup(function() {
        var pass = $("#pass").val();
        var pass_rep = $("#repPass").val();

        if (pass != pass_rep) {
            borderRed('#repPass');
            textColor("#errorPass");
            message('#errorPass', 'Пароли не совпадают');
        }else if (pass == pass_rep && pass.length >=5 && pass.length <= 200){
            borderGreen('#repPass');
            message('#errorPass','');
        }
    });

    $('#nick').change(function() {
        var nick = $("#nick").val();
        if (nick.length < 3 || nick.length > 50) {
            borderRed('#nick');
            textColor('#errorNick');
            message('#errorNick', 'Ник должен быть от 3 до 50 символов');
        }else {
            borderGreen('#nick');
            message('#errorNick','');
        }
    });
    $('#name').change(function() {
        var name = $("#name").val();
        if (name.length < 3 || name.length > 50) {
            borderRed('#name');
            textColor('#errorName');
            message('#errorName', 'Имя должно быть от 3 до 50 символов');
        }else {
            borderGreen('#name');
            message('#errorName','');
        }
    });
    $('#lastName').change(function() {
        var lastName = $("#lastName").val();
        if (lastName.length < 3 || lastName.length > 50) {
            borderRed('#lastName');
            textColor('#errorLastName');
            message('#errorLastName', 'Имя должно быть от 3 до 50 символов');
        }else {
            borderGreen('#lastName');
            message('#errorLastName','');
        }
    });
    $('#pass').change(function() {
        var pass = $("#pass").val();
        if (pass.length < 5 || pass.length > 200) {
            borderRed('#pass');
            textColor('#errorPassword');
            message('#errorPassword', 'Пароль должн быть от 5 до 200 символов');
        }else {
            borderGreen('#pass');
            message('#errorPassword','');
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
function message(id, message) {
    $(id).html(message);
}

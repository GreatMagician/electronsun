$(document).ready(function() {
    $(document).on("contextmenu", false);
    // удалить контекстное меню при нажатии esc
    window.onkeyup = function(e) {
        if ( e.keyCode === 27 ) {
            $('.context-menu').remove();
        }
    };

    // Вешаем слушатель события нажатие кнопок мыши для всего документа:
    $(document).mousedown(function(event) {
        // Получаем элемент на котором был совершен клик:
        var target = $(event.target);
        //console.log(target);
        if (target["0"].offsetParent.className != "context-menu" ){
            // Удаляем предыдущие вызванное контекстное меню:
            $('.context-menu').remove();
        }
        // Убираем css класс selected-html-element у абсолютно всех элементов на странице с помощью селектора "*":
        $('*').removeClass('selected-html-element');

        // Проверяем нажата ли именно правая кнопка мыши:
        if (event.which === 3)  {
            if (target[0].id == 'nameEffectLabel') {
                // Добавляем класс selected-html-element что бы наглядно показать на чем именно мы кликнули (исключительно для тестирования):
                target.addClass('selected-html-element');

                // Создаем меню:
                $('<div/>', {
                    class: 'context-menu' // Присваиваем блоку наш css класс контекстного меню:
                })
                    .css({
                        left: event.pageX + 'px', // Задаем позицию меню на X
                        top: event.pageY + 'px' // Задаем позицию меню по Y
                    })
                    .appendTo('body') // Присоединяем наше меню к body документа:
                    .append( // Добавляем пункты меню:
                        $('<ul/>')
                            .append('<li><a href="#" onclick="renameEffect()">Переименовать эффект</a></li>')
                            .append('<li><a href="#" onclick="deleteEffect()">Удалить эффект</a></li>')
                    )
                    .show('fast'); // Показываем меню с небольшим стандартным эффектом jQuery. Как раз очень хорошо подходит для меню
            }
        }

    });
});

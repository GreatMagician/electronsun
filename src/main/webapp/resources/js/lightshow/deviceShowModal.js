var deviceTable;

$(document).ready(function () {
    $('#deviceLightShowModal').on($.modal.BEFORE_OPEN, function(event, modal) {
        if (deviceTable == undefined){
            createTable();
        }
    });
});


function createTable() {
    $.ajax({
        url: '/electronsun/device/loaduserdevices',
        dataType: "json",
        type: "POST",
        success: function (json) {
            deviceTable = $('#datatabledevices').DataTable({
                data: json,
                columns: [
                    {
                        "data": "product",
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                return data.name;
                            }
                            return data;
                        }
                    },
                    {
                        "data": "description",
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                return '<input  type="text"  value="' + data + '"' + ' onchange="onchangeDescription($(this),' + row.id  + ');"/>';
                            }
                            return data;
                        }
                    },

                    {
                        "data": "uuid",
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                return data == null ? 'нет' : 'зарегистрирован'
                            }
                            return data;
                        }
                    },

                    {
                        "orderable": false,
                        "defaultContent": "",
                        "render": renderDeleteBtn
                    }

                ],
                "order": [
                    [
                        0,
                        "asc"
                    ]
                ],
                "createdRow": function (row, data, dataIndex) {

                },
                language: {
                    "processing": "Подождите...",
                    "search": "Поиск:",
                    "lengthMenu": "Показать _MENU_ записей",
                    "info": "Записи с _START_ до _END_ из _TOTAL_ записей",
                    "infoEmpty": "Записи с 0 до 0 из 0 записей",
                    "infoFiltered": "(отфильтровано из _MAX_ записей)",
                    "infoPostFix": "",
                    "loadingRecords": "Загрузка записей...",
                    "zeroRecords": "Записи отсутствуют.",
                    "emptyTable": "В таблице отсутствуют данные",
                    "paginate": {
                        "first": "Первая",
                        "previous": "Предыдущая",
                        "next": "Следующая",
                        "last": "Последняя"
                    }
                }
            });
        }
    });
}


function renderDeleteBtn(data, type, row) {
    if (type == 'display') {
        return '<input type="submit" class="modal-btn-del" id="btnDelete-' + row.id + '" value="Удалить" onclick="deleteRow(' + row.id + ');"> ';
    }
}

function deleteRow(id) {
    noty({
        text: 'Удалить прибор?',
        modal: true,
        type: 'alert',
        layout: 'center',
        buttons: [
            {addClass: 'btn btn-primary', text: 'Да', onClick: function($noty) {
                $noty.close();
                $.ajax({
                    url: '/electronsun/device/deletedevice',
                    type: 'POST',
                    data: {
                        id: id
                    }
                }).done(function (json) {
                    // $('#btnDelete-' + id).closest('tr').remove();
                    deviceTable.row( $('#btnDelete-' + id).parents('tr') ).remove().draw();
                    sussesMessageBottom('Данные удалены');
                }).fail(function (xhr, status, errorThrown) {
                    errorMessageBottom('Ошибка при удалении данных');
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


function addDevice() {
    var productId = $('#add-select').val();
    var usernik = $('#user').val();
    if (productId == null || usernik == '') {
        warningMessageBotton('Данные не заполнены');
        return;
    }
    $.ajax({
        url: '/electronsun/device/adddevice',
        type: 'POST',
        data: {
            productId: productId
        }
    }).done(function (json) {
        if (json == ""){
            errorMessageBottom('У вас уже есть незарегистрированный прибор такого типа');
        }else{
            deviceTable = deviceTable.row.add(json).draw();
            sussesMessageBottom('Прибор добавлен');
        }
    }).fail(function (xhr, status, errorThrown) {
        errorMessageBottom('Ошибка при добавлении данных');
        errorConsole(xhr, status, errorThrown);
    });

}

function onchangeDescription(inpt, id) {
    var description = $(inpt).val();
    $.ajax({
        url: '/electronsun/device/updatedevice',
        type: 'POST',
        data: {
            id: id,
            description: description
        }
    }).done(function( json ) {
        sussesMessageBottom('Данные сохранены');
    }).fail(function( xhr, status, errorThrown ) {
        errorMessageBottom('Ошибка при сохранении данных');
        errorConsole(xhr, status, errorThrown);
    });

}
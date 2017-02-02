var deviceTable;

$(document).ready(function () {
    createTable();

});


function createTable() {
    $.ajax({
        url: '/electronsun/admin/loaddevices',
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
                    {data: 'maxLed'},
                    {data: 'enabled'},
                    {
                        "data": "user",
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                return data.name;
                            }
                            return data;
                        }
                    },
                    {
                        "data": "uuid",
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                if (data == null){
                                    return '<div id="div-' + row.id +'"'   + '> <input  type="submit"  value="Сгенерировать" onclick="uuidGenerated(' + row.id  + ');"/> </div>';
                                }
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

function uuidGenerated(id) {
    $.ajax({
        url: '/electronsun/admin/uuidgenerate',
        type: 'POST',
        data: {
            id: id
        }
    }).done(function( text) {
        $('#div-' + id).html(text);
        sussesMessageBottom('Сгенерировано');
    }).fail(function( xhr, status, errorThrown ) {
        errorMessageBottom('Не удалось сгенерировать');
        errorConsole(xhr, status, errorThrown);
    });

}

function renderDeleteBtn(data, type, row) {
    if (type == 'display') {
        return '<input type="submit" id="btnDelete-' + row.id + '" value="Удалить" onclick="deleteRow(' + row.id + ');"> ';
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
                    url: '/electronsun/admin/deletedevice',
                    type: 'POST',
                    data: {
                        id: id
                    }
                }).done(function (json) {
                    $('#btnDelete-' + id).closest('tr').remove();
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

function addselect() {
    var option = $('#option-0').val();
    if (option != undefined) return;
    $.ajax({
        url: '/electronsun/admin/loadproducts',
        type: 'POST'
    }).done(function (json) {
        var i;
        var product;
        for (i=0; i<json.length; i++){
            product = json[i];
            $('#add-select').append('<option id="option-' + i + '" value="' + product.id  + '">' + product.name  + '</option>');
        }
    }).fail(function (xhr, status, errorThrown) {
        errorConsole(xhr, status, errorThrown);
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
        url: '/electronsun/admin/adddevice',
        type: 'POST',
        data: {
            productId: productId,
            usernik: usernik
        }
    }).done(function (json) {
        deviceTable.row.add(json).draw();
        sussesMessageBottom('Прибор добавлен');
    }).fail(function (xhr, status, errorThrown) {
        errorMessageBottom('Ошибка при добавлении данных');
        errorConsole(xhr, status, errorThrown);
    });

}
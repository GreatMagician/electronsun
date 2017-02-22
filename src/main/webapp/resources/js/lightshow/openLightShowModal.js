var lightShowTable;

$(document).ready(function () {
    $('#openLightShowModal').on($.modal.BEFORE_OPEN, function(event, modal) {
        if (lightShowTable == undefined){
            createTableLightShow();
        }
    });
});


function createTableLightShow() {
    $.ajax({
        url: '/electronsun/lightshow/loaduserlightshow',
        dataType: "json",
        type: "POST",
        success: function (json) {
            lightShowTable = $('#datatablelightshow').DataTable({
                data: json,
                columns: [
                    {
                        "data": "name",
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                return '<label ondblclick="tableslightShowNamedblClick(' + row.id + ')">' + data + '</label>';
                            }
                            return data;
                        }
                    },
                    {
                        "orderable": false,
                        "defaultContent": "", //devices
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                return '<select class="select-option" id="select-devises-"'+ row.id +' onclick="tableslightShowselectdevisesClick('+ row.id +')">'
                            }
                            return data;
                        }
                    },
                    {
                        "data": "lightShowRemixId",
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                return (data > 0) ? 'ремикс' : '';
                            }
                            return data;
                        }
                    },
                    {
                        "orderable": false,
                        "defaultContent": "", //Задействовано в ремиксах
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                return '<select class="select-option" id="select-remix-"'+ row.id +' onclick="tablesLightShowSelectRemixClick('+ row.id +')">';
                            }
                            return data;
                        }
                    },
                    {
                        "data": "audio",
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                return (data == null) ? '' : data.name;
                            }
                            return data;
                        }
                    },
                    {
                        "data": "publicShow",
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                return '<input  type="checkbox"  ' + 'id="checkbox-' + row.id +'"'   + (data ? 'checked' : '') + ' onclick="publicShowClick($(this),' + row.id + ');"/>';
                            }
                            return data;
                        }
                    },
                    {
                        "orderable": false,
                        "defaultContent": "",
                        "render": renderDeleteBtnLightShow
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


function renderDeleteBtnLightShow(data, type, row) {
    if (type == 'display') {
        return '<input type="submit" class="modal-btn-del" id="btnDeleteShow-' + row.id + '" value="Удалить" onclick="deleteRowLightShow(' + row.id + ');"> ';
    }
}

function deleteRowLightShow(id) {
    noty({
        text: 'Удалить световое шоу?',
        modal: true,
        type: 'alert',
        layout: 'center',
        buttons: [
            {addClass: 'btn btn-primary', text: 'Да', onClick: function($noty) {
                $noty.close();
                $.ajax({
                    url: '/electronsun/lightshow/deletelightshow',
                    type: 'POST',
                    dataType: 'JSON',
                    data: {
                        id: id
                    }
                }).done(function (json) {
                    if (json == true){
                        lightShowTable.row( $('#btnDeleteShow-' + id).parents('tr') ).remove().draw();
                        sussesMessageBottom('Данные удалены');
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



function tableslightShowNamedblClick(id) {
    $.ajax({
        url: '/electronsun/lightshow/choicelightshow',
        dataType: "json",
        type: "POST",
        data: {
                id: id
        },
        success: function (json) {
            lightShow = json;
            body_right_value();
            $.modal.close();
        },
        error: function (xhr, status, errorThrown) {
            errorMessageBottom('Ошибка при загрузке данных');
            errorConsole(xhr, status, errorThrown);
        }
    });

}

function tableslightShowselectdevisesClick(id) {

}

function tablesLightShowSelectRemixClick(id) {

}

function publicShowClick(chkbx, id) {

}
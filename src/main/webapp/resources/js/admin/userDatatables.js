var userTable;

$(document).ready(function () {
    createTable();

    // событие клик datatables
    $('#datatableusers').on( 'click', 'tr', function () {
        var dat = userTable.row( this ).data();
        var check = $('#' + dat.id);
        var enabled = check.is(":checked");
        if (enabled != dat.enabled){
            dat.enabled = enabled;
            userTable
                .row( this )
                .data(dat)
                .draw();
        }
        $(this).css("opacity", enabled ? 1 : 0.5);
    });

});

// формат даты date.format.js
Date.prototype.format = function (mask, utc) {
    return dateFormat(this, mask, utc);
};

var filterclick;
function filterTable(filter) {
    filterclick = filter;
    if (filter == undefined){
        $('#radio-desable').prop( "checked", false );
        $('#radio-deleted').prop( "checked", false );
    }else if (filter == 'desable'){
        $('#radio-not').prop( "checked", false );
        $('#radio-deleted').prop( "checked", false );
    }else if (filter == 'deleted'){
        $('#radio-not').prop( "checked", false );
        $('#radio-desable').prop( "checked", false );
    }
    userTable.draw();
}

// фильтрация данных в datatables
$.fn.dataTable.ext.search.push(
    function( settings, data, dataIndex ) {
        if (filterclick != 'deleted' && data[7] == 'true') {
            return false;
        }
        if (filterclick == "desable"){
            if(data[6] == 'true') {
                return false;
            }
        }
        if (filterclick == "deleted"){
            if(data[7] == 'false') {
                return false;
            }
        }
        return true;
    }
);


function createTable() {
    $.ajax({
        url: '/electronsun/admin/loadusers',
        dataType: "json",
        type: "POST",
        success: function (json) {
            userTable = $('#datatableusers').DataTable({
                data: json,
                columns: [
                    {data: 'name'},
                    {data: 'email'},
                    {data: 'roles'},
                    {
                        "data": "registered",
                        "render": function (date) {
                            var dat = new Date(date);
                            return dat.format("dd-mm-yyyy HH:MM:ss");
                        }
                    },
                    {data: 'firstName'},
                    {data: 'lastName'},
                    {
                        "data": "enabled",
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                return '<input  type="checkbox"  ' + 'id="' + row.id +'"'   + (data ? 'checked' : '') + ' onclick="enableClick($(this),' + row.id + ');"/>';
                            }
                            return data;
                        }
                    },
                    {
                        "data": "deleted",
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                if (data == true) {
                                    return 'удалён';
                                }
                                return "";
                            }
                            return data;
                        }
                    }
                ],
                "order": [
                    [
                        0,
                        "asc"
                    ]
                ],
                "createdRow": function (row, data, dataIndex) {
                    if (!data.enabled) {
                        $(row).css("opacity", 0.5);
                    }
                    if (data.deleted){
                        $(row).css("color", "red");
                    }
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

function enableClick(chkbox, id) {
    var enabled = chkbox.is(":checked");
    $.ajax({
        url: '/electronsun/admin/enableuser',
        type: 'POST',
        data: {
            id: id,
            enabled: enabled
        },
        success: function () {
            if (enabled){
                sussesMessageBottom('пользователь активирован');
            }else{
                sussesMessageBottom('заблокирован');
            }
        }
    });
}


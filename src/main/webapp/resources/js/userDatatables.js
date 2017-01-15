$(document).ready(function () {
    $.ajax({
        url: '/electronsun/admin/loadusers',
        dataType: "json",
        type: "POST",
        success: function (json) {
            $('#datatableusers').DataTable({
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

                                return '<input type="checkbox" ' + (data ? 'checked' : '') + ' onclick="enableClick($(this),' + row.id + ');"/>';
                            }
                            return data;
                        }
                    }
                ],
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
});

Date.prototype.format = function (mask, utc) {
    return dateFormat(this, mask, utc);
};

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
            chkbox.closest('tr').fadeTo(300, enabled ? 1 : 0.3);
            if (enabled){
                noty({
                    text: 'пользователь активирован',
                    type: 'success',
                    layout: 'bottomRight',
                    timeout: 3000
                });
            }else{
                noty({
                    text: 'пользователь деактивирован',
                    type: 'success',
                    layout: 'bottomRight',
                    timeout: 3000
                });
            }
        }
    });
}

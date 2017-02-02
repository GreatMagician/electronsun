var productTable;
var product;
$(document).ready(function () {
    createTable();

});


    function createTable() {
    $.ajax({
        url: '/electronsun/admin/loadproducts',
        dataType: "json",
        type: "POST",
        success: function (json) {
            productTable = $('#datatableproducts').DataTable({
                data: json,
                columns: [
                    {
                        "data": "name",
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                product = row;
                                return '<input  type="text" data-column="name" value="' + data + '"' + ' onchange="changeInput($(this),' + row.id  + ');"/>';
                            }
                            return data;
                        }
                    },
                    {
                        "data": "description",
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                return '<input  type="text" data-column="name" value="' + data + '"' + ' onchange="changeInput($(this),' + row.id  + ');"/>';
                            }
                            return data;
                        }
                    },
                    {
                        "data": "price",
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                return '<input  type="text"  value="' + data + '"' + ' onchange="changeinput($(this),' + row.id  + ');"/>';
                            }
                            return data;
                        }
                    },
                    {
                        "data": "discount",
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                return '<input  type="text"  value="' + data + '"' + ' onchange="changeinput($(this),' + row.id  + ');"/>';
                            }
                            return data;
                        }
                    },
                    {data: 'discountPrice'},
                    {
                        "data": "maxLed",
                        "render": function (data, type, row) {
                            if (type == 'display') {
                                return '<input  type="text"  value="' + data + '"' + ' onchange="changeinput($(this),' + row.id  + ');"/>';
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

function changeInput(inpt, id) {
    var value = $(inpt).val();
    var column = inpt.data('column');
    $.ajax({
        url: '/electronsun/admin/updateproduct',
        type: 'POST',
        data: {
            id: id,
            column: column,
            value: value
        }
    }).done(function( json ) {
        sussesMessageBottom('Данные сохранены');
    }).fail(function( xhr, status, errorThrown ) {
        errorMessageBottom('Ошибка при сохранении данных');
        errorConsole(xhr, status, errorThrown);
    });

}

function renderDeleteBtn(data, type, row) {
    if (type == 'display') {
        return '<input type="submit" id="btnDelete-' + row.id + '" value="Удалить" onclick="deleteRow(' + row.id + ');"> ';
    }
}

function deleteRow(id) {
    $.ajax({
        url: '/electronsun/admin/deleteproduct',
        type: 'POST',
        data: {
            id: id
        }
    }).done(function( json) {
        $('#btnDelete-' + id).closest('tr').remove();
        sussesMessageBottom('Данные удалены');
    }).fail(function( xhr, status, errorThrown ) {
        errorMessageBottom('Ошибка при удалении данных');
        errorConsole(xhr, status, errorThrown);
    });
}

function addProductClick() {
    var name = $('#name').val();
    var description = $('#description').val();
    var price = $('#price').val();
    var discount = $('#discount').val();
    var maxLed = $('#maxLed').val();
    $.ajax({
        url: '/electronsun/admin/addproduct',
        type: 'POST',
        data: {
            name: name,
            description: description,
            price: price,
            discount: discount,
            maxLed: maxLed
        }
    }).done(function( json ) {
        productTable.row.add(json).draw();
        sussesMessageBottom('Продукт добавлен');
    }).fail(function( xhr, status, errorThrown ) {
        errorMessageBottom('Ошибка при добавлении продукта');
        errorConsole(xhr, status, errorThrown);
    });

}
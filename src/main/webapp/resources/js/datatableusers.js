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
                    {data: 'registered'},
                    {data: 'firstName'},
                    {data: 'lastName'},
                    {data: 'enabled'}
                ]
            });
        }
    });
});
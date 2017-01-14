$(document).ready(function () {
    $.ajax({
        url: '/electronsun/admin/loadusers',
        dataType: "json",
        type: "POST",
        success: function (json) {
            $('#datatableusers').DataTable({
                data: json,
                type: "POST",
                columns: [
                    {data: 'nick'},
                    {data: 'email'},
                    {data: 'roles'},
                    {data: 'registered'},
                    {data: 'firstName'},
                    {data: 'lastName'},
                    {data: 'active'}
                ],
            });
        }
    });
});
<div class="row">
    <script>
        $.getJSON(baseUrl+'venues/', function (data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                var tr = $('<tr/>');
                //tr.append("<td>" + data[i]["id"] + "</td>");
                tr.append("<td>" + data[i]["name"] + "</td>");
                tr.append("<td>" + data[i]["capacity"] +"</td>");
                tr.append("<td>" + data[i]["status"] +"</td>");
                tr.append("<td>" + data[i]["dateAdded"]['date']['year'] + " / " + data[i]["dateAdded"]['date']['month'] + " / " + data[i]["dateAdded"]['date']['day'] + "</td>");
//                $('#venuesTable').append(tr);
                $('#example1').append(tr);
            }
        });
    </script>
</div>
<div class="col-xs-12">
    <div class="box-body">
        <h2>Venues</h2>
        <%--<table id="venuesTable" class="display" width="100%" cellspacing="0">--%>
        <table id="example1" class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>Capacity</th>
                <th>Status</th>
                <th>Date Added</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <tr>
            </tr>
            </tbody>
            <tfoot>
            <tr>
            </tr>
            </tfoot>
        </table>
    </div>
</div>
<script>
    /*$(document).ready(function() {
     var table = $('#venuesTable').DataTable();
     $('#venuesTable tbody').on('click', 'tr', function () {
     var data = table.row( this ).data();
     alert( 'You clicked on '+data[0]+'\'s row' );
     } );
     } );*/
</script>


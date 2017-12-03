<div class="row">
    <script>
        $.getJSON(baseUrl+'events/', function (data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                var tr = $('<tr/>');
                //tr.append("<td>" + data[i]["id"] + "</td>");
                tr.append("<td>" + data[i]["name"] + "</td>");
                tr.append("<td>" + data[i]["status"] +"</td>");
                tr.append("<td>" + data[i]["description"] + "</td>");
                tr.append("<td>" + data[i]["maxAttendance"] + "</td>");
                tr.append("<td>" + data[i]["dateAdded"]['date']['year'] + " / " + data[i]["dateAdded"]['date']['month'] + " / " + data[i]["dateAdded"]['date']['day'] + "</td>");
                $('#example1').append(tr);
            }
        });
    </script>
</div>
<div class="col-xs-12">
    <div class="box-body">
        <h2>Events</h2>
        <table id="example1" class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>Status</th>
                <th>Description</th>
                <th>Max Capacity</th>
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


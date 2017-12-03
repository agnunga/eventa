<div class="row">
    <script>
        $.getJSON(baseUrl+'locations/', function (data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                var tr = $('<tr/>');
                //tr.append("<td>" + data[i]["id"] + "</td>");
                tr.append("<td>" + data[i]["name"] +"</td>");
                tr.append("<td>" + data[i]["description"] + "</td>");
                tr.append("<td>" + data[i]["longitude"] + "</td>");
                tr.append("<td>" + data[i]["latitude"] + "</td>");
                tr.append("<td>" + data[i]["dateAdded"]['year'] + " / " + data[i]["dateAdded"]['month'] + " / " + data[i]["dateAdded"]['day'] + "</td>");
                $('#example1').append(tr);
            }
        });
    </script>
</div>
<div class="col-xs-12">
    <div class="box-body">
        <h2>Locations</h2>
        <table id="example1" class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Longitude</th>
                <th>Latitude</th>
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

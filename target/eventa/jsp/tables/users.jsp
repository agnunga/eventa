<div class="row">
    <script>
        $.getJSON(baseUrl+'users/', function (data) {
            console.log(baseUrl+"users/ "+"Here is the data : " + data);
            for (var i = 0; i < data.length; i++) {
                var tr = $('<tr/>');
                //tr.append("<td>" + data[i]["id"] + "</td>");
                tr.append("<td>" + data[i]["firstName"] +" "+ data[i]["lastName"] + "</td>");
                tr.append("<td>" + data[i]["phone"] +" - "+ data[i]["email"]+ "</td>");
                tr.append("<td>" + data[i]["gender"] + "</td>");
                //tr.append("<td>" + data[i]["password"] + "</td>");
                $('#example1').append(tr);
            }
        });
        //        });
    </script>
</div>
<div class="col-xs-12">
    <div class="box-body">
        <h2>Users</h2>
        <table id="example1" class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>Contact(s)</th>
                <th>Gender</th>
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


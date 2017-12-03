<div class="row">
    <script>
        $.getJSON(baseUrl+'tickets/', function (data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                var tr = $('<tr/>');
                //tr.append("<td>" + data[i]["id"] + "</td>");
                tr.append("<td>" + data[i]["price"] + "</td>");
                tr.append("<td>" + data[i]["ticketStatus"] +"</td>");
                $('#example1').append(tr);
            }
        });
    </script>
</div>
<div class="col-xs-12">
    <div class="box-body">
        <h2>Tickets</h2>
        <table id="example1" class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Price</th>
                <th>Status</th>
                <th>Date Booked</th>
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


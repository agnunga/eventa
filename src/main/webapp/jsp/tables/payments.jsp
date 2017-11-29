<div class="row">
    <script>
        $.getJSON(baseUrl+'payments/', function (data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                var tr = $('<tr/>');
                //tr.append("<td>" + data[i]["id"] + "</td>");
                tr.append("<td>" + data[i]["amount"] + "</td>");
                tr.append("<td>" + data[i]["paymentCode"] +"</td>");
                tr.append("<td>" + data[i]["paymentMode"] + "</td>");
                tr.append("<td>" + data[i]["status"] + "</td>");
                $('#example1').append(tr);
            }
        });
    </script>
</div>
<div class="col-xs-12">
    <div class="box-body">
        <h2>Payments</h2>
        <table id="example1" class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Amount</th>
                <th>Code</th>
                <th>Mode</th>
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


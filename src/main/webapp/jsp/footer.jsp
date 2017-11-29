<%-- Footer --%>
<footer>
    <p>&copy; Company 2017</p>
    <a href="./logout">Logout</a>
</footer>
</div>

<script src="<c:url value="/assets/scripts/jsUtil.js" />"></script>
<!-- DataTables -->
<script src="/assets/datatables/dataTables.bootstrap.min.js"></script>
<script src="<c:url value="/assets/datatables/jquery.dataTables.min.js" />"></script>
<script src="<c:url value="/assets/scripts/validator.min.js" />"></script>
<!-- page script -->
<script>
    $(function () {
        var table =  $("#example1").DataTable({
            "paging": true,
            "lengthChange": true,
            "searching": true,
            "ordering": true,
            "info": true,
            "autoWidth": false
        });
        $("#example1 tbody").on("click", "tr", function () {
            var data = table.row( this ).data();
            alert( "You clicked on "+data[0]+"\"s row" );
        } );
    });
</script>
</body>
</html>

<footer>
    <p>&copy; Company 2017</p>
    <a href="./logout">Logout</a>
</footer>
</div>
</div>

<script src="${pageContext.request.contextPath}/assets/js/index.js"></script>
<!-- DataTables -->
<%--<script src="${pageContext.request.contextPath}/assets/datatables/dataTables.bootstrap.min.js"></script>--%>
<script src="${pageContext.request.contextPath}/assets/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/scripts/jsUtil.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/validator.min.js"></script>
<!-- page script -->
<script>
    $(function () {
        var table =  $('#example1').DataTable({
            "paging": true,
            "lengthChange": true,
            "searching": true,
            "ordering": true,
            "info": true,
            "autoWidth": false
        });
        $('#example1 tbody').on('click', 'tr', function () {
            var data = table.row( this ).data();
            alert( 'You clicked on '+data[0]+'\'s row' );
        } );
    });
</script>
</body>
</html>

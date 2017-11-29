<div id="result"></div>
<form id="add_ticket" role="form" data-toggle="validator" action="tickets/add" method="post" class="well form-horizontal">
    <fieldset>
        <legend style="text-align: center;">Ticket</legend>
        <div class="form-group">
            <label class="control-label col-sm-3">Event : </label>
            <div class="col-sm-9">
                <input type="text" name="event" id="event" class="form-control" autofocus/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">Ticket Type: </label>
            <div class="col-sm-9">
                <input type="text" name="type" id="type" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">Amount : </label>
            <div class="col-sm-9">
                <input type="text" name="amount"  id="amount" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3"></label>
            <div class="col-sm-9">
                <input type="submit"value="Add"class="btn pull-right"/>
            </div>
        </div>
    </fieldset>
</form>
<script>
    sendAjaxReq("#add_ticket")
</script>
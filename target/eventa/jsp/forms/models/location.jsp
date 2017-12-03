<div id="result"></div>
<form id="add_location" role="form" data-toggle="validator" action="locations/add" method="post" class="well form-horizontal">
    <fieldset>
        <legend style="text-align: center;">Add Location</legend>
        <div class="form-group">
            <label class="control-label col-sm-3">Name : </label>
            <div class="col-sm-9">
                <input type="text" name="name" id="name" class="form-control autofocus"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">longitude : </label>
            <div class="col-sm-9">
                <input type="text" name="longitude"  id="longitude" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">Latitude : </label>
            <div class="col-sm-9">
                <input type="text" name="latitude"  id="latitude" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">Description : </label>
            <div class="col-sm-9">
                <input type="text" name="description" id="description" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3"></label>
            <div class="col-sm-9">
                <input type="submit" value="Add" class="btn pull-right"/>
            </div>
        </div>
    </fieldset>
</form>
<script>
    sendAjaxReq("#add_location")
</script>
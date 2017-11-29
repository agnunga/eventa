<div id="result"></div>
<form id="add_audience" role="form" data-toggle="validator" action="auddience/add" method="post" class="well form-horizontal">
    <fieldset>
        <legend style="text-align: center;">Audience</legend>
        <div class="form-group">
            <label class="control-label col-sm-3">Name: </label>
            <div class="col-sm-9">
                <input type="text" name="name" class="form-control" autofocus/>
            </div><!-- End of col-sm-9 -->
        </div><!-- End of form group -->
        <div class="form-group">
            <label class="control-label col-sm-3">Biography </label>
            <div class="col-sm-9">
                <input type="text" name="bio" class="form-control"/>
            </div><!-- End of col-sm-9 -->
        </div><!-- End of form group -->
        <div class="form-group">
            <label class="control-label col-sm-3">Date Of Birth </label>
            <div class="col-sm-9">
                <input type="text" name="dob" class="form-control"/>
            </div><!-- End of col-sm-9 -->
        </div><!-- End of form group -->
        <div class="form-group">
            <label class="control-label col-sm-3"></label>
            <div class="col-sm-9">
                <input type="submit"value="Add Author"class="btn pull-right"style="background-color: #1b6d85;color: white;"/>
            </div><!-- End of col-sm-9 -->
        </div><!-- End of form group -->
    </fieldset>
</form>
<script>
    sendAjaxReq("#add_audience")
</script>
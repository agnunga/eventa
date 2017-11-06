<div id="result"></div>
<form id="add_user" role="form" data-toggle="validator" action="users/add" method="post" class="well form-horizontal">
    <fieldset>
        <legend style="text-align: center;">Register</legend>
        <div class="form-group">
            <label class="control-label col-sm-3">First Name : </label>
            <div class="col-sm-9">
                <input type="text" name="firstName" id="firstName" class="form-control" autofocus/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">Last Name : </label>
            <div class="col-sm-9">
                <input type="text" name="lastName" id="lastName" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">Phone : </label>
            <div class="col-sm-9">
                <input type="text" name="phone"  id="phone" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">Email : </label>
            <div class="col-sm-9">
                <input type="text" name="email"  id="email" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">Gender : </label>
            <div class="col-sm-9">
                <label class="radio-inline"><input type="radio" name="gender" value="MALE">Male</label>
                <label class="radio-inline"><input type="radio" name="gender" value="FEMALE">Female</label>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">Password : </label>
            <div class="col-sm-9">
                <input name="password" placeholder="" class="form-control" type="password" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3"></label>
            <div class="col-sm-9">
                <input type="submit"value=".:Register:."class="btn pull-right"/>
            </div>
        </div>
    </fieldset>
</form>
<script>
    sendAjaxReq("#add_user")
</script>
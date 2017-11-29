<div id="result"></div>
<form id="add_event" role="form" data-toggle="validator" action="events/add" method="post" class="form-horizontal">
    <fieldset>
        <legend style="text-align: center;">Add Event</legend>
        <div class="form-group">
            <label class="control-label col-sm-3">Name : </label>
            <div class="col-sm-9">
                <input type="text" name="name" id="name" class="form-control" autofocus/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">Max Attendance : </label>
            <div class="col-sm-9">
                <input type="text" name="maxAttendance"  id="maxAttendance" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">Description : </label>
            <div class="col-sm-9">
                <textarea type="text" name="description" id="description" class="form-control">
                </textarea>
            </div>
        </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">Category : </label>
            <div class="col-sm-9">
                <select id="selectEventCategory" class="form-control" multiple id="dateAdded" name="dateAdded">
                    <option value="COMEDY">Comedy</option>
                    <option value="CONCERT">Concert</option>
                    <option value="CINEMA">Cinema</option>
                    <option value="SEMINAR">Seminar</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">Venue : </label>
            <div class="col-sm-9">
                <select id="selectEventVenue" class="form-control" multiple id="venue" name="venue">
                </select>
                <script>
                    $(function () {
                        var url = baseUrl+'venues/';
                        $.getJSON(url,function(data){
                            console.log(data);
                            for(var i = 0; i< data.length; i++){
                                var option = $('<option value="' + data[i]["id"] + '">' + data[i]["name"] + '</option>');
                                $("#selectEventVenue").append(option);
                            }
                        });
                    });
                </script>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">Event Date : </label>
            <div class="col-sm-9">
                <input type="date" name="date" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3"></label>
            <div class="col-sm-9">
                <input type="submit"value="Add Event"class="btn pull-right"/>
            </div>
        </div>
    </fieldset>
</form>
<script>
    sendAjaxReq("#add_event");
    $(function () {
        $('#selectEventVenue').fastselect();
        $('#selectEventCategory').fastselect();
    });
</script>
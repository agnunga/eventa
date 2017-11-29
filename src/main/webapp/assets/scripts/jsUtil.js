/**
 * Created by agufed on 10/23/17.
 */
$(function () {
    $.validator.setDefaults({
        submitHandler: function() {
            alert("submitted!");
        }
    });
});

function sendAjaxReq(formId) {
    $(formId).validator()

    $(formId).submit(function (e) {
        e.preventDefault(); //STOP default action
        var postData = $(this).serializeArray();
        // alert("Form Data "+post  Data)
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            dataType:'html',
            success: function (data, textStatus, jqXHR) {
                $(':input', formId)
                    .not(':button, :submit, :reset, :hidden')
                    .val('')
                    .removeAttr('checked')
                    .removeAttr('selected');

                $("#result").html(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $("#result").html(errorThrown);
            }
        });
        return false;
    });
}

function loadFileContent(targetId, contentSource) {
    console.log("Load Ajax => "+ targetId + "  " + contentSource);
    $(targetId).html('<img src="assets/images/loading.gif" style="margin: 10% auto auto 48%; vertical-align: middle;">');
    $.ajax({
        url: contentSource
    }).done(function(data) {
        $(targetId).html(data);
    });
}

/*function loadFileContent(targetId, contentSource) {
 console.log("Load => "+ targetId + "  " + contentSource);
 $(targetId).load(contentSource);
 }*/

function loadFileContentOnClick(clickedId, targetId, contentSource) {
    $(clickedId).on("click", function() {
        console.log("2 => "+clickedId + "  " + targetId + "  " + contentSource);
        loadFileContent(targetId, contentSource);
    });
}

function tfAutofill(clickedId, targetId, jsondata) {
    $(targetId).autocomplete({
        lookup: jsondata,    // lookup suggestion from cstates json
        lookupLimit: 2,     //limit suggestion result display
        onSelect: function (suggestion) {
            $('#zipcode').val(suggestion.data);//set zipcode textfield with the data of state clicked
        }
    });
}

function loadSelectOptionsFromJson(targetId, jsonDataUrl) {
    var url = baseUrl+""+jsonDataUrl;
    console.log(url);
    $.getJSON(url,function(data){
        console.log(data);
        for(var i = 0; i< data.length; i++){
            var option = $('<option value="' + data[i]["id"] + '">' + data[i]["name"] + '</option>');
            $(targetId).append(option);
        }
    });
}



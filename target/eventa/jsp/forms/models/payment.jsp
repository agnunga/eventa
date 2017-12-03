<div id="result"></div>
<form id="add_payment" role="form" data-toggle="validator" class="well form-horizontal" action="payments/add" method="post" id="contact_form">
    <fieldset>
        <legend style="text-align: center;">Payment</legend>
        <div class="form-group">
            <label class="col-md-4 control-label">Amount </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="amount" placeholder="" class="form-control" type="text" autofocus>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label">Payment Code </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="paymentCode" placeholder="" class="form-control" type="text" autofocus>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label">Payment Mode </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <select class="form-control" name="paymentMode">
                        <option value="MPESA">M-Pesa</option>
                        <option value="PAYPAL">PayPal</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <button type="submit" class="btn btn-info">
                    Verify payment <span class=""></span>
                </button>
            </div>
        </div>
    </fieldset>
</form>
<script>
    sendAjaxReq("#add_payment")
</script>
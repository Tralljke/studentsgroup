 $( document ).on('click','a',function(a) {
//     $( document ).ready(function() {
    // SUBMIT FORM

            ajaxPost();

    function ajaxPost(){
        var customerId = a.target.id;
        var formData = {
             id : a.target.id,
            groupNumber :  $("#th-z").text()

        }

        // DO POST
        $.ajax({
            type : "DELETE",
            contentType : "application/json",
            url : "api/customer/delete/" + customerId,
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(result) {
                if(result.status == "Done"){
                    $('#studentstable tbody').empty();

                    $.each(result.data, function(i, customer){
                        var customer = "<tr><td>" + customer.data + "</td> + <td>" + customer.name + "</td> " +
                            "<td><a id= " + customer.id + "> " + "Delete" + "</a></td></tr> ";
                        $("#studentstable").append(customer)
                    });
                    console.log("Success: ", result);
                }else{
                    $("#postResultDiv").html("<strong>Error</strong>");
                }
                console.log(result);
            },
            error : function(e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });

        // Reset FormData after Posting
        resetData();

    }

    function resetData(){
        customerId = "";
    }
})
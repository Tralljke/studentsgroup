$( document ).ready(function() {

    // SUBMIT FORM
    $("#customerForm").submit(function(event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPost();
    });


    function ajaxPost(){

        // PREPARE FORM DATA
        var formData = {

            name : $("#firstname").val(),
            groupNumber :  $("#th-z").text()

        }

        // DO POST
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "api/customer/save",
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
        $("#firstname").val("");
    }
})
$( document ).ready(function() {


    $("#studentForm").submit(function(event) {
        event.preventDefault();
        ajaxPost();
    });


    function ajaxPost(){

        var formData = {

            name : $("#firstname").val(),
            groupNumber :  $("#th-z").text()

        }

        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "api/person/save",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(result) {
                if(result.status == "Done"){
                    $('#studentstable tbody').empty();

                    $.each(result.data, function(i, student){
                        var student = "<tr><td>" + student.data + "</td> + <td>" + student.name + "</td> " +
                            "<td><a id= " + student.id + "> " + "Delete" + "</a></td></tr> ";
                        $("#studentstable").append(student)
                    });
                    console.log("Success: ", result);
                }
                console.log(result);
            },
            error : function(e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });

        resetData();

    }

    function resetData(){
        $("#firstname").val("");
    }
})
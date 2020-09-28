 $( document ).on('click','a',function(a) {

            ajaxPost();

    function ajaxPost(){
        var personId = a.target.id;
        var formData = {
             id : a.target.id,
            groupNumber :  $("#th-z").text()
        }

        $.ajax({
            type : "DELETE",
            contentType : "application/json",
            url : "api/person/delete/" + personId,
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
        personId = "";
    }
})
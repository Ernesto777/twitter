


$(document).ready(function() {

    $("#registration-form").submit(function( event ) 
    {


        if(document.getElementById("userName").value.length == 0)
        {
            alert("User name is empty");
            return false;
        }

        if(document.getElementById("fullName").value.length == 0)
        {
            alert("Full name is empty");
            return false;
        }

        if(document.getElementById("email").value.length == 0)
        {
            alert("email is empty");
            return false;
        }

        if(document.getElementById("pass").value.length == 0)
        {
            alert("password is empty");
            return false;
        }

        if(document.getElementById("passC").value.length == 0)
        {
            alert("repeat password is empty");
            return false;
        }
        // Don't submit the form normally
        event.preventDefault();
         
         var userNameR = document.getElementById("userName").value;
         var userFullName = document.getElementById("fullName").value;
         var userEmail = document.getElementById("email").value;
         var userPass = document.getElementById("pass").value;
         var passC = document.getElementById("passC").value;


         if( userPass != passC)
         {
         	alert("Password must coincidence");
         	return;
         }



        // Compose the data in the format that the API is expecting
        var data = { userName: userNameR,fullName: userFullName, email: userEmail, pass: userPass};


        // Send the data using post
        $.ajax({
            url: 'http://localhost:8080/register',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: false,
            success: function(result)
            {

      			if(result == 1)
      			{
      			   alert("User registered, Welcome!");
      			}

            },

            error: function(data)
            {
              alert(data.responseText);
            }
        });
    });
});
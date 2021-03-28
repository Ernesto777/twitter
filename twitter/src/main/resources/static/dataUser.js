


$(document).ready(function() {

    $("#registration-form").submit(function( event ) 
    {

        // Don't submit the form normally
        event.preventDefault();

        // Get some values from elements on the page
        /*
        var a = $('.multiplication-a').text();
        var b = $('.multiplication-b').text();
        var $form = $( this ),
            attempt = $form.find( "input[name='result-attempt']" ).val(),
            userAlias = $form.find( "input[name='user-alias']" ).val();

         */
         
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
        //var data = { user: {userName: userNameR,fullName: userFullName, email: userEmail, pass: userPass}};
        var data = { userName: userNameR,fullName: userFullName, email: userEmail, pass: userPass};


        // Send the data using post
        $.ajax({
            url: 'http://localhost:8080/register',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: false,
            success: function(response)
            {

			    if (response != 'error') 
			    {
			        location.href = response;
			    }
			    
      			if(response != "1")
      			{
      				$('.result-message').empty().append(result);
      			}


                if (response.redirectUrl !== undefined) 
                {
                	window.location.replace(response.redirectUrl);
            	} 

            },
            
			    error: function(xhr, status, error) {
			  var error1 = eval("(" + xhr.responseText + ")");
			  console.log(error1.Message);
			  console.log(geturl.getAllResponseHeaders());
			  alert("error!"+ geturl.getAllResponseHeaders());
			}

        });
    });
});
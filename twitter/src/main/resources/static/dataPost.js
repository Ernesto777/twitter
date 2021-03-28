$(document).ready(function() 
{
    $("#post-form").submit(function( event ) 
    {

        // Don't submit the form normally
        event.preventDefault();

        var $form = $( this ),
            textPost = $form.find( "input[name='text-post']" ).val(),
            userN = $form.find( "input[name='userName-post']" ).val();

        // Compose the data in the format that the API is expecting
        var data = { user: { userName: userN}, descriptionPost: textPost};
        

        // Send the data using post
        $.ajax({
            url: 'http://localhost:8080/publications',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: false,
            success: function(data)
            {

                    $('#posts-div').show();
                    $('#post-head').empty();
                    $('#post-body').empty();

                    $('#post-head').append('<tr><th> User name: ' + data.user.userName + '</th></tr>' +
                                           '<tr><th>' + data.descriptionPost + '</th></tr>' +
                                           '<tr><th> Creation date: ' + data.createdAt + '</th></tr>'); 
                
            },
            
              error: function(xhr, status, error) 
              {
                  var error1 = eval("(" + xhr.responseText + ")");
                  console.log(error1.Message);
                  console.log(geturl.getAllResponseHeaders());
                  alert("error!"+ geturl.getAllResponseHeaders());
                }


        });

    });
});




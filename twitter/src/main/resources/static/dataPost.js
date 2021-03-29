function updateSuggestedUsers(userId) 
{
    $.ajax({
            url: "http://localhost:8080/follow?userId=" + userId,
    }).then(function(data) 
    {
        // Cleans the form
        //$("#attempt-form").find( "input[name='result-attempt']" ).val("");
        //$("#attempt-form").find( "input[name='user-alias']" ).val("");
        // Gets a random challenge from API and loads the data in the HTML

        data.forEach(function(row)
        {
            /*$('#results-body').append('<tr><td>' + row.id + '</td>' +
            '<td>' + row.multiplication.factorA + ' x ' + row.multiplication.factorB + '</td>' +
            '<td>' + row.resultAttempt + '</td>' +
            '<td>' + (row.correct === true ? 'YES' : 'NO' + '</td></tr>')); */

            if(row.id == userId)
            {
              return;
            }

            $('#suggest-head').append('<tr><td>' + row.userName + '</td>' + 
                        '<td><input type="button" value="Follow" class="btn btn-default" onclick="followUser('+row.id+');"></td></tr>');
            //'<tr><td><form id="suggest-btn-form"><div class="form-group"><input type="submit" value="Follow" class="btn btn-default"></div></form></td></tr>');
            /*'<td>' + row.multiplication.factorA + ' x ' + row.multiplication.factorB + '</td>' +
            '<td>' + row.resultAttempt + '</td>' +
            '<td>' + (row.correct === true ? 'YES' : 'NO' + '</td></tr>'));    
            */

        });

        $('#suggest-div').show();
    });
}


function followUser(userId) 
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
            //url: 'http://localhost:8080/publications',
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
}



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

                    userId= data.user.id;

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

        //
        updateSuggestedUsers(userId);

    });



    $("#suggest-btn-form").submit(function( event ) 
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
            //url: 'http://localhost:8080/publications',
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




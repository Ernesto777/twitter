function updateSuggestedUsers(userId) 
{
    $('#suggest-head').empty();

    $.ajax({
            url: "http://localhost:8080/follow?userId=" + userId,
    }).then(function(data) 
    {
        data.forEach(function(row)
        {        
            if(row.id == userId)
            {
              return;
            }

            $('#suggest-head').append('<tr><td>' + row.userName + '</td>' + 
                        '<td><input type="button" value="Follow" class="btn btn-default" onclick="followUser('+row.id+','+userId+');"></td></tr>');
        });

        $('#suggest-div').show();
    });
}


function followUser(userIdFollow, userIdFollower) 
{
        // Don't submit the form normally
        event.preventDefault();

        // Send the data using post
        $.ajax({
            url: "http://localhost:8080/follow?userIdFollow="+ userIdFollow+"&userIdFollower="+ userIdFollower,
            type: 'POST',
            //data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: false,
            success: function(data)
            {

                    if(data.id == userIdFollower)
                    {
                      alert("user alredy Followed");
                      return;
                    }

                    alert(data.userName + " Followed");
                    $('#posts-div').show();
                    $('#post-head').empty();
                    $('#post-body').empty();

                    /*$('#post-head').append('<tr><th> User name: ' + data.user.userName + '</th></tr>' +
                                           '<tr><th>' + data.descriptionPost + '</th></tr>' +
                                           '<tr><th> Creation date: ' + data.createdAt + '</th></tr>'); */
                
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
                                           '<tr><td>' + data.descriptionPost + '</td>' +
                                              '<td> Creation date: ' + data.createdAt + '</td></tr>'); 
                
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



    $("#last-form").submit(function( event ) 
    {
        // Don't submit the form normally
        event.preventDefault();

        if(document.getElementById("userName-post").value.length == 0)
        {
            alert("User name is empty");
            return false;
        }

        userN = document.getElementById("userName-post").value;

        // Send the data using post
        $.ajax({
            url: "http://localhost:8080/publications?userName=" + userN,
            //type: 'POST',
            //data: JSON.stringify(data),
            //contentType: "application/json; charset=utf-8",
            //dataType: "json",
            //async: false,
            success: function(data)
            {

                $('#post-head').empty();
                $('#post-body').empty();

                data.forEach(function(row)
                { 
                    $('#post-head').append('<tr><th> User name: ' + row.user.userName + '</th></tr>' +
                                           '<tr><td>' + row.descriptionPost + '</td>' +
                                              '<td> Creation date: ' + row.createdAt + '</td></tr>'); 
                 });   
            
                $('#posts-div').show();
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




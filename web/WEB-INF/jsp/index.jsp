<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script>
           
            $(document).ready(function () { // Οταν φορτώσει η σελίδα τρέξε....
                $("#ajaxtext").keyup(function () { // Βάλε handler στο input type
                    var text = $(this).val(); // Το κείμενο το χρήστη
                    // alert(text);
                    $.ajax({
                        url: 'ajaxsearch.htm?text2='+text,
                        contentType: 'application/json',
                        success: function (result) {
                            $("#ajaxoutput").empty();
                            var jsonobj = $.parseJSON(result);

                            $.each(jsonobj, function (i, item) {
                                $tr = $('<tr>').append(
                                        $('<td>').text(item.firstname),
                                        $('<td>').text(item.surname)

                                        );
                                $("#ajaxoutput").append($tr);
                            });
                        }
                    });
                });
            });
        </script>
    </head><body>
    <form action="searchingform.htm" method="post">
            <p>Check the database:<input type="text" name="text"/></p>
            
            <input type="submit" value="Verifying"/>
        </form>
        <p>New<input type="text" name="text2" id="ajaxtext" /></p>
        <div class="container"><table class="table table-striped">
    <c:forEach items="${users}" var="user">
        <tr>
            <td> ${user.firstname} <td>
            <td> ${user.surname} <td>
            <td> ${user.username} <td>
            <td> ${user.password} <td><br>
        <tr>
        </c:forEach>
            </table>
        </div>
    <div id="ajaxoutput"></div>
    <a href="insert.htm">Registration Form</a>
    </body>
</html>

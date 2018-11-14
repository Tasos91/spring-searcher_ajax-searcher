<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

       
           <spring:form modelAttribute="user" action="formhandling.htm" method="POST" class="center">
              <table>
               <tr>
                   <td>Name</td>
                   <td><spring:input path="firstname" /></td>
                   <td><spring:errors path="firstname" cssClass="error"/></td>
               </tr>
               <tr>
                    <td>Password</td>
                   <td><spring:input path="password" /></td>
                   <td><spring:errors path="password" cssClass="error"/></td>

               </tr>

                   <td colspan="3">
                      <input type="submit" value="Submit" />
                   </td>
               </tr>
           </table>
       </spring:form>

   </body>
</html>

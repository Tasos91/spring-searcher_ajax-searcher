<%@page import="org.springframework.ui.ModelMap"%>
<!DOCTYPE html>
<html>
    <%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
    <head>
        <meta charset="UTF-8">
       
        <title>User Register Form </title>
         <style>
              .center {
                margin: auto;
                width: 50%;
                padding: 20px;
              }
         </style>
    </head>
    <body>
        
        <h1 class="center">User Register Form</h1>
            <spring:form modelAttribute="user" action="registerhandling.htm" method="GET" class="center">
               <table>
                <tr>
                    <td><spring:label path="name">Type Name</spring:label></td>
                    <td><spring:input path="name" /></td>
                </tr>
                <tr>
                    <td><spring:label path="surname">Surname</spring:label></td>
                    <td><spring:input path="surname" /></td>
                </tr>
                <tr>
                    <td><spring:label path="password">Password</spring:label></td>
                    <td><spring:password path="password" /></td>
                </tr>
                <%  ModelMap model = new ModelMap();
                    String pswd1 =(String)model.get("password");%>
                <tr>
                    <td><spring:label path="confirm-password">Confirm Password </spring:label></td>
                    <td><spring:password path="Confirm-password" /></td>
                </tr>
                <% String pswd2 = (String)model.get("password");%>
                <tr>
                    <td><spring:label path="id">User Id</spring:label></td>
                    <td><spring:input path="id" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                       <input type="submit" value="Submit" />
                    </td>
                </tr>
            </table>
        </spring:form>
           
    </body>
</html>

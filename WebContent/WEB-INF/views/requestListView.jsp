 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Request List</title>
 </head>
 <body style="background:antiquewhite">
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Request List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>id</th>
          <th>FIO</th>
          <th>Service</th>
          <th>Telephone</th>
          <th>Email</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${requestList}" var="request" >
          <tr>
             <td>${request.idr}</td>
             <td>${request.FIO}</td>
             <td>${request.usluga}</td>
             <td>${request.telephone}</td>
             <td>${request.email}</td>
             <td>
                <a href="editRequest?id=${request.idr}">Edit</a>
             </td>
             <td>
                <a href="deleteRequest?id=${request.idr}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createRequest" >Create Request</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>
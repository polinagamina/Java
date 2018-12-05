 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>RegRequest List</title>
 </head>
 <body style="background:antiquewhite">
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>RegRequest List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>id</th>
          <th>Data</th>
          <th>FIO</th>
          <th>State</th>
          <th>Service</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${regrequestList}" var="regrequest" >
          <tr>
             <td>${regrequest.id}</td>
             <td>${regrequest.data}</td>
             <td>${regrequest.FIO}</td>
             <td>${regrequest.state}</td>
             <td>${regrequest.usluga}</td>
             <td>
                <a href="editRegRequest?id=${regrequest.id}">Edit</a>
             </td>
             <td>
                <a href="deleteRegRequest?id=${regrequest.id}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createRegRequest" >Create RegRequest</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>RegAgreement List</title>
 </head>
 <body style="background:antiquewhite">
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>RegAgreement List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>id</th>
          <th>Data</th>
          <th>FIO</th>
          <th>OI</th>
          <th>Type</th>
          <th>Kind</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${regagreementList}" var="regagreement" >
          <tr>
             <td>${regagreement.id}</td>
             <td>${regagreement.data}</td>
             <td>${regagreement.FIO}</td>
             <td>${regagreement.OI}</td>
             <td>${regagreement.type}</td>
             <td>${regagreement.kind}</td>
             
             
             <td>
                <a href="editRegAgreement?id=${regagreement.id}">Edit</a>
             </td>
             <td>
                <a href="deleteRegAgreement?id=${regagreement.id}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createRegAgreement" >Create RegAgreement</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>
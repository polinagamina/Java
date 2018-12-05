 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Agreement List</title>
 </head>
 <body style="background:antiquewhite">
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Agreement List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>id</th>
          <th>FIO</th>
          <th>Service</th>
          <th>Kind</th>
          <th>Type</th>
          <th>Price</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${agreementList}" var="agreement" >
          <tr>
             <td>${agreement.idd}</td>
             <td>${agreement.FIO}</td>
             <td>${agreement.usluga}</td>
             <td>${agreement.kind}</td>
             <td>${agreement.type}</td>
             <td>${agreement.price}</td>
             <td>
                <a href="editAgreement?id=${agreement.idd}">Edit</a>
             </td>
             <td>
                <a href="deleteAgreement?id=${agreement.idd}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createAgreement" >Create Agreement</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>
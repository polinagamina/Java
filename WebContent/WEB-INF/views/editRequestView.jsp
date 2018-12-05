<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit Request</title>
   </head>
   <body style="background:antiquewhite">
 
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Edit Request</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty request1}">
         <form method="POST" action="${pageContext.request.contextPath}/editRequest">
            <input type="hidden" name="idr" value="${request1.idr}" />
            <table border="0">
               <tr>
               <td>id</td>
               <td><input type="text" name="id" value="${request1.idr}" /></td>
            </tr>
            <tr>
               <td>FIO</td>
               <td><input type="text" name="FIO" value="${request1.FIO}" /></td>
            </tr>
            <tr>
               <tr>
               <td>Service</td>
               <td><input type="text" name="Service" value="${request1.usluga}" /></td>
            </tr>
            <tr>
               <td>Telephone</td>
               <td><input type="text" name="Telephone" value="${request.telephone}" /></td>
            </tr>
             <tr>
               <td>Email</td>
               <td><input type="text" name="Email" value="${request1.email}" /></td>
            </tr>
            <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/requestList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="_footer.jsp"></jsp:include>
 
   </body>
</html>
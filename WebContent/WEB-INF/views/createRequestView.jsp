<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Create Request</title>
   </head>
   <body style="background:antiquewhite">
    
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
       
      <h3>Create Request</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/createRequest">
         <table border="0">
            <tr>
               <td>id</td>
               <td><input type="text" name="id" value="${request.idr}" /></td>
            </tr>
            <tr>
               <td>FIO</td>
               <td><input type="text" name="FIO" value="${request.FIO}" /></td>
            </tr>
            <tr>
               <td>Service</td>
               <td><input type="text" name="Service" value="${request.usluga}" /></td>
            </tr>
            <tr>
               <td>Telephone</td>
               <td><input type="text" name="Telephone" value="${request.telephone}" /></td>
            </tr>
             <tr>
               <td>Email</td>
               <td><input type="text" name="Email" value="${request.email}" /></td>
            </tr>
            
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="requestList">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       
      <jsp:include page="_footer.jsp"></jsp:include>
       
   </body>
</html>
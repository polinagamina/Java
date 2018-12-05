<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Create RegRequest</title>
   </head>
   <body style="background:antiquewhite">
    
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
       
      <h3>Create RegRequest</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/createRegRequest">
         <table border="0">
            <tr>
               <td>id</td>
               <td><input type="text" name="id" value="${regrequest.id}" /></td>
            </tr>
             <tr>
               <td>Data</td>
               <td><input type="text" name="Data" value="${regrequest.data}" /></td>
            </tr>
            <tr>
               <td>FIO</td>
               <td><input type="text" name="FIO" value="${regrequest.FIO}" /></td>
            </tr>
             <tr>
               <td>State</td>
               <td><input type="text" name="State" value="${regrequest.state}" /></td>
            </tr>
            <tr>
               <td>Service</td>
               <td><input type="text" name="Service" value="${regrequest.usluga}" /></td>
            </tr>
           
            
            
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="regrequestList">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       
      <jsp:include page="_footer.jsp"></jsp:include>
       
   </body>
</html>
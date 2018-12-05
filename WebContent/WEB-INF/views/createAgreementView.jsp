<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Create Agreement</title>
   </head>
   <body style="background:antiquewhite">
    
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
       
      <h3>Create Agreement</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/createAgreement">
         <table border="0">
            <tr>
               <td>id</td>
               <td><input type="text" name="id" value="${agreement.idd}" /></td>
            </tr>
            <tr>
               <td>FIO</td>
               <td><input type="text" name="FIO" value="${agreement.FIO}" /></td>
            </tr>
            <tr>
               <td>Service</td>
               <td><input type="text" name="Service" value="${agreement.usluga}" /></td>
            </tr>
            <tr>
               <td>Kind</td>
               <td><input type="text" name="kind" value="${agreement.kind}" /></td>
            </tr>
             <tr>
               <td>Type</td>
               <td><input type="text" name="type" value="${agreement.type}" /></td>
            </tr>
            <tr>
               <td>Price</td>
               <td><input type="text" name="price" value="${agreement.price}" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="agreementList">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       
      <jsp:include page="_footer.jsp"></jsp:include>
       
   </body>
</html>
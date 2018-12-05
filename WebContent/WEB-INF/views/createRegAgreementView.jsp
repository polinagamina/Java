<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Create RegAgreement</title>
   </head>
   <body style="background:antiquewhite">
    
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
       
      <h3>Create RegAgreement</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/createRegAgreement">
         <table border="0">
            <tr>
               <td>id</td>
               <td><input type="text" name="id" value="${regagreement.id}" /></td>
            </tr>
             <tr>
               <td>Data</td>
               <td><input type="text" name="Data" value="${regagreement.data}" /></td>
            </tr>
            <tr>
               <td>FIO</td>
               <td><input type="text" name="FIO" value="${regagreement.FIO}" /></td>
            </tr>
            
            <tr>
               <td>OI</td>
               <td><input type="text" name="OI" value="${regagreement.OI}" /></td>
            </tr>
             <tr>
               <td>Type</td>
               <td><input type="text" name="type" value="${regagreement.type}" /></td>
            </tr>
            <tr>
               <td>Kind</td>
               <td><input type="text" name="kind" value="${regagreement.kind}" /></td>
            </tr>
            
           
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="regagreementList">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       
     <!--   <jsp:include page="_footer.jsp"></jsp:include>-->
       
   </body>
</html>
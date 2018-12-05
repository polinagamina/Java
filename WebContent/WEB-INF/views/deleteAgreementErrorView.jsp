<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Delete Agreement</title>
 </head>
 
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
    
    <h3>Delete Agreement</h3>
    
    <p style="color: red;">${errorString}</p>
    <a href="agreementList">Agreement List</a>
    
    <jsp:include page="_footer.jsp"></jsp:include>
    
 </body>
</html>
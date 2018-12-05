<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<style type="text/css">
.navigation {
   list-style: none; /* Отключение отображения маркеров. */
}
.navigation li {
   float: left; /* Выстраивание элементов списка в один ряд. */
   margin-right: 1px; /* создание отступов для того, чтобы не сливались пункты меню. */
   font-family: Verdana, Arial, Helvetica, sans-serif; /* Указание типа шрифта. */
   font-size: 14px; /* Размер текста в ссылках. */
}
.navigation li a {
   display: block; 
   padding: 15px 20px;  
   background:skyblue; 
   color: #3f3f3f; 
   text-decoration: none; 
   position: relative;
}
.navigation li a:hover {
   background: aliceblue; /* Цвет блока при наведении курсора. */
   color: #6b6b6b;  /* Цвет текста при наведении курсора. */
}
</style>   
   

<div style="padding: 5px;">
 
   <a style="    
   padding: 15px 20px;  
   background:skyblue; 
   color: #3f3f3f; 
   text-decoration: none; 
   position: relative;" href="${pageContext.request.contextPath}/home">Home</a>
   
   <a style="   
   padding: 15px 20px;  
   background:skyblue; 
   color: #3f3f3f; 
   text-decoration: none; 
   position: relative; "href="${pageContext.request.contextPath}/agreementList">Agreement List</a>
   
   <a style="   
   padding: 15px 20px;  
   background:skyblue; 
   color: #3f3f3f; 
   text-decoration: none; 
   position: relative; " href="${pageContext.request.contextPath}/requestList">Request List</a>
   
   <a  style="   
   padding: 15px 20px;  
   background:skyblue; 
   color: #3f3f3f; 
   text-decoration: none; 
   position: relative; "href="${pageContext.request.contextPath}/regagreementList">RegAgreement List</a>
   
   <a style="   
   padding: 15px 20px;  
   background:skyblue; 
   color: #3f3f3f; 
   text-decoration: none; 
   position: relative; " href="${pageContext.request.contextPath}/regrequestList">RegRequest List</a>
   
   <a style="   
   padding: 15px 20px;  
   background:skyblue; 
   color: #3f3f3f; 
   text-decoration: none; 
   position: relative; "href="${pageContext.request.contextPath}/userInfo">My Account Info</a>
   
   <a style="   
   padding: 15px 20px;  
   background:skyblue; 
   color: #3f3f3f; 
   text-decoration: none; 
   position: relative; " href="${pageContext.request.contextPath}/login">Login</a>
    
</div>
 
 </body>
</html> 
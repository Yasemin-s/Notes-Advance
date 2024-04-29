<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="com.User.UserDetails"
    pageEncoding="ISO-8859-1"%>
    
        <%
    UserDetails user2 = (UserDetails) session.getAttribute("UserD");
    
    if(user2 == null){
    	response.sendRedirect("login.jsp");
    	session.setAttribute("Login-error","please login");
    }
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allcss.jsp" %>
</head>
<body>

<div class="container-fluid">
<%@include file="all_component/navbar.jsp" %>
<div class ="card py-5">
<div class="card-body text-center">
<img alt="" src="img/paper.jpg" class="img-fluid mx-auto" style="max-width: 300px;">
<h1>Start Taking Your Notes</h1>
<a href="addNotes.jsp" class="btn btn-outline-primary">Start Here</a>
</div>

</div>
</div>
<%@include file="all_component/footer.jsp"%>
</body>
</html>
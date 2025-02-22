

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@include file="all_component/allcss.jsp" %>
</head>
<body>

<%@include file="all_component/navbar.jsp" %>
<div class="container-fluid div-color">
<div class="row">
<div class="col-md-4 offset-md-4">
<div class="card mt-4">
<div class="card-header text-center text-white bg-custom">
<i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
<h4>Login Page</h4>
</div>
<%
String invalidMsg = (String) session.getAttribute("login-failed");
if(invalidMsg != null){
	%>
	<div class="alert alert-danger" role="alert"><%=invalidMsg %></div>
<%
	session.removeAttribute("login-failed");
	}
%>



<div class="card-body"><form action="loginServlet" method="post">
      <div class="form-group">
      <label>Enter email</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name = "uemail">
    </div>
    
    
  <div class="form-group">
    <label for="exampleInputPassword1">enter Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name = "upassword">
  </div>

  <button type="submit" class="btn btn-primary badge-pill btn-block">Login</button>
</form>
</div>
</div>
</div>
</div>
</div>
<%@include file="all_component/footer.jsp" %>
</body>
</html>
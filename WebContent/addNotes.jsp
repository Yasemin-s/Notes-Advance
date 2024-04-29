<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="com.User.UserDetails"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>
<%@include file="all_component/allcss.jsp" %>
</head>
<body>


<div class="container-fluid"></div>
<%@include file="all_component/navbar.jsp" %>
<h1 class="text-center">Add Your Notes</h1>

<div class="container">
<div class="row">
<div class="col-md-12">

<form action="AddNotesServlet" method="post">
  <div class="form-group">
  <%
UserDetails us = (UserDetails)session.getAttribute("UserD");

if (us != null) {
%>
<input type="hidden" value="<%=us.getId()%>" name="uid">
<%
} else {
%>
<p>user not found, please enter login.</p>
<%
}
%>

    <label for="exampleInputEmail1">Note Title</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="title" required="required">
     </div>

<div class="form-group">
 <label for="exampleInputEmail1">Note Content</label>
<textarea rows="9" cols="" class="form-control" name="content" required="required"></textarea>
</div>




  <div class = "container text-center">
  <button type="submit" class="btn btn-primary">Add Notes</button>
  </div>
  
</form>
</div>
</div>

</div>




</div>









<%@include file="all_component/footer.jsp" %>

</body>
</html>
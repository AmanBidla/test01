<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="javax.servlet.http.HttpSession" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h3>Welcome, s
<% 
HttpSession ht = request.getSession(false);
String user = (String)ht.getAttribute("user");
out.println(user);
%>

</h3><br><br><br><br>
<a href='createaccount.jsp'>Create Account</a> 
&nbsp; &nbsp; 
<a href='edit.jsp'>Edit Account</a> 
&nbsp; &nbsp; 
<a href='delete.html'>Delete Account</a> 
</center>
</body>
</html>
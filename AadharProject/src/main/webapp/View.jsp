<%@page import="com.digit.hibernate.aadhar.AadharDetails"%>
<%@page import="java.util.Iterator"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>

</head>

<body>

	<%

session = request.getSession();

List li=(List) session.getAttribute("list");

Iterator itr=li.iterator();


while(itr.hasNext()){
	AadharDetails a = (AadharDetails)itr.next();
	out.println(a.getId()+" "+a.getName());
}

%>



</body>

</html>
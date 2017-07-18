<%@page import="com.mfs.controller.GenericController"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,java.io.File,java.io.IOException" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
 <form method="post" action="process">
 <input type="file" name="path" >
  <input type="submit" name="path">
 </form>
 ${FilePath}
 
 <c:if test="${FilePath!=null}" >
 
 Project Structure data </br>
<% TreeSet listData= (TreeSet)request.getAttribute("data");   //GenericController.getData( request);%>
<%  
Iterator nextData=listData.iterator();
while(nextData.hasNext())
{%>
<%= nextData.next()%><br>
<%} %>

</c:if>


 
</body>
</html>
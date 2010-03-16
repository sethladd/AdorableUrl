<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@include file="/WEB-INF/jsp/header.html" %>
  
  <body>

	<p>
	Your Adorable URL is
	<a href="http://adorableurl.com/<%= request.getAttribute("url-code") %>">http://adorableurl.com/<%= request.getAttribute("url-code") %></a>
	</p>

<%@include file="/WEB-INF/jsp/footer.jsp" %>
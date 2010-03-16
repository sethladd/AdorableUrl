<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@include file="/WEB-INF/jsp/header.html" %>

  <body>
    <h1>Adorable URL</h1>
    
    <p>
    Turn that boring URL into a adorable and cute URL, full of unicorns, rainbows, and puppies!
    </p>
	
	<form action="/adorable" method="post">
		<p>
		<label for="url">URL:</label>
		<input type="text" id="url" name="u">
		</p>
		<p>
		<input type="submit" value="Adorablize!" />
		</p>
	</form>
	
<%@include file="/WEB-INF/jsp/footer.jsp" %>

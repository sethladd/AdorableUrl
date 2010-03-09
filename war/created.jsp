<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Adorable URL - Convert and Shorten URLs into Adorable Cute URLs</title>
  </head>
  
  <body>

Your Adorable URL is http://www.adorableurl.com/<%= request.getAttribute("url-code") %>

	<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-15126391-1");
pageTracker._trackPageview();
} catch(err) {}</script>

  </body>
</html>
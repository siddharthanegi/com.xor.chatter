<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script  src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chatter-Home</title>
<script type="text/javascript">
function callChat(uid){
	alert(uid);
	$.ajax({
		type: "POST",
		url: "StartChat",
		data: "uid="+uid,
		success: function(response){
			window.location="redirect";
		}
	});
};
</script>
</head>
<body>
<div class="container">
<h1>Chatter</h1>
<p>Welcome <b>${user.firstName}</b> !<br>Let's chat :D</p>
<div id="friends">
Friends: 
<table>
<tr>
<c:forEach items="${user.getFriends()}" var="friend">
	<td>
	<input type="button" value="${friend.getFirstName()}" onclick="callChat(${friend.getUid()});">
	 </td>
</c:forEach>

</table>

</div>
<div id="friend-suggestions">


</div>
</div>

</body>
</html>
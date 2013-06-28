<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="refresh" content="15" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/json2/20121008/json2.js"> </script>

<script type="text/javascript">

$(document).ready(function(){
	
	$.ajax({
		type:"GET",
		url:"PreviousConvo",
		success:function(response){
			
			var pastMessages=JSON.parse(response);
			var convo_body="";
			for(var i=0;i<pastMessages.length;i++){
				
				
				convo_body+="<div class='message'> <p> <b><span class='sender'>"+pastMessages[i].senderName+"</span></b> : <em>"+pastMessages[i].message+"</em></p>Date: "+pastMessages[i].msgDate+"</div>";
				
				//<c:choose> <c:when test='${user.uid ==""}'> ${user.firstName} </c:when> <c:otherwise> ${friend.firstName} </c:otherwise> </c:choose>
			}
			$(".conversation").html(convo_body);
			
		}
	});
	
});

	function sendMessage(){
		$.ajax({
			type:"POST",
			url:"Message",
			data:"msg="+$('#message-area').val(),
			success:function(){
				alert("Message sent!");
				$('#message-area').val('');
//				getPreviousConvo();
			}, 
			
	
		});
	};
	
	function getPreviousConvo(){
	
		$.ajax({
			type:"GET",
			url:"PreviousConvo",
			success:function(response){
				alert("Done");
				
			}
		});
	}
	
</script>
<title>Chatter</title>
</head>
<body>
<div class='container'>
<div id='message-box'>
To ${friend.firstName}, <br>
<textarea id='message-area' rows="4" cols="50"></textarea><br>
<input type="button" value="Send" onclick="sendMessage();">
</div>
<div class='conversation'>

</div>
</div>
</body>
</html>
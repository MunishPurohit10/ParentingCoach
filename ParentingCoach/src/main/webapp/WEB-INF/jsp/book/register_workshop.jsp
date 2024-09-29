<html>
	<head>
		<title>Strong Roots</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="stylesheet/breadcrum.css" />
	</head>
<body>
	<jsp:include page="../header.jsp"/>
    <h2 style="color:Red;">Select Workshop ${workshopEvent.workshopName}</h2>
    ${workshopEvent.workshopDescription}
    <br><br>
    <form action="bookWorkshopSlot" method="get">
    	<input type="hidden" name="workshopEventId" value="${workshopEvent.workshopEventId}"/>
	    <label>Workshop Start</label> : ${workshopEventStart} <br><br>
	    <label>Workshop End</label> :  ${workshopEventEnd} <br><br>
	    
	    <button type="submit" formaction="home">Cancel</button>     <button type="submit" formaction="bookWorkshopSlot">Confirm</button> 
	</form>
</body>
</html>
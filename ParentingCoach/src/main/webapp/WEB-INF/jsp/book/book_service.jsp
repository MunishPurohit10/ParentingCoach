<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>Strong Roots</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="stylesheet/breadcrum.css" />
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.min.js"></script>
		<script>
		  $(function() {
		    $(".datepicker").datepicker();
		  });
		</script>
	</head>
<body>
	<jsp:include page="../header.jsp"/>
    <h2 style="color:Red;">Select Service ${service}</h2>
    <form action="bookSlot" method="get">
	    <label>Booking Slot</label> :
	    <input type="hidden" name="offerId" value="${offerId}"/>
	    <c:forEach var="sessionInterval" items="${sessionIntervalList}">
	       <input type="radio" name="sessionIntervalStart" id="sessionIntervalStart" value="${sessionInterval.startDateTime}" > ${sessionInterval.startDateTime} - ${sessionInterval.endDateTime}</input> <br><br>
	    </c:forEach>
	    <button type="submit" formaction="home">Cancel</button>     <button type="submit" formaction="bookSlot">Confirm</button> 
	</form>
</body>
</html>
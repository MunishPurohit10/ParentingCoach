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
	<jsp:include page="../common/breadcrumb.jsp" />
    <font color="red">${errorMessage}</font>
    <img src="images/StrongRootsLogo.png" width="600" height="200"></img>
    <h2 style="color:Red;">Select Service ${service}</h2>
    <form action="bookSlot" method="get">
	    <label>Booking Slot</label> : 
	    <c:forEach var="sessionInterval" items="${sessionIntervalList}">
	       <input type="radio" name="sessionInterval" id="sessionInterval" value="${sessionInterval.startDateTime}" > ${sessionInterval.startDateTime} - ${sessionInterval.endDateTime}</input> <br><br>
	    </c:forEach>
	    <button type="submit" formaction="home">Cancel</button>     <button type="button" formaction="bookSlot">Confirm</button> 
	</form>
</body>
</html>
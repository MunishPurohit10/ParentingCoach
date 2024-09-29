<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>Strong Roots</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="stylesheet/breadcrum.css" />
	</head>
<body>
	<jsp:include page="../common/breadcrumb.jsp" />
    <font color="red">${errorMessage}</font>
    <img src="images/StrongRootsLogo.png" width="100%" height="100%"></img>
    <h2 style="color:Red;">Remove Workshop</h2>
	<form action="deleteWorkshop" method="get">
		<table cellpadding="0" cellspacing="0" align="left">
		    <c:forEach var="workshopEvent" items="${workshopEvents}">
		    	<tr>
		       		<td><input type="checkbox" name="workshopEvents" id="workshopEvents" value="${workshopEvent.workshopEventId}" size="40"> </td><td>${workshopEvent.workshopName} </td><td>${workshopEvent.workshopDescription}</input> </td>
		    	</tr>
		    </c:forEach>
		    <tr>
		    	<td><button type="submit" formaction="home">Cancel</button>   </td><td>  </td><td><button type="submit" formaction="deleteWorkshop">Confirm</button> </td>
			</tr>
		</table>
	</form>
</body>
</html>
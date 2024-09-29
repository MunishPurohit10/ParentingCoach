<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>Strong Roots</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="stylesheet/breadcrum.css" />
	</head>
<body>
	<jsp:include page="../header.jsp"/>
    <h2 style="color:Red;">Remove Offering</h2>
    <form action="deleteOffering" method="get">
    	<table cellpadding="0" cellspacing="0" align="left">
		    <c:forEach var="offer" items="${offers}">
		    	<tr>
		       		<td><input type="checkbox" name="offers" id="offers" value="${offer.offerId}" size="40"> </td><td>${offer.offerName} </td><td>${offer.offerDescription}</input> </td>
		    	</tr>
		    </c:forEach>
		    <tr>
		    	<td><button type="submit" formaction="home">Cancel</button>  </td><td>   </td><td><button type="submit" formaction="deleteOffering">Confirm</button> </td>
			</tr>
		</table>
	</form>
</body>
</html>
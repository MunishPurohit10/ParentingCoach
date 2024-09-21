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
    <img src="images/StrongRootsLogo.png" width="600" height="200"></img>
    <h2 style="color:Red;">Remove Offering</h2>
    <form action="deleteOffering" method="get">
	    <c:forEach var="offer" items="${offers}">
	       <input type="checkbox" name="offers" id="offers" value="${offer.offerId}" size="40"> ${offer.offerName} ${offer.offerDescription}</input> <br><br>
	    </c:forEach>
	    <button type="submit" formaction="home">Cancel</button>     <button type="submit" formaction="deleteOffering">Confirm</button> 
	</form>
</body>
</html>
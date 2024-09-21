<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>Strong Roots</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="stylesheet/breadcrum.css" />
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.min.js"></script>
		<script>
		  
		  
		</script>
	</head>
<body>
	<jsp:include page="./common/breadcrumb.jsp" />
    <font color="red">${errorMessage}</font>
    <img src="images/StrongRootsLogo.png" width="600" height="200"></img>
    <h2 style="color:Red;">Offering</h2> 
    <form action="home" method="get">
    	<button type="submit" formaction="addOffering">Add Offering</button>     <button type="submit" formaction="removeOffering">Remove Offering</button> 
	</form>
	<c:forEach var="offer" items="${offers}">
		<form action="home" method="get">
			<input type="hidden" name="offerId" value="${offer.offerId}"/>
	        ${offer.offerName} ${offer.offerDescription} <button type="submit" formaction="bookService">Book</button> <br>
	    </form>
	</c:forEach>
    
	<h2 style="color:Red;">Workshop</h2> 
	<form action="home" method="get">
    	<button type="submit" formaction="addWorkshop">Add Workshop</button>     <button type="submit" formaction="removeWorkshop">Remove Workshop</button> 
	</form>
	
	<c:forEach var="workshopEvent" items="${workshopEvents}">
		<form action="home" method="get">
		   <input type="hidden" name="workshopEventId" value="${workshopEvent.workshopEventId}"/>
	       ${workshopEvent.workshopName} ${workshopEvent.workshopDescription} <button type="submit" formaction="registerWorkshop">Register</button> <br> 
	    </form>
	</c:forEach>
    
	<h2 style="color:Red;">Article</h2> 
	<form action="home" method="get">
    	<button type="submit" formaction="addArticle">Add Article</button>     <button type="submit" formaction="removeArticle">Remove Article</button> 
	</form>
	<c:forEach var="article" items="${articles}">
        ${article.articleName} ${article.articleDescription} <br><br>
    </c:forEach>
</body>
</html>
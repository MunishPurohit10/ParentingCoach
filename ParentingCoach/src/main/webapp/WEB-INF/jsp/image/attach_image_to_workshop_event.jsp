<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Strong Roots</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="stylesheet/breadcrum.css" />
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.min.js"></script>
		<script src="javascript/common.js"></script>
	</head>
	<body>
		<jsp:include page="../header.jsp"/>
	    <h2 style="color:Red;">Associate Image To Workshop Event</h2>
		<form action="associateImageToWorkshopEvent" method="get">
			<input type="hidden" name="workshopEventId" value="${workshopEventId}"/>
			<c:forEach var="image" items="${images}">
		       <input type="radio" name="imageId" id="imageId" value="${image.imageId}" size="40"> ${image.imageName} </input> <br><br>
		    </c:forEach>
		    <button type="submit" formaction="home">Cancel</button>     <button type="submit" formaction="associateImageToWorkshopEvent">Confirm</button> 
		</form>
	</body>
</html>
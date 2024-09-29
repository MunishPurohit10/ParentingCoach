<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Strong Roots</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="stylesheet/breadcrum.css" />
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.min.js"></script>
	</head>
<body>
    <jsp:include page="header.jsp"/>
    <hr>
    <h2 style="color:Red;">Offering</h2>
    <c:set var = "consultant" value="consultant"/>
    <c:if test="${userType eq consultant}">  
	    <form action="home" method="get">
		    	<button type="submit" formaction="addOffering">Add Offering</button>    <button type="submit" formaction="removeOffering">Remove Offering</button>
		</form>
	</c:if>
    <table cellpadding="0" cellspacing="0" align="left">
		<c:forEach var="offer" items="${offers}">
			<tr>
				<form action="home" method="get">
					<input type="hidden" name="offerId" value="${offer.offerId}"/>
			        <td>${offer.offerName}</td> <td>${offer.offerDescription}</td> 
			        <td><button type="submit" formaction="bookService">Book</button></td>  
			    </form>     
			</tr>        
		</c:forEach>
    </table>
    <br> 
    <br>
    <br>
    <hr>

	<h2 style="color:Red;">Workshop</h2> 
	<c:if test="${userType eq consultant}"> 
		<form action="home" method="get">
	    	<button type="submit" formaction="addWorkshop">Add Workshop</button>     <button type="submit" formaction="removeWorkshop">Remove Workshop</button> 
		</form>
	</c:if> 
	
    <table cellpadding="0" cellspacing="0" align="left">        
		<c:forEach var="workshopEventWrapper" items="${workshopEventWrappers}">
			<tr>
				<form action="home" method="get">
				   <input type="hidden" name="workshopEventId" value="${workshopEventWrapper.workshopEvent.workshopEventId}"/>
				   <td> 
			       		<img  src="data:image/jpg;base64,${workshopEventWrapper.encodedImageStr}" alt="No Image" width="100%" height="100%" style="vertical-align:middle"/> 
			       </td>
			       <td>
			       		${workshopEventWrapper.workshopEvent.workshopName}
			       </td>
			       <td>
			       		${workshopEventWrapper.workshopEvent.workshopDescription}
			       </td>
			       <td> 
			       		<button type="submit" formaction="registerWorkshop">Register</button> 
			       </td>
			       <c:if test="${userType eq consultant}"> 
				       <td>
				       		<button type="submit" formaction="associateWorkshopEventToImage">Add Image</button>
				       </td>
			       </c:if>
			    </form>
		    </tr>
		</c:forEach>
    </table>
    <br> 
    <br>
    <br>
    <hr>
	<h2 style="color:Red;">Article</h2> 
	<c:if test="${userType eq consultant}"> 
		<form action="home" method="get">
	    	<button type="submit" formaction="addArticle">Add Article</button>     <button type="submit" formaction="removeArticle">Remove Article</button> 
		</form>
	</c:if> 
	<table cellpadding="0" cellspacing="0" align="left">   
		<c:forEach var="articleWrapper" items="${articleWrappers}">
		
			<form action="associateArticleToImage" method="get">
				<input type="hidden" name="articleId" value="${articleWrapper.article.articleId}"/>
				<tr>
					<td>
						<img  src="data:image/jpg;base64,${articleWrapper.encodedImageStr}" alt="No Image" width="100%" height="100%" style="vertical-align:middle"/> 
					</td>
				</tr>
				<tr>
					<td>
		        		${articleWrapper.article.articleName}
		        	</td>
		        	<td>
		        		${articleWrapper.article.articleDescription}
		        	</td>
		        	<c:if test="${userType eq consultant}"> 
			        	<td>
			        		<button type="submit" formaction="associateArticleToImage">Add Image</button> 
			        	</td>
		        	</c:if>
	        	</tr>
	    	</form>   
    	</c:forEach>
    </table>
    <br> 
    <br>
    <br>
    <hr>
    <c:if test="${userType eq consultant}"> 
	    <h2 style="color:Red;">Add Image</h2> 
		<form action="addImage" method="get">
	    	<button type="submit" formaction="addImage">Add New Image</button>
		</form>
	</c:if>
	<br> 
    <br>
    <br>
	<hr>
</body>
</html>
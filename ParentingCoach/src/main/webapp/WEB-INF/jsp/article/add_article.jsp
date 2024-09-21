
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
    <h2 style="color:Red;">Add Article</h2>
    <form action="confirmArticle" method="get">
	    <label>Name</label> : <input type="text" name="article_name" id="article_name" size="40"></input> <br><br>
	    <label>Detail</label> : <textarea name="article_description" id="article_description" rows="20" cols="60"></textarea> <br><br>
	    <label>Expiry Date</label> : <input name="expiry_date" id="expiry_date" type="text" class="datepicker"/> <br><br>
	    
	    <button type="submit" formaction="home">Cancel</button>     <button type="submit" formaction="confirmArticle">Confirm</button> 
	</form>
</body>
</html>
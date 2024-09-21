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
    <h2 style="color:Red;">Add Offering</h2>
    <form action="confirmOffering" method="get">
	    <label>Name</label> : <input type="text" name="offer_name" id="offer_name" size="40"></input> <br><br>
	    <label>Duration (In Minute)</label> : <input type="text" name="duration" id="duration" size="10"/> <br><br>
	    <label>Detail</label> : <textarea name="offer_detail" id="offer_detail" rows="20" cols="60"></textarea> <br><br>
	    <label>Expiry Date</label> : <input name="expiry_date" id="expiry_date" type="text" class="datepicker"/> <br><br>
	    
	    <button type="submit" formaction="home">Cancel</button>     <button type="submit" formaction="confirmOffering">Confirm</button> 
	</form>
</body>
</html>
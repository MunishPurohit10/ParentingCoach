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
    <h2 style="color:Red;">Add Offering</h2>
    <form action="confirmOffering" method="get">
	    <table cellpadding="0" cellspacing="0" align="left">
	    	<tr>
		    	<td><label>Name</label> : </td><td><input type="text" name="offer_name" id="offer_name" size="30%" required></input> </td>
		    </tr>
		    <tr>
		    	<td><label>Duration (In Minute)</label> : </td><td><input type="text" name="duration" id="duration" size="20%" required/> </td>
		    </tr>
		    <tr>
		    	<td><label>Detail</label> : </td><td><textarea name="offer_detail" id="offer_detail" rows="20%" cols="30%" required></textarea> </td>
		    </tr>
		    <tr>
		    	<td><label>Expiry Date</label> : </td><td><input name="expiry_date" id="expiry_date" type="datetime-local" required/> </td>
		    </tr>
		    <tr>
		    	<td><button type="submit" formaction="home">Cancel</button>     </td><td><button type="submit" formaction="confirmOffering">Confirm</button> </td>
			</tr>
		</table>
	</form>
</body>
</html>
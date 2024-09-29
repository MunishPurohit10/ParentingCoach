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
	<jsp:include page="../common/breadcrumb.jsp" />
    <font color="red">${errorMessage}</font>
    <img src="images/StrongRootsLogo.png" width="100%" height="100%"></img>
    <h2 style="color:Red;">Add Workshop</h2>
    <form action="confirmWorkshop" method="get">
    	<table cellpadding="0" cellspacing="0" align="left">
		    <tr>
			    <td><label>Name</label> : </td><td><input type="text" name="workshop_name" id="workshop_name" size="30%" required></input> </td>
		    </tr>
		    <tr>
			    <td><label>Duration (In Minute)</label> : </td><td><input type="text" name="duration" id="duration" size="10%" required/> </td>
		    </tr>
		    <tr>
			    <td><label>Capacity</label> : </td><td><input type="text" name="capacity" id="capacity" size="10%" required/> </td>
		    </tr>
		    <tr>
			    <td><label>Detail</label> : </td><td><textarea name="workshop_description" id="workshop_description" rows="20" cols="30%" required></textarea> </td>
		    </tr>
		    <tr>
			    <td><label>Workshop Date</label> : </td><td><input type="datetime-local" name="event_date" id="event_date" size="20%" required/> </td>
		    </tr>
		    <tr>
			    <td><button type="submit" formaction="home">Cancel</button>     </td><td><button type="submit" formaction="confirmWorkshop">Confirm</button></td> 
			</tr>
		</table>
	</form>
</body>
</html>
<html>
	<head>
		<title>Strong Roots</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="stylesheet/breadcrum.css" />
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.min.js"></script>
	</head>
<body>
	<jsp:include page="./common/breadcrumb.jsp" />
	<hr>
    <font color="red">${errorMessage}</font>
    <img src="images/StrongRootsLogo.png" width="100%" height="100%"></img>
    
    <br><br>
    <font color="red">${errorMessages}</font>
    <font color="green">${successMessages}</font>
    <br><br>

</body>
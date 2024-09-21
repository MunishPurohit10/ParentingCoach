<html>
	<head>
		<title>Strong Roots</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="stylesheet/breadcrum.css" />
	</head>
<body>
	<jsp:include page="./common/breadcrumb.jsp" />
    <font color="red">${errorMessage}</font>
    <img src="images/StrongRootsLogo.png" width="600" height="200"></img>
    <br><br>
    <br><br>
    <form method="get">
        Name : <input type="text" id="name" name="name" /> <br><br>
        Password : <input type="password" id="password" name="password" /> <br><br>

        <button type="submit" formaction="loginUser">Login</button><br><br><br><br>
        
        <button type="submit" formaction="addNewUser">Add New User</button>
    </form>
</body>
</html>
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
    <br><br>
    <br><br>
    <form method="get">
        Login Id : <input type="text" id="loginName" name="loginName" /> <br><br>
        Password : <input type="password" id="password" name="password" /> <br><br>
		First Name : <input type="text" id="firstName" name="firstName" /> <br><br>
		Last Name : <input type="text" id="lastName" name="lastName" /> <br><br>
		Email : <input type="text" id="email" name="email" /> <br><br>
		phoneNumber : <input type="text" id="phoneNumber" name="phoneNumber" /> <br><br>
		Address : <input type="textBox" id="address" name="address" /> <br><br>
		Country : <input type="text" id="country" name="country" /> <br><br>
		City : <input type="text" id="city" name="city" /> <br><br>
		Zip Code : <input type="text" id="zipCode" name="zipCode" /> <br><br>
        <button type="submit" formaction="addPersonalDetails">Login</button>
    </form>
</body>
</html>
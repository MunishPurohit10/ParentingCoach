<html>
	<head>
		<title>Strong Roots</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="stylesheet/breadcrum.css" />
	</head>
<body>
    <jsp:include page="../header.jsp"/>
    <form method="get">
    	<table cellpadding="0" cellspacing="0" align="left">
    		<tr>
	        	<td>Login Id : </td><td><input type="text" id="loginName" name="loginName" required/> </td>
	        </tr>
	        <tr>
	        	<td>Password : </td><td><input type="password" id="password" name="password" required/> </td>
	        </tr>
	        <tr>
				<td>First Name : </td><td><input type="text" id="firstName" name="firstName" required/> </td>
			</tr>
	        <tr>
				<td> Last Name : </td><td><input type="text" id="lastName" name="lastName" required/> </td>
			</tr>
	        <tr>
				<td>Email : </td><td><input type="text" id="email" name="email" required/> </td>
			</tr>
	        <tr>
				<td>phoneNumber : </td><td><input type="text" id="phoneNumber" name="phoneNumber" required/> </td>
			</tr>
	        <tr>
				<td>Address : </td><td><input type="textBox" id="address" name="address" required/> </td>
			</tr>
	        <tr>
				<td>Country : </td><td><input type="text" id="country" name="country" required/> </td>
			</tr>
	        <tr>
				<td>City : </td><td><input type="text" id="city" name="city" required/> </td>
			</tr>
	        <tr>
				<td>Zip Code : </td><td><input type="text" id="zipCode" name="zipCode" required/> </td>
			</tr>
	        <tr>
	        	<td><button type="submit" formaction="addPersonalDetails">Login</button></td>
	        </tr>
        </table>
    </form>
</body>
</html>
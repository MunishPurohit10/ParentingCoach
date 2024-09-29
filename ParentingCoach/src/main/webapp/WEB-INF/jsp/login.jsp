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
    <form method="get">
    	<table cellpadding="0" cellspacing="0" align="left">
	    	<tr>
	        	<td>Name : </td>   <td><input type="text" id="name" name="name" required/></td>
	        </tr>
	        <tr>
	        	<td>Password : </td>   <td><input type="password" id="password" name="password" required/> </td>
			</tr>
			<tr>
	        	<td><button type="submit" formaction="loginUser">Login</button></td>
	        </tr>
	        <tr>
	        </tr><tr>
	        </tr><tr>
	        </tr>
	        <tr>
	        	<td><a title="Add New User" href="addNewUser">Add New User</a></td>
	        </tr>
        </table>
    </form>
	<script>
		$("#name").focus();
    </script>
</body>
</html>
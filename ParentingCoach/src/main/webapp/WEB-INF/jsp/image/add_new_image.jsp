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
		<jsp:include page="../header.jsp"/>
	    <h2 style="color:Red;">Image Upload Form</h2>
		<form action="uploadImage" method="post" enctype="multipart/form-data">
	 
	        <p><label for="file" class="label">Select image:</label>
	        	<input type="file" name="file" id="profile-image" accept="image/png, image/jpeg txt/*" required/>
	        </p>
	 
	        <p><label for="imagName">Image Name:</label>
	           <input type="text" id="imageName" name="imageName" required><br>
	        </p>
	 
	        <p>
	           <button type="submit" formaction="uploadImage">Upload Image</button>
	        </p>
	    </form>
	</body>
</html>
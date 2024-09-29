<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>Strong Roots</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<style>
			ul.breadcrumb {
			  padding: 10px 16px;
			  list-style: none;
		      background-color: #eee;
			}
			ul.breadcrumb li {
			  display: inline;
			  font-size: 18px;
			}
			ul.breadcrumb li+li:before {
			  padding: 8px;
			  color: black;
			  content: "/\00a0";
			}
			ul.breadcrumb li a {
			  color: #0275d8;
			  text-decoration: none;
			}
			ul.breadcrumb li a:hover {
			  color: #01447e;
			  text-decoration: underline;
			}
		</style>
	</head>
<body>
	<jsp:include page="../header.jsp"/>
    <h2 style="color:Red;">Remove Article</h2>
    <form action="deleteArticle" method="get">
	    <c:forEach var="article" items="${articles}">
	       <input type="checkbox" name="articles" id="articles" value="${article.articleId}" size="40"> ${article.articleName} ${article.articleDescription}</input> <br><br>
	    </c:forEach>
	    <button type="submit" formaction="home">Cancel</button>     <button type="submit" formaction="deleteArticle">Confirm</button> 
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
 
 <title>
	<tiles:getAsString name="title"></tiles:getAsString>
</title>
</head>
<body>
	<div class="container">
	
		<header>
			<div class="row">
				<tiles:insertAttribute name="header" />
				 <hr></hr>	  	
			</div>
			
		</header>
	
		<div class="row">
			<tiles:insertAttribute name="body" />    
		</div>
		
		<div class="row">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/javascript.js" ></script>
	
</body>
</html>
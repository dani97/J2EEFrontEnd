<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="resources/css/reset.css">
	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	<link href="https://fonts.googleapis.com/css?family=Macondo|Open+Sans+Condensed:300" rel="stylesheet">
	<title>Records</title>
</head>
<body class="body">
	<nav class="main-nav">
		<a href="index.jsp" class="nav-links">Home</a>
		<a href="ArtistProfiles" class="nav-links">Show All Profiles</a>
		<a href="RecordsList" class="nav-links">Show All Records</a>
		<a href="CommentsTracker" class="nav-links">Get Insights From Comments</a>
		<a href="ShowGifts" class="nav-links">Show All Gifts</a>
	</nav>
	<div class="content">
		<div class="list-container-in" >
			 <c:forEach items="${records}" var="record">
			 	<div class="list-item" data-record = "${record.getRecordName()}">
			 		<span class="album-content" data-record="${record.getRecordName()}">${record.getRecordName()} </span>	
			 	</div>
			 </c:forEach>
		</div>
		<form action="GiftFans" method="post">
			<input type="number" name="limit" class="input text-box" placeholder="enter limit">
			<input type="text" id="record" name="record" class="input text-box" placeholder="select record title from record panel">
			<input type="submit" value="send Records" class="input"> 
		</form>
	</div>
	<script type="text/javascript" src="resources/js/gift.js"></script>
</body>
</html>
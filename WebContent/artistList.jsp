<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>List</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="resources/css/reset.css">
	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Macondo|Open+Sans+Condensed:300" rel="stylesheet">
	<script src="//cdn.jsdelivr.net/d3js/3.5.17/d3.min.js" charset="utf-8"></script>
	<script src="//cdn.jsdelivr.net/npm/taucharts@1/build/production/tauCharts.min.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/taucharts@1/build/production/tauCharts.min.css">
</head>
<body>
	<nav class="main-nav">
		<a href="index.jsp" class="nav-links">Home</a>
		<a href="ArtistProfiles" class="nav-links">Show All Profiles</a>
		<a href="RecordsList" class="nav-links">Show All Records</a>
		<a href="CommentsTracker" class="nav-links">Get Insights From Comments</a>
		<a href="ShowGifts" class="nav-links">Show All Gifts</a>
	</nav>
	<div class="content">
	    <div class="list-container" data-profile="linechart">
	        <c:forEach items="${artists}" var="artist">
	        <div class="list-item center" data-profile="${artist.getId()}">
	        	<c:set var="media" value="fa-${artist.getMediaName()}-square"/>
	        	<i class="fa ${media} fa-4x" aria-hidden="true" data-profile="${artist.getId()}"></i> <br>
	        	<span class="profile-id" data-profile="${artist.getId()}">
	        	@${artist.getProfileId()}
	        	${artist.getFanCount()} followers
	        	</span>
	        </div>
	        </c:forEach>	
	    </div>
	    <div id="my-chart">
	    </div>
	</div>
	<script src="resources/js/chart.js"></script>
</body>
</html>
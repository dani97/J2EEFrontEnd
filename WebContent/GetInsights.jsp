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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Macondo|Open+Sans+Condensed:300" rel="stylesheet">
	<script src="//cdn.jsdelivr.net/d3js/3.5.17/d3.min.js" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/taucharts@1/build/production/tauCharts.min.css">
	<title> Get Insights</title>
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
			<div class="list-container-in">
				 <input type="text" id="profile" class="input text-box" placeholder="select a profile">
				 <c:forEach items="${artists}" var="artist">
	        <div class="list-item-in" data-profile="${artist.getProfileId()}">
	        	<span class="list-content-in" data-profile="${artist.getProfileId()}">
	        	<c:set var="media" value="fa-${artist.getMediaName()}-square"/>
	        	<i class="fa ${media} fa-2x" aria-hidden="true" data-profile="${artist.getProfileId()}"></i> <br>
	        	@${artist.getProfileId()}<br>
	        	</span>
	        </div>
	        </c:forEach>
			</div>
			<div id="chart-area">
			</div>
			<div class="list-container-in">
				<input type="text" id="record" class="input text-box" placeholder="select a record">
				 <c:forEach items="${records}" var="record">
			 	<div class="list-item-in" data-record = "${record.getRecordName()}"> 
			 		<span class="list-content-in" data-record="${record.getRecordName()}">${record.getRecordName()} </span>	
			 	</div>
			 </c:forEach>
			</div>
		</div> 
</body>
<script src="resources/js/getinsights.js"></script>
<script src="//cdn.jsdelivr.net/npm/taucharts@1/build/production/tauCharts.min.js" type="text/javascript"></script>
</html>
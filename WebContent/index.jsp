<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Main menu</title>
</head>
<body class="body">
	<nav class="main-nav">
		<a href="index.jsp" class="nav-links">Home</a>
		<a href="ArtistProfiles" class="nav-links">Show All Profiles</a>
		<a href="RecordsList" class="nav-links">Show All Records</a>
		<a href="CommentsTracker" class="nav-links">Get Insights From Comments</a>
		<a href="ShowGifts" class="nav-links">Show All Gifts</a>
	</nav>
<form action="AddRecord" method="post" class="form" id="record-form">
	<div class="close-button pointer"><i class="fa fa-times color" id="closer" aria-hidden="true"></i></div>
	<fieldset>
	<legend class="color">Add Records</legend>
		<input type="text" name="recordName" class="form-input text-box" placeholder="enter record name" required><br>
		<input type="number" name="soldCopies" class="form-input text-box" placeholder="enter sold copies" required><br>
		<input type="date" name="releaseDate" class="form-input text-box" placeholder="enter release date" required><br>
		<select name="recordType" class="form-input text-box" required>
			<option value="album" class="black">album</option>
			<option value="ep" class="black">EP</option>
			<option value="single" class="black">Single</option>
		</select>
		<input type="submit" value="Add Record" class="form-input text-box pointer">
	</fieldset>
</form>
<div class="form-container">
	<div class="form-button" id="record-button">ADD RECORDS</div>
</div>
</body>
<script src="resources/js/index.js"></script>
</html>
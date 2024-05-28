<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome admin</title>
</head>
<body>
<h1>Admin Home Page</h1>
	<a href="changePasswordPage">Change Password</a>
	<br>
	<a href="newExamDetailsPage">New Exam</a>
	<br>
	<a href="addSubjectPage">Add subject</a>
	<br>
	<a href="updateSubjectPage">Update Subject</a>
	<br>
	<a href="addTeacherPage">Add teacher</a>
	<br>
	<a href="addNotificationPage">Add Notification</a>
	<br>
	<a href="updatenotifiPage">Update Notification</a>
	<br>
	<form action="/allot">
		<input type="submit" value="Make Allotment">
	</form>
	<a href="viewSeatAllotmentPage">View Seat Allotment</a>
	<br>
	<a href="verifyStudentPage">Verify Student</a>
	<br>
	<a href="seeExamDetailsPage">View Exam Details</a>
	<br>
</body>
</html>